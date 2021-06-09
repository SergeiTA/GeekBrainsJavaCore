package weatherForecast;

import weatherForecast.commonStorage.Constants;
import weatherForecast.commonStorage.SingleGlobalStorage;
import weatherForecast.controller.IWeatherForecastController;
import weatherForecast.controller.WeatherForecastController;
import weatherForecast.model.db.DataBaseProvider;
import weatherForecast.model.db.IDataBaseProvider;
import weatherForecast.view.ConsoleUI;
import weatherForecast.view.IConsoleUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class WeatherForecastRunner {

    static {
        try {
           Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {
            initDB(Constants.getDbName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        IConsoleUI consoleUI = new ConsoleUI();
        IWeatherForecastController weatherForecastController = new WeatherForecastController();
        IDataBaseProvider dataBaseController = new DataBaseProvider();
        String rawWeatherForecast;

        try {

            weatherForecastController.storeCityName(consoleUI.getCityInput());
            rawWeatherForecast = weatherForecastController
                    .getRawWeatherForecast(SingleGlobalStorage.getInstance().getCityName());
            dataBaseController.writeToDB(rawWeatherForecast);
            weatherForecastController.weatherForecastOptionalOutput(consoleUI.getModeOutput());

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Так как у нас Connection общий и находиться в синглтоне, вызываю его закрытие из ранера в конце кода
        // Statement и ResultSet закрываю непосредственно в провайдере
        try {
            SingleGlobalStorage.getInstance().connectionClose();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private static void initDB(String dbName) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
        SingleGlobalStorage.getInstance().setConnection(connection);
    }

}
