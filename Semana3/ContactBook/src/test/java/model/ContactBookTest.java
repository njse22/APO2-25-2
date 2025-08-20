package model;

import exceptions.ContactAlreadyExistException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ContactBookTest {

    private ContactBook contactBook;

    void setupStage1(){
        contactBook = new ContactBook();
    }

    void setupStage2() {
        contactBook = new ContactBook();
        try {
            contactBook.addContact("name1", "email1@mail.com", "10");
            contactBook.addContact("name2", "email2@mail.com", "20");
            contactBook.addContact("name3", "email3@mail.com", "30");
        }
        catch (ContactAlreadyExistException e) {

        }
    }

    @Test
    void testSearch1(){
        // arrange / init
        setupStage1();

        // act
        String email = "email@email.com";
        Contact contactResult = contactBook.search(email);

        // assert
        assertNull(contactResult);
    }

    @Test
    void testSearch2(){
        // arrange
        setupStage2();

        // act
        Contact contactResult = contactBook.search("email@mail.com");

        // assert
        assertNull(contactResult);

    }

    @Test
    void testSearch3(){
        // arraneg
        setupStage2();

        //act
        Contact contactResult = contactBook.search("email1@mail.com");

        // Assert
        String name = "name1";
        String phone = "10";
        String email = "email1@mail.com";

        assertNotNull(contactResult);
        assertEquals(name, contactResult.getName());
        assertEquals(phone, contactResult.getPhone());
        assertEquals(email, contactResult.getEmail());

    }


    @Test
    void testAdd1(){
        // Arrange / init
        setupStage1();

        // act
        boolean result = contactBook.add("Name1", "email@mail.com", "10");

        // assert
        assertTrue(result);
    }

    @Test
    void testAdd2(){
        // Arrange / init
        setupStage2();

        // act
        boolean result;
        try {
            result = contactBook.addContact("name2", "email2@mail.com", "20");

        } catch (ContactAlreadyExistException e) {
            result = false;
        }
        assertFalse(result);
    }

    @Test
    void testAdd3(){
        // Arrange / init
        setupStage2();

        // Assert
        assertThrows(ContactAlreadyExistException.class,
                // act
                () -> { contactBook.addContact("name1", "email1@mail.com", "10");} );
    }

    @Test
    void testDoubleNumbers() {
        // Arrange / init

        // Assert
        assertEquals(0.5, 0.46, 0.05);
    }

    @Test
    void testDoubleNumbers2() {
        // Arrange / init

        // Assert
        assertNotEquals(0.5, 0.43, 0.05);
    }

}
