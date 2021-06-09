package weatherForecast.model.db;

import weatherForecast.entities.SimpleWeatherObj;

import java.util.List;

public interface IDataBaseProvider {

    void writeToDB(String responseString);
    SimpleWeatherObj readOneRowFromDB(String tableName, int rowId);
    List<SimpleWeatherObj> readAllRowsFromDB(String tableName);

}
