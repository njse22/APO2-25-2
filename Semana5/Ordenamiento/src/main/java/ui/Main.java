package ui;

import model.ComparetorPerson;
import model.ComparodorAltura;
import model.Person;
import model.SortingController;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        SortingController controller = new SortingController();
        System.out.println(controller.compareIntegers(3, 1));

        System.out.println(controller.compareStrings("Nombre1", "Nombre2"));

        Person p1 = new Person("Name1", "Apellido1",10, 170);
        Person p2 = new Person("Name2", "Apellido2", 10, 160);

        System.out.println(controller.comparePersons(p1, p2));

        Comparator<Person> comparatorLastName = new ComparetorPerson();
        System.out.println(controller.comparePersons(p1, p2, comparatorLastName));

        Comparator<Person> comparatorAltura = new ComparodorAltura();
        System.out.println(controller.comparePersons(p1, p2, comparatorAltura));


        // JAVA < 8
        Comparator<Person> personCom2 = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return 0;
            }
        };

        // JAVA > 8
        Comparator<Person> personCom = (o1, o2) -> {
            return o1.getAge() - o2.getAge();
        };

        System.out.println(controller.comparePersons(p1, p2, personCom2));


        // Collections.sort();
        // Arrays.sort();
    }
}
