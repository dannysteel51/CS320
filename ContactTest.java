package Contact.contactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ContactTest {

	// Throws exception if the arguments are null
	@Test
	void testContactNullArguments() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, null, null, null, null);
		});
	}
	
	// Asserts that the getters are working correctly, matching values
	@Test
	void testContactAndGetters() {
		Contact contact = new Contact("987654321", "Daniel", "Stull", "5308584898", "519 Whisper Cat Street.");
		assertTrue(contact.getName().equals("Daniel Stull"));
		assertTrue(contact.getPhoneNumber().equals("5308584898"));
		assertTrue(contact.getContactAddress().equals("519 Whisper Cat Street."));
		assertTrue(contact.getID().equals("987654321"));
	}
	
	// Asserts that first and last name are set and the getter for getName() is working correctly
	@Test
	void testSetFirstAndLastName() {
		Contact contact = new Contact("987654321", "Daniel", "Stull", "5308584898", "519 Whisper Cat Street.");
		contact.setFirstName("Daniel");
		contact.setLastName("Stull");
		assertTrue(contact.getName().equals("Daniel Stull"));
	}
	
	// Asserts that the phone number and address are set and the getters are working correctly
	@Test
	void testSetPhoneNumberAndAddress() {
		Contact contact = new Contact("987654321", "Daniel", "Stull", "5308584898", "519 Whisper Cat Street.");
		contact.setPhoneNumber("5308584898");
		contact.setAddress("519 Whisper Cat Street.");
		assertTrue(contact.getPhoneNumber().equals("5308584898")); 
		assertTrue(contact.getContactAddress().equals("519 Whisper Cat Street."));
	}
	
	// Can't be null, so when contact.setLastName(NULL) is called, it should throw an error
	@Test
	void testNullSetAttributes() {
		Contact contact = new Contact("987654321", "Daniel", "Stull", "5308584898", "519 Whisper Cat Street.");
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setFirstName(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setLastName(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setAddress(null);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setPhoneNumber(null);
		});
	}
	
	// Asserts that all the getters are able to get the stored information
	@Test
	void testAllGetters() {
		Contact contact = new Contact("987654321", "Daniel", "Stull", "5308584898", "519 Whisper Cat Street.");
		assertTrue(contact.getName().equals("Daniel Stull"));
		assertTrue(contact.getID().equals("987654321"));
		assertTrue(contact.getPhoneNumber().equals("5308584898"));
		assertTrue(contact.getContactAddress().equals("519 Whisper Cat Street."));
	}

}