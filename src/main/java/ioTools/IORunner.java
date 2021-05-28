package ioTools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class IORunner {

    public static void main(String[] args) {

        File file = new File("src/main/resources/somecsv.csv");

        randomFillingCSV(file);

        MyReader myReader = new MyReader(file);

        AppData appData = new AppData(myReader.getHeaders(), myReader.getValues());

        //Отразим значения CSV переведенного в экземпляр appData в консоли для наглядности
        //Удобно сравнивать вновь сшенерированный состав CSV с консолью при каждом новом ране
        appData.printTable();

    }

    //Особой конкретики по пункту записи в CSV в ДЗ нет, по этому воспользуемся рандомайзером
    private static void randomFillingCSV(File file) {
        if (file == null) {
            System.out.println("File не может быть null");
            return;
        }
        Random random = new Random();
        int columnsNumber = random.nextInt(5) + 3;
        int rowsNumber = random.nextInt(3) + 3;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < columnsNumber + 1; i++) {
                writer.write("Header # " + (i + 1));
                if (i != columnsNumber) writer.write(",");//Понимаю, что лучше ставить {} но так выглядит акуратнее
            }
            writer.newLine();

            for (int i = 0; i < rowsNumber + 1; i++) {
                for (int j = 0; j < columnsNumber + 1; j++) {
                    //Выставил числа не меншье 100 осознано, для большего соотвтетсвия примеру в ДЗ
                    writer.write(String.valueOf(random.nextInt(100) + 100));
                    if (j != columnsNumber) writer.write(",");
                }
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
