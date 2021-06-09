package weatherForecast.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import weatherForecast.commonStorage.Constants;
import weatherForecast.commonStorage.SingleGlobalStorage;
import weatherForecast.entities.SimpleWeatherObj;
import weatherForecast.model.db.DataBaseProvider;
import weatherForecast.model.db.IDataBaseProvider;
import weatherForecast.model.weatherAPI.IWeatherProvider;
import weatherForecast.model.weatherAPI.WeatherResponse;

import java.util.List;

public class WeatherForecastController implements IWeatherForecastController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    //Сохраняем данные через синглтон
    @Override
    public void storeCityName(String cityName) throws Exception {
        simpleStringValidator(cityName);
        SingleGlobalStorage.getInstance().setCityName(cityName);
    }

    //Получаем ответ в "сырой" сроке
    @Override
    public String getRawWeatherForecast(String cityName) throws Exception {
        simpleStringValidator(cityName);

        IWeatherProvider weatherResponse = new WeatherResponse();
        String rawWeatherForecast = weatherResponse.getWeatherForecastFromAPI(cityName);

        //Проверку на не удачный ответ от сервера реализуем до попытки записи в БД
        if (!objectMapper.readTree(rawWeatherForecast).get("cod").asText().equals("200")) {
            throw new Exception("Плохой ответ от сервера");
        }

        return rawWeatherForecast;
    }


    @Override
    public void weatherForecastOptionalOutput(int chosenNumber) throws Exception {
        if (chosenNumber != 1 && chosenNumber != 2 ) {
            throw new Exception("Введено не верное число");
        }
        IDataBaseProvider dataBaseController = new DataBaseProvider();

        switch (chosenNumber) {
            case 1 -> prettyPrintWeatherForecastForFiveDays(getRawWeatherForecast(
                    SingleGlobalStorage.getInstance()
                            .getCityName()));
            case 2 -> {
                List<SimpleWeatherObj> simpleWeatherObjs = dataBaseController.readAllRowsFromDB(Constants.getTableName());
                for (SimpleWeatherObj a : simpleWeatherObjs) {
                    System.out.println("---------");
                    System.out.println(a);
                }
            }
        }

    }


    private void prettyPrintWeatherForecastForFiveDays (String rawWeatherForecast) throws Exception {
        simpleStringValidator(rawWeatherForecast);

        int forecastArrayLength; //API выводит количество объектов с с прогнозом
        IDataBaseProvider dataBaseController = new DataBaseProvider();
        List<SimpleWeatherObj> simpleWeatherObjs = dataBaseController.readAllRowsFromDB(Constants.getTableName());
        forecastArrayLength = Integer.parseInt(objectMapper.readTree(rawWeatherForecast).get("cnt").asText());

        //Так как у нас API выводит прогноз на каждые 3 часа в течении 5ти дней, возьмем шаг итеррации 8
        for (int i = 4; i < forecastArrayLength; i=i+8) {
            System.out.println("--------");
            System.out.printf("В городе %s на дату %s ожидается %s, температура - %s\n",
                    simpleWeatherObjs.get(i).getCity(), simpleWeatherObjs.get(i).getLocalDate()
                    , simpleWeatherObjs.get(i).getWeatherText(), simpleWeatherObjs.get(i).getTemperature());
        }

    }

    //Простая проверка вводимых строковвых аргументов
    private void simpleStringValidator(String string) throws Exception {
        if (string == null || string.isEmpty()) {
            throw new Exception("Введены пустые аргументы");
        }
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
