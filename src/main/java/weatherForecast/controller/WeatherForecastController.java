package weatherForecast.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import weatherForecast.commonStorage.CityNameHolder;
import weatherForecast.model.IWeatherProvider;
import weatherForecast.model.WeatherResponse;

import java.util.List;

public class WeatherForecastController implements IWeatherForecastController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    //Сохраняем данные через синглтон
    @Override
    public void storeCityName(String cityName) throws Exception {
        simpleStringValidator(cityName);
        CityNameHolder.getInstance().setCityName(cityName);
    }

    //Получаем ответ в "сырой" сроке
    @Override
    public String getRawWeatherForecast(String cityName) throws Exception {
        simpleStringValidator(cityName);

        IWeatherProvider weatherResponse = new WeatherResponse();
        String rawWeatherForecast = weatherResponse.getWeatherForecastFromAPI(cityName);

        if (!objectMapper.readTree(rawWeatherForecast).get("cod").asText().equals("200")) {
            throw new Exception("Плохой ответ от сервера");
        }

        return rawWeatherForecast;
    }

    //Выводим удобочитаемый прогноз погоды на 5 дней
    @Override
    public void prettyPrintFiveDaysWeatherForecast(String rawWeatherForecast) throws Exception {
        simpleStringValidator(rawWeatherForecast);

        int forecastArrayLength; //API выводит количество объектов с с прогнозом
        List<String> date, weatherType, temperature;

        forecastArrayLength = Integer.parseInt(objectMapper.readTree(rawWeatherForecast).get("cnt").asText());
        date = objectMapper.readTree(rawWeatherForecast).get("list").findValuesAsText("dt_txt");
        weatherType = objectMapper.readTree(rawWeatherForecast).get("list").findValuesAsText("description");
        temperature = objectMapper.readTree(rawWeatherForecast).get("list").findValuesAsText("temp");

        //Так как у нас API выводит прогноз на каждые 3 часа в течении 5ти дней, возьмем шаг итеррации 8
        for (int i = 4; i < forecastArrayLength; i=i+8) {
            System.out.println("--------");
            System.out.printf("В городе %s на дату %s ожидается %s, температура - %s\n",
                    CityNameHolder.getInstance().getCityName(), date.get(i), weatherType.get(i), temperature.get(i));
        }

    }

    //Простая проверка вводимых строковвых аргументов
    private void simpleStringValidator(String string) throws Exception {
        if (string == null || string.isEmpty()) {
            throw new Exception("Введены пустые аргументы");
        }
    }

}
