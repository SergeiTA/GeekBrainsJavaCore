package weatherForecast.controller;

public interface IWeatherForecastController {

    void storeCityName(String cityName) throws Exception;
    String getRawWeatherForecast(String rawWeatherForecast) throws Exception;
    void prettyPrintFiveDaysWeatherForecast(String rawWeatherForecast) throws Exception;

}
