package weatherForecast.controller;

public interface IWeatherForecastController {

    void storeCityName(String cityName) throws Exception;
    String getRawWeatherForecast(String rawWeatherForecast) throws Exception;
    void weatherForecastOptionalOutput(int chosenNumber) throws Exception;

}
