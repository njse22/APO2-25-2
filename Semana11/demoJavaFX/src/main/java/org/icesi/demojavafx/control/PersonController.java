package org.icesi.demojavafx.control;

import org.icesi.demojavafx.model.Person;

import java.util.ArrayList;

public class PersonController {
    private ArrayList<Person> people;

    public PersonController() {
        people = new ArrayList<>();
    }

    public void createPerson(String name){
        Person p = new Person(name);
        people.add(p);
    }

    public ArrayList<Person> getPeople() {
        return people;
    }
}
