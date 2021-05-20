package universalEntities;

import universalEntities.fruits.Fruit;

import java.util.Arrays;

public class Box <T extends Fruit> {

    private T[] bunchOfFruits;

    @SafeVarargs
    public Box(T... bunchOfFruits) {
        this.bunchOfFruits = bunchOfFruits;
    }


    public float getWeight() {
        return bunchOfFruits.length * bunchOfFruits[0].getFruitWeight();
    }

    public Boolean compare(Box<?> anotherBox) {
        if (anotherBox == null) {
            System.out.println("Аргумент = null");
            return false;
        }
        return this.getWeight() == anotherBox.getWeight();
    }

    public void replaceFruitsFromTheBox(Box<T> sameTypeBox) {
        if (sameTypeBox == null) {
            System.out.println("Аргумент = null");
            return;
        }
        T[] tempArray = Arrays.copyOf(bunchOfFruits, bunchOfFruits.length + sameTypeBox.bunchOfFruits.length);

        System.arraycopy(sameTypeBox.bunchOfFruits, 0, tempArray
                , bunchOfFruits.length, sameTypeBox.bunchOfFruits.length);

        bunchOfFruits = Arrays.copyOf(tempArray, tempArray.length);
    }

    public void addFruit(T addedFruit) {
        if (addedFruit == null) {
            System.out.println("Аргумент = null");
            return;
        }
        bunchOfFruits = Arrays.copyOf(bunchOfFruits, bunchOfFruits.length + 1);
        bunchOfFruits[bunchOfFruits.length-1] = addedFruit;
    }

    public void boxPrint() {
        System.out.println(Arrays.toString(bunchOfFruits));
    }

    public void nullBox() {
        bunchOfFruits = null;
    }

}
