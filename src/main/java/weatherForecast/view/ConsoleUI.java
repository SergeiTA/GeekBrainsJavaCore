package weatherForecast.view;

import weatherForecast.commonStorage.SingleGlobalStorage;

import java.util.InputMismatchException;


public class ConsoleUI implements IConsoleUI{

    private String cityInput;

    public ConsoleUI() {
        this.cityInput = null;
    }

    @Override
    public String getCityInput() {

        do {
            System.out.println("Введите название города");
            cityInput = SingleGlobalStorage.getInstance().getScanner().next(); //Вводим назание города на английском
        } while (!isCityInputCorrect(cityInput));

        System.out.println("Проверяем прогноз погоды на 5 дней для города " + cityInput);
        return cityInput;
    }

    //Метод для реализации меню выбора формы вывода
    @Override
    public int getModeOutput() {

        int modeNumber = 0;
        do {
            System.out.println("Введите 1 для краткого прогноза погоды на 5 дней");
            System.out.println("Введите 2 для подробного прогноза погоды на 5 дней с шагом в 3 часа");
            modeNumber = SingleGlobalStorage.getInstance().getScanner().nextInt(); //Вводим назание города на английском
        } while ( modeNumber != 1 && modeNumber != 2 );

        return modeNumber;
    }

    //Простая проверка названия города при вводе с консоли
    private Boolean isCityInputCorrect(String cityName) {
        if (cityName.length() <= 1 || cityName.isEmpty() || cityName == null) {
            System.out.println("Введено не верное название города");
            return false;
        }
        return true;
    }






}
