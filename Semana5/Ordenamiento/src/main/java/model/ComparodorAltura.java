package model;

import java.util.Comparator;

public class ComparodorAltura implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return (int)(o1.getAltura() - o2.getAltura());
    }
}
