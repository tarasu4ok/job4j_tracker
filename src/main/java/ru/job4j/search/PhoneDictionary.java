package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> findInName = (prs) -> prs.getName().contains(key);
        Predicate<Person> findInSurname = (prs) -> prs.getSurname().contains(key);
        Predicate<Person> findInAddress = (prs) -> prs.getAddress().contains(key);
        Predicate<Person> findInPhone = (prs) -> prs.getPhone().contains(key);
        Predicate<Person> combine = findInName.or(findInSurname).or(findInAddress).or(findInPhone);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
