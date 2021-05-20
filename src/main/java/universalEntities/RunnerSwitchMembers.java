package universalEntities;

public class RunnerSwitchMembers {

    public static void main(String[] args) {

        //Пара простых массивов для проверки сортировки
        SwitchMembers<String> testString = new SwitchMembers<>("один", "два", "три", "четыре");
        testString.switchArrayMembers(1, 2);

        System.out.println("<------------------->");

        SwitchMembers<Integer> testInteger = new SwitchMembers<>(1, 2, 3, 4, 5);
        testInteger.switchArrayMembers(0, 4);


    }

}
