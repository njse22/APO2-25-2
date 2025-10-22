package org.icesi.demofx2.control;

import org.icesi.demofx2.model.Person;

import java.util.ArrayList;

public class PersonController {

    private static PersonController instance;

    private ArrayList<Person> people;

    private PersonController() {
        people = new ArrayList<>();
    }

    public static PersonController getInstance() {
        if (instance == null){
            instance = new PersonController();
        }
        return instance;
    }

    public void registerPerson(String name, int age){
        Person p = new Person(name, age);
        people.add(p);
    }

    public ArrayList<Person> getPeople() {
        return people;
    }
}

