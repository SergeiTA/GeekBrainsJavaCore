package collectionsJC;


public class CollectionHWRunner {

    private static PhoneBook phoneBook;

    public static void main(String[] args) {

        TestArray testArray = new TestArray();
        MyUniqueExtractorFromArray<String> myUniqueExtractorFromArray =
                new MyUniqueExtractorFromArray<>(testArray.repeatedStrings);


        System.out.println("Печатаем массив в консоль без дубликатов ------------------>");
        myUniqueExtractorFromArray.showUniqueArrayElements();
        System.out.println("<------------------");

        System.out.println("Печатаем количество уникальных значений массива в консоль ------------------>");
        System.out.println(myUniqueExtractorFromArray.countUniqueArrayElements());
        System.out.println("<------------------");

        createSamplePhoneBook ();//Создаем и заполняем тестовую телефонную книгу
        System.out.println("Печатаем телефонные номера Иванова в консоль ------------------>");
        System.out.println(phoneBook.get("Иванов"));
        System.out.println("<------------------");

        System.out.println("Печатаем телефонные номера Петрова в консоль ------------------>");
        System.out.println(phoneBook.get("Петров"));
        System.out.println("<------------------");

        System.out.println("Печатаем телефонные номера Сидорова в консоль ------------------>");
        System.out.println(phoneBook.get("Сидоров"));
        System.out.println("<------------------");

    }


    private static PhoneBook createSamplePhoneBook () {
        phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "1-111-1111-11-11");
        phoneBook.add("Петров", "2-222-2222-22-22");
        phoneBook.add("Сидоров", "3-333-3333-33-33");
        phoneBook.add("Иванов", "4-444-4444-44-44");
        phoneBook.add("Сидоров", "5-555-5555-55-55");
        return phoneBook;
    }






}
