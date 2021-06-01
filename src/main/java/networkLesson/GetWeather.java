package networkLesson;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
public class GetWeather {

    public static void main(String[] args) {

        String fiveDaysWeather = null;
        try {
            //Вернули JSON строку, дата возвращается в timestamp
            fiveDaysWeather = getFiveDaysForecastWeather("2.5", "onecall", "59.57", "30.19"
                    , "current,minutely,hourly", "818618af87b0c6bf36c750190bcc45b6");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(fiveDaysWeather);//Выводим в консоль для наглядности

        //Для человекочитаемого вывода JSON со сложной структурой можно воспользоваться GSON
        // или перейти с OkHTTP на RestAssured c import io.restassured.response.Response (там есть хороший .prettyPrint)
        // но это вне области ДЗ, для обработки fiveDaysWeather человекочитаемость не обязательна

    }



    private static String getFiveDaysForecastWeather(String apiVersion, String mode
            , String latitude, String longitude, String exclude, String apiKey) throws IOException {

        OkHttpClient okHttpClient = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
            .scheme("https")
            .host("api.openweathermap.org")
            .addPathSegment("data")
            .addPathSegment(apiVersion)
            .addPathSegment(mode)
            .addQueryParameter("lat", latitude)  //Географическая широта
            .addQueryParameter("lon", longitude) //Географическая долгота
            .addQueryParameter("exclude", exclude) //Исключаем часть отчетов
            .addQueryParameter("appid", apiKey) //Токен для зарегистрированного приложения
            .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        return response.body().string();
    }



}
