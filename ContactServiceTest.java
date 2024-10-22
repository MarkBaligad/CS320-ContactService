/**
 * Author: Mark Baligad
 * 2024-09-22
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import appointmentService.AppointmentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import contactService.ContactService;
import contactService.Contact;
import taskService.Task;

/**
 * 
 */
class ContactServiceTest {

	// This will create the Contact Service that each Unit test will use to reduce code repetition
	private ContactService contactService;
	@BeforeEach
	public void setUp() {
		contactService = new ContactService();
	}

	@Test
	void testAddContacts() {
		// create and add contacts to hash map
		contactService.addContact(new Contact("1", "Person", "One", "1111111111", "123 Test ST"));
		contactService.addContact(new Contact("2", "Person", "Two", "1111111111", "123 Test ST"));
		contactService.addContact(new Contact("3", "Person", "Three", "1111111111", "123 Test ST"));
		// confirm the contacts exist in the hash map
		assertNotNull(contactService.getContact("1"));
		assertNotNull(contactService.getContact("2"));
		assertNotNull(contactService.getContact("3"));
	}

	@Test
	void testAddContactNonUniqueID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(new Contact("1", "Person", "One", "1111111111", "123 Test ST"));
			contactService.addContact(new Contact("1", "Person", "Two", "1111111111", "123 Test ST"));
		});
	}

	@Test
	void testdeleteContactByContactId() {
		contactService.addContact(new Contact("1", "Person", "One", "1111111111", "123 Test ST"));
		
		// confirm the contact was created
		assertNotNull(contactService.getContact("1"));
		
		// delete contact then confirm the contact was deleted
		contactService.deleteContact("1");
	    assertNull(contactService.getContact("1"));
	}

	@Test
	void testdeleteNonExistentContactByContactId() {
		contactService.addContact(new Contact("1", "Person", "One", "1111111111", "123 Test ST"));

		// delete a non existent contact to get an exception
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.deleteContact("2");
		});

		// confirm the contact that was created still exists
		assertNotNull(contactService.getContact("1"));
	}
	
	@Test
	void testUpdateContactFirstName() {
		contactService.addContact(new Contact("1", "Person", "One", "1111111111", "123 Test ST"));
		contactService.updateContact("1", "NewFirst", null, null, null);
		Assertions.assertEquals("NewFirst", contactService.getContact("1").getFirstName());
	}
	
	@Test
	void testUpdateContactLastName() {
		contactService.addContact(new Contact("1", "Person", "One", "1111111111", "123 Test ST"));
		contactService.updateContact("1", null, "NewLast", null, null);
		Assertions.assertEquals("NewLast", contactService.getContact("1").getLastName());
	}
	
	@Test
	void testUpdateContactPhoneNumber() {
		contactService.addContact(new Contact("1", "Person", "One", "1111111111", "123 Test ST"));
		contactService.updateContact("1", null, null, "2222222222", null);
		Assertions.assertEquals("2222222222", contactService.getContact("1").getPhone());
	}
	
	@Test
	void testUpdateContactAddress() {
		contactService.addContact(new Contact("1", "Person", "One", "1111111111", "123 Test ST"));
		contactService.updateContact("1", null, null, null, "456 New Address");
		Assertions.assertEquals("456 New Address", contactService.getContact("1").getAddress());
	}

	@Test
	void testUpdateWithInvalidId() {
		// add contact
		contactService.addContact(new Contact("1", "Person", "One", "1111111111", "123 Test ST"));

		// attempt to update an invalid contact
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContact("2", "New First", "New Last", "2222222222", "456 New Address");
		});

		// confirm existing contact was not changed
		Assertions.assertEquals("Person", contactService.getContact("1").getFirstName());
		Assertions.assertEquals("One", contactService.getContact("1").getLastName());
		Assertions.assertEquals("1111111111", contactService.getContact("1").getPhone());
		Assertions.assertEquals("123 Test ST", contactService.getContact("1").getAddress());
	}
	
}
