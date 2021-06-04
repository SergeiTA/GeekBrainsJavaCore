package weatherForecast.commonStorage;

//Синглтон для хранения введенного названия города
public final class CityNameHolder {

    private static CityNameHolder INSTANCE;
    private String cityName;

    private CityNameHolder() {
        this.cityName = null;
    }

    public static CityNameHolder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CityNameHolder();
        }
        return INSTANCE;
    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
