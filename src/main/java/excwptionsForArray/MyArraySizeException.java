package excwptionsForArray;

public class MyArraySizeException extends IndexOutOfBoundsException{


    public MyArraySizeException() {
        super("Не верный размер массива, требуется ввести массив 4х4");
    }



}
