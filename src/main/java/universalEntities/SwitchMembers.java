package universalEntities;

import java.util.Arrays;

public class SwitchMembers <T> {

    private final T[] array;
    private T container;


    @SafeVarargs
    public SwitchMembers(T... array) {
        this.array = array;
        this.container = array[0];
    }

    public void switchArrayMembers(int firstPosition, int secondPosition) {
        if (firstPosition < 0 || secondPosition < 0
                || firstPosition >= array.length || secondPosition >= array.length) {
            throw new RuntimeException("Указанные индексы выходят за границы массива");
        }

        if (array.length < 3) {
            throw new RuntimeException("Массив должен быть длинной не менее \"2\"");
        }

        System.out.println("Массив до изменений");
        System.out.println(Arrays.toString(array));

        container = array[firstPosition];
        array[firstPosition] = array[secondPosition];
        array[secondPosition] = container;

        System.out.println("--------------------------");
        System.out.println("Массив после изменений");
        System.out.println(Arrays.toString(array));


    }

}
