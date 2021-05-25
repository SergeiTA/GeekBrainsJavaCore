package collectionsJC;
///Класс с тестовыми массивами уже созда, перенес в другой пакет, дополню этот класс новым массивом

import java.sql.Array;

public class TestArray {



    public final String[] repeatedStrings;

    {
        repeatedStrings = new String[15];

        repeatedStrings[0] = "Селиверстов Вячеслав Натанович";
        repeatedStrings[1] = "Суханов Влас Витальевич";
        repeatedStrings[2] = "Кошелев Тихон Федотович";
        repeatedStrings[3] = "Дмитриев Осип Юрьевич";
        repeatedStrings[4] = "Макаров Давид Вадимович";
        repeatedStrings[5] = "Исакова Юлиана Феликсовна";
        repeatedStrings[6] = "Быкова Неолина Иринеевна";
        repeatedStrings[7] = "Прохорова Инесса Кирилловна";
        repeatedStrings[8] = "Устинова Марианна Артёмовна";
        repeatedStrings[9] = "Соболева Элина Эдуардовна";
        repeatedStrings[10] = "Селиверстов Вячеслав Натанович"; //Дубль 1
        repeatedStrings[11] = "Селиверстов Вячеслав Натанович"; //Дубль 1
        repeatedStrings[12] = "Соболева Элина Эдуардовна"; //Дубль 9
        repeatedStrings[13] = "Соболева Элина Эдуардовна"; //Дубль 9
        repeatedStrings[14] = "Макаров Давид Вадимович"; //Дубль 4
    }


    public final String[][] stringArray;

    {
        stringArray = new String[4][4];

        stringArray[0][0] = "AAA";
        stringArray[0][1] = " 1 ";
        stringArray[0][2] = "0";
        stringArray[0][3] = "BBB";

        stringArray[1][0] = "2";
        stringArray[1][1] = "3";
        stringArray[1][2] = "4";
        stringArray[1][3] = "AAA";

        stringArray[2][0] = "5";
        stringArray[2][1] = "AAA";
        stringArray[2][2] = "6";
        stringArray[2][3] = "7";

        stringArray[3][0] = "AAA";
        stringArray[3][1] = "AAA";
        stringArray[3][2] = "8";
        stringArray[3][3] = "AAA";
    }

    //Массив для теста недостаточной длинны
    public final String[][] stringBadTinyArray;

    {
        stringBadTinyArray = new String[4][3];

        stringBadTinyArray[0][0] = "AAA";
        stringBadTinyArray[0][1] = "AAA";
        stringBadTinyArray[0][2] = "AAA";

        stringBadTinyArray[1][0] = "AAA";
        stringBadTinyArray[1][1] = "AAA";
        stringBadTinyArray[1][2] = "AAA";

        stringBadTinyArray[2][0] = "AAA";
        stringBadTinyArray[2][1] = "AAA";
        stringBadTinyArray[2][2] = "AAA";

        stringBadTinyArray[3][0] = "AAA";
        stringBadTinyArray[3][1] = "AAA";
        stringBadTinyArray[3][2] = "AAA";
    }

    //Массив для теста слишком большой длинны
    public final String[][] stringBadBigArray;

    {
        stringBadBigArray = new String[5][4];

        stringBadBigArray[0][0] = "AAA";
        stringBadBigArray[0][1] = "AAA";
        stringBadBigArray[0][2] = "AAA";
        stringBadBigArray[0][3] = "AAA";

        stringBadBigArray[1][0] = "AAA";
        stringBadBigArray[1][1] = "AAA";
        stringBadBigArray[1][2] = "AAA";
        stringBadBigArray[1][3] = "AAA";

        stringBadBigArray[2][0] = "AAA";
        stringBadBigArray[2][1] = "AAA";
        stringBadBigArray[2][2] = "AAA";
        stringBadBigArray[2][3] = "AAA";

        stringBadBigArray[3][0] = "AAA";
        stringBadBigArray[3][1] = "AAA";
        stringBadBigArray[3][2] = "AAA";
        stringBadBigArray[3][3] = "AAA";

        stringBadBigArray[4][0] = "AAA";
        stringBadBigArray[4][1] = "AAA";
        stringBadBigArray[4][2] = "AAA";
        stringBadBigArray[4][3] = "AAA";
    }






}
