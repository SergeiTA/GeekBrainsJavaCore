package collectionsJC;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {

    private Set<String> phoneSet = null;
    private Map<String, Set<String>> phoneBook;


    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }


    public Map<String, Set<String>> getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(Map<String, Set<String>> phoneBook) {
        this.phoneBook = phoneBook;
    }

    //Не стал добавлять гетеры и сетеры для phoneSet, так как есть сомнения, что кому-то нужны телефоны без фамилий

    public void add(String surname, String phoneNumberAsString) {
        if (surname == null || phoneNumberAsString == null) {
            System.out.println("ФИО и номер телефона должны быть заполнены");
            return;
        }

        if ( phoneSet == null || !(phoneBook.containsKey(surname)) ) {
            phoneSet = new HashSet<>();
            phoneSet.add(phoneNumberAsString);
        } else {
            phoneSet = phoneBook.get(surname);
            phoneSet.add(phoneNumberAsString);
        }

        phoneBook.put(surname, phoneSet);
    }

    public Set<String> get(String surname) {
        if (surname == null ) {
            System.out.println("ФИО и номер телефона должны быть заполнены");
            return null;
        }
        return phoneBook.get(surname);
    }



}
