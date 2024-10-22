/**
 * Author: Mark Baligad
 * 2024-09-22
 */
package contactService;

import contactService.Contact;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class ContactService {

	// Store contacts in a HashMap
    private static Map<String, Contact> contacts;

    // Constructor
    public ContactService() {
        this.contacts = new HashMap<>();
    }

    // Add a contact
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact with this ID already exists.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Delete contact
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with this ID does not exist.");
        }
        contacts.remove(contactId);
    }

	 // Get a contact by ID
	    public Contact getContact(String contactId) {
	        return contacts.get(contactId);
	    }
    
    // Update contact 
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact with this ID does not exist.");
        }
        // Update the fields if a non-null value was provided (can leave a field null to leave it as is)
        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phone != null) {
            contact.setPhone(phone);
        }
        if (address != null) {
            contact.setAddress(address);
        }
    }

}
