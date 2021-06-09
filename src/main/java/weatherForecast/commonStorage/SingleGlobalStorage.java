package weatherForecast.commonStorage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

//Синглтон для хранения введенного названия города
public final class SingleGlobalStorage {

    private static SingleGlobalStorage INSTANCE;
    private String cityName;
    private Connection connection;
    //По какой то причине не корректно работали и закрыавлись разнве экземпляры сканеров в ConsoleUI.getCityInput
    // и ConsoleUI.getModeOutput, не смотря на разное имя и ограниченнсть внутри отдельных методов
    // для каждого из экземпляров. По этому было решено сделать один сканер на и закрывать его из ранера
    private final Scanner scanner;

    private SingleGlobalStorage() {
        this.cityName = null;
        this.scanner = new Scanner(System.in);
    }

    public static SingleGlobalStorage getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SingleGlobalStorage();
        }
        return INSTANCE;
    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void connectionClose() throws SQLException {
        this.connection.close();
    }
}
