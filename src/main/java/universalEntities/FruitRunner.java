package universalEntities;

import universalEntities.fruits.Apple;
import universalEntities.fruits.Orange;

public class FruitRunner {

    public static void main(String[] args) {

        addNewFruit(); //Добавляем фрукт в коробку

        System.out.println("------------------");

        replaceFruits(); //Пересыпаем

        System.out.println("------------------");

        compareBoxes();//Сравниваем вес



    }

    //В ДЗ такого условия, но логически понятно, что при пересыпании в коробке "доноре" фруктов остаться не должно
    //Сделать это можно (не прибегая к static) можно из класса, где был создан этот экземпляр Box<t>
    public static void replaceFruits () {
        Box<Apple> appleBox2 = new Box<>(new Apple(), new Apple());
        Box<Apple> appleBox3 = new Box<>(new Apple(), new Apple(), new Apple());
        System.out.println("Коробки до пересыпания фруктов");
        appleBox2.boxPrint();
        appleBox3.boxPrint();
        appleBox2.replaceFruitsFromTheBox(appleBox3);
        System.out.println("Коробка после пересыпания фруктов");
        appleBox3.nullBox();
        appleBox2.boxPrint();

        //Пересыпать апельсины с фруктами не даст комилятор
        /*Box<Orange> orangeBox1 = new Box<>(new Orange(), new Orange(), new Orange());
        appleBox2.replaceFruitsFromTheBox(orangeBox1);*/
    }


    public static void compareBoxes() {
        Box<Apple> appleBox1 = new Box<>(new Apple(), new Apple(), new Apple());
        Box<Orange> orangeBox1 = new Box<>(new Orange(), new Orange(), new Orange());
        System.out.print("Сравниваем разные коробки --> ");
        System.out.print(appleBox1.compare(orangeBox1) + "\n");
        System.out.print("Сравниваем одинаковые коробки --> ");
        System.out.print(appleBox1.compare(appleBox1) + "\n");
    }


    public static void addNewFruit() {
        Box<Apple> appleBox1 = new Box<>(new Apple(), new Apple(), new Apple());
        System.out.println("Коробка до добавления");
        appleBox1.boxPrint();

        appleBox1.addFruit(new Apple());
        System.out.println("Коробка после добавления");
        appleBox1.boxPrint();
    }


}
