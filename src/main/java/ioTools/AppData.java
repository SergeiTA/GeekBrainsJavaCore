package ioTools;

public class AppData {

    private String[] header;
    private int[][] data;


    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

   //Переопределять toString с красивым выводом одномерного и двухмерного массива будет не удобно
   //По этому опишу простой вывод в консоль
    public void printTable() {
        if (header == null || data == null) {
            System.out.println("Заголовок и данные не могут быть null");
            return;
        }
        for (String headerElement : header) {
            System.out.print(headerElement + "  ");
        }
        System.out.println("");
        for (int[] line : data) {
            for (int i : line) {
                System.out.print(i + "  ");
            }
            System.out.println("");
        }
    }
}
