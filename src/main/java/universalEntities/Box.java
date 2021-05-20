package universalEntities;

import universalEntities.fruits.Fruit;

import java.util.Arrays;

public class Box <T extends Fruit> {

    private T[] bunchOfFruits;

    public Box(T... bunchOfFruits) {
        this.bunchOfFruits = bunchOfFruits;
    }


    public float getWeight() {
        return bunchOfFruits.length * bunchOfFruits[0].getFruitWeight();
    }

    public Boolean compare(Box<?> anotherBox) {
        return this.getWeight() == anotherBox.getWeight();
    }

    public void replaceFruitsFromTheBox(Box<T> sameTypeBox) {
        T[] tempArray = Arrays.copyOf(bunchOfFruits, bunchOfFruits.length + sameTypeBox.bunchOfFruits.length);

        System.arraycopy(sameTypeBox.bunchOfFruits, 0, tempArray
                , bunchOfFruits.length, sameTypeBox.bunchOfFruits.length);

        bunchOfFruits = Arrays.copyOf(tempArray, tempArray.length);
    }

    public void addFruit(T addedFruit) {
        bunchOfFruits = Arrays.copyOf(bunchOfFruits, bunchOfFruits.length + 1);
        bunchOfFruits[bunchOfFruits.length-1] = addedFruit;
    }

    public void boxPrint() {
        System.out.println(Arrays.toString(bunchOfFruits));
    }

}
