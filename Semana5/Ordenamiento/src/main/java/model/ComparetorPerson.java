package model;

import java.util.Comparator;

public class ComparetorPerson implements Comparator<Person> {


    @Override
    public int compare(Person p1, Person p2){
        return p1.getLastName().compareTo(p2.getLastName());
    }
}
