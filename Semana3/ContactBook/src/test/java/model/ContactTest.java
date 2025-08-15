package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    private Contact contact;

    void setupStage1(){
        contact = null;
    }

    @Test
    void testContact1(){
        // arrange / init

        // assert
        assertThrows(RuntimeException.class, () -> {
            // act
            contact = new Contact("name", null, "");
        });
    }
}
