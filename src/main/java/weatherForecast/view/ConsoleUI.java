package weatherForecast.view;

import java.util.Scanner;

public class ConsoleUI implements IConsoleUI{

    private String cityInput;

    public ConsoleUI() {
        this.cityInput = null;
    }

    @Override
    public String getCityInput() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Введите название города");
            cityInput = scanner.next(); //Вводим назание города на английском
        } while (!isCityInputCorrect(cityInput));

        scanner.close();
        System.out.println("Проверяем прогноз погоды на 5 дней для города " + cityInput);
        return cityInput;
    }

    //Простая проверка названия города при вводе с консоли
    private Boolean isCityInputCorrect(String cityName) {
        if (cityName.length() <= 1 || cityName.isEmpty() || cityName ==null) {
            System.out.println("Введено не верное название города");
            return false;
        }
        return true;
    }




}
