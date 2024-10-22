/**
 * Author: Mark Baligad
 * 2024-09-22
 */
package contactService;
import contactService.ContactService;

/**
 * 
 */
public class Contact {
	
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	// Constructor
	public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
		// The contact object shall have a required unique contact ID String that cannot be longer than 10 characters.
        // The contact ID shall not be null and shall not be updatable.
        if(contactId == null || contactId.length()>10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		this.contactId = contactId;

        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phoneNumber);
        setAddress(address);
	}

	// Getters
    public String getContactId() {
        return contactId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhone() {
        return phoneNumber;
    }
    public String getAddress() {
        return address;
    }

 // Setters
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid First Name. Cannot be empty or larger than 10 characters.");
        }
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid Last Name. Cannot be empty or larger than 10 characters.");
        }
        this.lastName = lastName;
    }
    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid Phone Number. Must be 10 characters in length.");
        }
        this.phoneNumber = phone;
    }
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid Address. Cannot be empty or larger than 30 characters.");
        }
        this.address = address;
    }
}
