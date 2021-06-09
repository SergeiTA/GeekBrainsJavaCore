package weatherForecast.model.db;

import weatherForecast.commonStorage.Constants;
import weatherForecast.commonStorage.SingleGlobalStorage;
import weatherForecast.controller.WeatherForecastController;
import weatherForecast.entities.SimpleWeatherObj;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//Класс, отвечающий за взаимодействие с БД
public class DataBaseProvider implements IDataBaseProvider{

    private static Statement statement;

    @Override
    public void writeToDB(String responseString) {
        try {
            simpleStringValidator(responseString);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            statement = SingleGlobalStorage.getInstance().getConnection().createStatement();
            dropTable(Constants.getTableName());
            createTable(Constants.getTableName());
            tableWriterFromStringJSON(responseString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Не прописал в try() т.к. тут нужно использовать и за одно удобно закрывать общую переменную для класса
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    @Override
    public SimpleWeatherObj readOneRowFromDB(String tableName, int rowId) {
        try {
            simpleStringValidator(tableName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SimpleWeatherObj simpleWeatherObj = null;
        String sqlQuery = String.format(Locale.US, "SELECT * FROM %s WHERE id = %d", tableName, rowId);

        //Что бы не прописывать лишнего в finally указываю Statement и ResultSet в аргументах try()
        try (
                Statement statement = SingleGlobalStorage.getInstance().getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery(sqlQuery)
        ){

            simpleWeatherObj = new SimpleWeatherObj(
                    resultSet.getString("city"),
                    resultSet.getString("localDate"),
                    resultSet.getString("weatherText"),
                    resultSet.getString("temperature")
            );

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return simpleWeatherObj;
    }


    @Override
    public List<SimpleWeatherObj> readAllRowsFromDB(String tableName) {
        try {
            simpleStringValidator(tableName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<SimpleWeatherObj> simpleWeatherObjs = null;
        String sqlQuery = String.format(Locale.US, "SELECT * FROM %s", tableName);

        //Что бы не прописывать лишнего в finally указываю Statement и  ResultSet в аргументах try()
        try (
                Statement statement = SingleGlobalStorage.getInstance().getConnection().createStatement();
                ResultSet resultSet = statement.executeQuery(sqlQuery);
            ){
            simpleWeatherObjs = new ArrayList<>();

            while (resultSet.next()) {
                simpleWeatherObjs.add(new SimpleWeatherObj(
                        resultSet.getString("city"),
                        resultSet.getString("localDate"),
                        resultSet.getString("weatherText"),
                        resultSet.getString("temperature")
                ));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return simpleWeatherObjs;
    }

    private void dropTable(String tableName) throws Exception {
        simpleStringValidator(tableName);
        String sqlQuery = String.format(Locale.US, "DROP TABLE IF EXISTS %s", tableName);
        statement.executeUpdate(sqlQuery);
    }

    private void createTable(String tableName) throws Exception {
        simpleStringValidator(tableName);
        String sqlQuery = String.format(Locale.US, "CREATE TABLE IF NOT EXISTS %s (id INTEGER PRIMARY KEY AUTOINCREMENT, city TEXT, localDate TEXT, weatherText TEXT, temperature TEXT)", tableName);
        statement.executeUpdate(sqlQuery);
    }

    private void tableWriterFromStringJSON (String responseString) throws Exception {
        simpleStringValidator(responseString);
        //Проверку на успешный ответ организовал в WeatherForecastController.getRawWeatherForecast
        WeatherForecastController weatherForecastController = new WeatherForecastController();

        int forecastArrayLength; //API выводит количество объектов с с прогнозом
        List<String> date, weatherType, temperature;

        forecastArrayLength = Integer.parseInt(weatherForecastController.getObjectMapper()
                .readTree(responseString).get("cnt").asText());
        date = weatherForecastController.getObjectMapper().readTree(responseString)
                .get("list").findValuesAsText("dt_txt");
        weatherType = weatherForecastController.getObjectMapper().readTree(responseString)
                .get("list").findValuesAsText("description");
        temperature = weatherForecastController.getObjectMapper().readTree(responseString)
                .get("list").findValuesAsText("temp");

        SingleGlobalStorage.getInstance().getConnection().setAutoCommit(false);
        for (int i = 0; i < forecastArrayLength; i++) {

            String sqlQuery = writeQueryStringConstructor(
                    Constants.getTableName(),
                    SingleGlobalStorage.getInstance().getCityName(),
                    date.get(i),
                    weatherType.get(i),
                    temperature.get(i));

            statement.executeUpdate(sqlQuery);
        }

        SingleGlobalStorage.getInstance().getConnection().commit();
        SingleGlobalStorage.getInstance().getConnection().setAutoCommit(true);
    }


    private String writeQueryStringConstructor (String tableName, String firstColumn, String secondColumn
                                                , String thirdColumn, String fourthColumn) throws Exception {
        simpleStringValidator(tableName);//На этом этапе важно, что бы только имя таблицы не было пустым
        return String
                .format(Locale.US, "INSERT INTO %s (city, localDate, weatherText, temperature) VALUES ('%s', '%s', '%s', '%s')"
                        , tableName, firstColumn, secondColumn, thirdColumn, fourthColumn);
    }


    //Простая проверка вводимых строковвых аргументов
    private void simpleStringValidator(String string) throws Exception {
        if (string == null || string.isEmpty()) {
            throw new Exception("Введены пустые аргументы");
        }
    }
}
