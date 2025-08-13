package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;


public class ContactBookTest {

    private ContactBook contactBook;

    void setupStage1(){
        contactBook = new ContactBook();
    }

    void setupStage2(){
        contactBook = new ContactBook();
        contactBook.add("name1", "email1@mail.com", "10");
        contactBook.add("name2", "email2@mail.com", "20");
        contactBook.add("name3", "email3@mail.com", "30");
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

}
