package ioTools;

import java.io.*;
import java.util.Arrays;

public class MyReader {

    private File file;

    public MyReader(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getAmountOfLinesWithoutHeader() {
        if (file == null) {
            throw new IllegalArgumentException("File не может быть null");
        }
        int deepCount = 0; //количество строк в файле без заголовка
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            while ( reader.readLine() != null ) {
                deepCount += 1;//Считаем количество проходов реадера по строкам
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deepCount - 1;// Вычтем одну линию, что бы не брать заголовок в расчет
    }


    public int getAmountOfColumns() {
        int lengthCount; //количество элементов заголовка
        lengthCount = getSolidHeader().split(",").length;//смотрим длину строки, разбитой по разделителю ","
        return lengthCount;
    }


    //Массив заголовков для использования в конструкторе AppData
    public String[] getHeaders() {
        String[] headers;
        headers = getSolidHeader().split(",");
        return headers;
    }


    //Массив значений для использования в конструкторе AppData
    public int[][] getValues() {
        if (file == null) {
            throw new IllegalArgumentException("File не может быть null");
        }
        int[][] values = new int[getAmountOfLinesWithoutHeader()][getAmountOfColumns()];
        int i = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine();
            String tempString;
            while ( (tempString = reader.readLine()) != null) {
                //Эту строку взял со StackOverFlow как интересную замену циклу
                // , в цикле ни чего нового нет, а здесь возможность попробовать что то более технологичное
                values [i] = Arrays.stream(tempString.split(",")).mapToInt(Integer::parseInt).toArray();
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return values;

    }


    //Будем переиспользовать только внутри этого класса
    private String getSolidHeader() {
        if (file == null) {
            throw new IllegalArgumentException("File не может быть null");
        }
        String solidHeader = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            solidHeader = reader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return solidHeader;
    }

}
