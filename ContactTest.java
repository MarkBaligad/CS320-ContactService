/**
 * Author: Mark Baligad
 * 2024-09-22
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import contactService.Contact;

/**
 * 
 */
class ContactTest {

	//Test Class Constructor
	@Test
	void testContactClass() {
		Contact contact = new Contact("1", "Mark", "Baligad", "1111111111", "123 Test ST");
        assertEquals("1", contact.getContactId());
        assertEquals("Mark", contact.getFirstName());
        assertEquals("Baligad", contact.getLastName());
        assertEquals("1111111111", contact.getPhone());
        assertEquals("123 Test ST", contact.getAddress());
	}

	//Test Contact ID
	@Test
	void testContactContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("01234567890123456789", "Mark1111112", "Baligad", "1111111111", "123 Test ST");
		});
	}
	@Test
	void testContactIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Mark", "Baligad", "1111111111", "123 Test ST");
		});
	}

	//Test First Name
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Mark1111112", "Baligad", "1111111111", "123 Test ST");
		});
	}
	@Test
	void testContactFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", null, "Baligad", "1111111111", "123 Test ST");
		});
	}
	
	//Test Last Name
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Mark", "Baligad1112", "1111111111", "123 Test ST");
		});
	}
	@Test
	void testContactLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Mark", null, "1111111111", "123 Test ST");
		});
	}
	
	//Test Phone Number
	@Test
	void testContactPhoneNumberLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Mark", "Baligad", "11111111112", "123 Test ST");
		});
	}
	@Test
	void testContactPhoneNumberIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Mark", "Baligad", null, "123 Test ST");
		});
	}
	
	//Test Address
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Mark", "Baligad", "1111111111", "123 Test ST111111111111111111112");
		});
	}
	@Test
	void testContactAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1", "Mark", "Baligad", "1111111111", null);
		});
	}

}
