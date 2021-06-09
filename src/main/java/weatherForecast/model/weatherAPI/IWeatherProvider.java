package weatherForecast.model.weatherAPI;

public interface IWeatherProvider {

    String getWeatherForecastFromAPI(String cityiD) throws Exception;


}
