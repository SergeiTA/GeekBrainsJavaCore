package weatherForecast.commonStorage;

//Решил для удобства вывести константы в одно место
public class Constants {

    private static final String DEFAULT_PROTOCOL = "https";
    private static final String OPEN_WEATHER_HOST = "api.openweathermap.org";
    private static final String FIRST_PATH_ELEMENT = "data";
    private static final String API_VERSION = "2.5";
    private static final String MODE_FIVE_DAYS = "forecast";
    private static final String METRIC_SYSTEM = "metric";
    private static final String ONLY_DAILY = "current,minutely,hourly";
    private static final String API_KEY = "818618af87b0c6bf36c750190bcc45b6";

    public static String getDefaultProtocol() {
        return DEFAULT_PROTOCOL;
    }

    public static String getOpenWeatherHost() {
        return OPEN_WEATHER_HOST;
    }

    public static String getFirstPathElement() {
        return FIRST_PATH_ELEMENT;
    }

    public static String getApiVersion() {
        return API_VERSION;
    }

    public static String getModeFiveDays() {
        return MODE_FIVE_DAYS;
    }

    public static String getMetricSystem() {
        return METRIC_SYSTEM;
    }

    public static String getOnlyDaily() {
        return ONLY_DAILY;
    }

    public static String getApiKey() {
        return API_KEY;
    }
}
