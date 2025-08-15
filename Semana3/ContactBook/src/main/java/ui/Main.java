package ui;

import exceptions.ContactAlreadyExistException;
import model.Contact;
import model.ContactBook;

public class Main {

    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();
        try {
            contactBook.addContact("contact", "contact@mail.com", "3333");
        } catch (ContactAlreadyExistException e) {
            throw new RuntimeException(e);
        }
        Contact c = contactBook.remove("contact@mail.com");
        System.out.println(c);

    }
}
