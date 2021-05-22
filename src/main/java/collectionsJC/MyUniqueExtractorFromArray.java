package collectionsJC;

import java.util.*;

public class MyUniqueExtractorFromArray <T> { //Решил сделать отдельным классом, вдрг чо потом добавить нужно будет

    private T[] array;

    public MyUniqueExtractorFromArray(T[] array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public Set<T> arrayToSet() {
        return new HashSet<>(Arrays.asList(array));
    }

    //Можно было бы выполнить часть следующих функций в ранере, через позвращаемое значение
    // , но если уж решил сделать свой класс, то почему бы не добавить ему полезных методов
    // , которые потом можно будет преиспользовать

    public void showUniqueArrayElements() {
        for (T t : arrayToSet()) { ///Тут IDEA предложила заменить пеализацию iterator-while на enhancedFor
            System.out.println(t);
        }
    }

    public int countUniqueArrayElements() {
        return arrayToSet().size();
    }


}
