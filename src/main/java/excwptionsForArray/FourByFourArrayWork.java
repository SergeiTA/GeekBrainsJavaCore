package excwptionsForArray;


import collectionsJC.TestArray;

public class FourByFourArrayWork {

    public static void main(String[] args) {

        TestArray testArray= new TestArray();

        arrayCount(testArray.stringArray);
        //Массивы для проверок на длину
        //arrayCount(testArray.stringBadBigArray);
        //arrayCount(testArray.stringBadTinyArray);
    }



    private static void arrayCount(String[][] stringArray) {
        int arrayAmount = 0;
        arraySizeCheck(stringArray);

        for (String[] strings : stringArray) {
            for (int j = 0; j < stringArray.length; j++) {
                try {
                   arrayAmount += convertStringToInt(strings[j]);
                } catch (MyArrayDataException exception) {
                    exception.printStackTrace();
                }
            }
        }
        System.out.println("Общая сумма приведенных чисел = " + arrayAmount);
    }

  //Следующий метод контр продуктивен, но иначе по какой-то причине MyArrayDataException, который просто наследуется
  //от NumberFormatException не вызывается, не прерывая выполнение кода во время возникновения исключения.
  //Если в строке 27 просто вписать суперкласс NumberFormatException - все работает без проблем,
  // и дополнительных throw new.
  // Пробовал переопределять полностью все методы и конструкты NumberFormatException
  //, пробовал копировать состав родителя NumberFormatException с наследованием от IllegalArgumentException
  //, чтобы полностью заменить NumberFormatException (Который без проблем работает в 27й строке) на MyArrayDataException
  //Уточнял возможные пути решения у преподавателя перед сдачей ДЗ
    private static int convertStringToInt(String s) throws MyArrayDataException {
        int am = 0;
        try{
            am = Integer.parseInt(s);
        }catch (NumberFormatException e){
            e.printStackTrace();
            throw new MyArrayDataException();
        }
        return am;
    }


    private static void arraySizeCheck (String[][] stringArray ){
        if (stringArray.length != 4) {
            throw new MyArraySizeException();
        } else {
            for (String[] strings : stringArray) {
                if (strings.length != 4) {
                    throw new MyArraySizeException();
                }
            }
        }
    }
}
