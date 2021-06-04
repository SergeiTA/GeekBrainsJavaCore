package weatherForecast.model;

public interface IWeatherProvider {

    String getWeatherForecastFromAPI(String cityiD) throws Exception;


}
