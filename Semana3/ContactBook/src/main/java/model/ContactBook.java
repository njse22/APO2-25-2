package model;

import java.util.ArrayList;
import java.util.List;

public class ContactBook {

    private List<Contact> contacts;

    public ContactBook(){
        contacts = new ArrayList<>();
    }

	public boolean add(String name, String email, String phone){
		Contact contact = new Contact(name, email, phone);
		return contacts.add(contact);
	}

	public Contact search(String email){
	
		Contact found = null; 
		for(int i = 0; i < contacts.size(); i++){
			if(contacts.get(i).getEmail().equals(email)){
				found = contacts.get(i); 
			}
		}
		return found;
	}
    

}
