package model;

import exceptions.ContactAlreadyExistException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactBook {

    private List<Contact> contacts;

    public ContactBook(){
        contacts = new ArrayList<>();
    }

	public boolean add(String name, String email, String phone){
		Contact contact = new Contact(name, email, phone);
		return contacts.add(contact);
	}

	public boolean addContact(String name, String email, String phone) throws ContactAlreadyExistException {
		Contact newContact = new Contact(name, email, phone);
		if(search(email) != null){
			throw new ContactAlreadyExistException("Contact with email " + email + " already exists");
		}
		return contacts.add(newContact);
	}

	public Contact search(String email)  {
		/* -----------------------------------------------------------------------------------------*
		 * La clase Optional es es un contenedor inmutable introducido en Java 8                     *
		 * para representar la posible ausencia de un valor sin recurrir a null                      *
		 *                                                                                           *
		 * El método stream() devuelve un Stream secuencial que proporciona una                      *
		 * vista de los elementos sobre los que se pueden aplicar operaciones funcionales.           *
		 *                                                                                           *
		 * --- .filter(contact -> contact.getEmail().equals(email)) -------------------------------- *
		 * filter es una operación intermedia de Stream que recibe un Predicate<? super T>           *
		 * y devuelve un nuevo stream que solo contiene los elementos que cumplen la condición.      *
		 *   1.  La lambda contact -> contact.getEmail().equals(email):                              *
		 *       Parámetro: contact (cada elemento del stream, tipo Contact).                        *
		 *   2.  Cuerpo: llama a contact.getEmail() (devuelve un String) y                           *
		 *       compara con email usando String.equals(Object).                                     *
		 *   3.  El método equals de String compara contenido de forma case-sensitive.               *
		 *                                                                                           *
		 * --- .findFirst() ------------------------------------------------------------------------ *
		 * Es una operación terminal corta, que devuelve un Optional<T> con el primer elemento del   *
		 * stream, si existe.                                                                        *
		 * Internamente, al encontrar el primer elemento que satisface el predicado, el stream se    *
		 * cierra y no se procesan más elementos, optimizando el rendimiento.                        *
		 *                                                                                           *
		 * REFERENCIAS:                                                                              *
		 * https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
		 * https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
		 * https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/stream/Stream.html#findFirst()
		 * */
		Optional<Contact> optional = contacts.stream().filter(contact -> contact.getEmail().equals(email)).findFirst();
		return optional.orElse(null);
	}

	public Contact remove(String email) {
		Contact toRemove = search(email);
		contacts.remove(toRemove);
		return toRemove;
	}




	public Contact searchNormal(String email){
	
		Contact found = null; 
		for(int i = 0; i < contacts.size(); i++){
			if(contacts.get(i).getEmail().equals(email)){
				found = contacts.get(i); 
			}
		}
		return found;
	}
    

}
