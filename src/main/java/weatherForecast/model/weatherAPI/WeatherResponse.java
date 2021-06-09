package weatherForecast.model.weatherAPI;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import weatherForecast.commonStorage.Constants;

//Имя класса выбрано по требованию в описании ДЗ
public class WeatherResponse implements IWeatherProvider{


    @Override
    public String getWeatherForecastFromAPI(String city) throws Exception {
        simpleStringValidator(city);
        OkHttpClient okHttpClient = new OkHttpClient();

        //используемый API позволяет вводить сразу имя города, да могут быть неточности с одноименными городами
        // , которые можно сгладить фильтрацияе по геолокации и уточнением региона/страны/штата
        // (у этого API есть доп привязка к штатам). Но ДЗ не предполагает таких уточнений, в противном случае
        // я бы десериализовывал ответы в сложные (относительно) классы и работал бы с ними

        Request request = new Request.Builder()
                .url(getURL(
                        Constants.getDefaultProtocol(),
                        Constants.getOpenWeatherHost(),
                        Constants.getFirstPathElement(),
                        Constants.getApiVersion(),
                        Constants.getModeFiveDays(),
                        city,
                        Constants.getMetricSystem(),
                        Constants.getApiKey()
                ))
                .build();

        Response response = okHttpClient.newCall(request).execute();

        return response.body().string();
    }

    //Конструктор URL, в будущем можно кастомизировать и перегружать
    private HttpUrl getURL(String protocol, String hostName, String pathElement,
                           String apiVersion, String mode, String cityID, String measurementSystem, String apiKey) {

        return new HttpUrl.Builder()
                .scheme(protocol)
                .host(hostName)
                .addPathSegment(pathElement)
                .addPathSegment(apiVersion)
                .addPathSegment(mode)
                .addQueryParameter("q", cityID)  //Id города
                .addQueryParameter("units", measurementSystem)  //Id города
                .addQueryParameter("appid", apiKey) //Токен для зарегистрированного приложения
                .build();
    }


    //Простая проверка вводимых строковвых аргументов
    private void simpleStringValidator(String string) throws Exception {
        if (string == null || string.isEmpty()) {
            throw new Exception("Введены пустые аргументы");
        }
    }


}
