package weatherForecast;

import weatherForecast.commonStorage.CityNameHolder;
import weatherForecast.controller.IWeatherForecastController;
import weatherForecast.controller.WeatherForecastController;
import weatherForecast.view.ConsoleUI;
import weatherForecast.view.IConsoleUI;


public class WeatherForecastRunner {

    public static void main(String[] args) {
        IConsoleUI consoleUI = new ConsoleUI();
        IWeatherForecastController weatherForecastController = new WeatherForecastController();
        String rawWeatherForecast;

        try {
            weatherForecastController.storeCityName(consoleUI.getCityInput());
            rawWeatherForecast = weatherForecastController.getRawWeatherForecast(CityNameHolder.getInstance().getCityName());
            weatherForecastController.prettyPrintFiveDaysWeatherForecast(rawWeatherForecast);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
