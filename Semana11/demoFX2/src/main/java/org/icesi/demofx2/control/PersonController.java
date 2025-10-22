package org.icesi.demofx2.control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.icesi.demofx2.model.Person;

import java.util.ArrayList;

public class PersonController {

    private static PersonController instance;

    private ObservableList<Person> people;

    private PersonController() {
        people = FXCollections.observableArrayList();
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

    public ObservableList<Person> getPeople() {
        return people;
    }
}

