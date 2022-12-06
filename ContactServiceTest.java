package Contact.contactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class ContactServiceTest {

	@Test
		void testAddContactMethod() {
		// create a contact service, testID and a new contact for testing purposes
		ContactService contactService = new ContactService();
		String testID = contactService.UniqueID();
		Contact contact = new Contact(testID, "Daniel", "Stull", "8488597842", "591 Let Me Out Lane");

		// add contact to the list
		contactService.AddContact(contact);

		// This checks to make sure the new contact is in the vector and that the vector is not empty
		assertTrue(!contactService.GetContactList().isEmpty());
		assertTrue(contactService
			.GetContactList()
			.get(0)
			.getID()
			.equals(testID));
		assertTrue(contactService.GetContactCount() > 0);
	}

	@Test
		void testDeleteContactMethod() {
		// create a contact service, testID and a new contact for testing purposes
		ContactService contactService = new ContactService();
		String testID = contactService.UniqueID();
		Contact contact = new Contact(testID, "Charles", "William", "5552641879", "722 Let Me In Bvld");

		// This tries to remove a null contact
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.DeleteContact("");
		});

		// This tries to remove a too long ID
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.DeleteContact("12345678901");
		});

		// This tries to remove from an empty list
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.DeleteContact("1234567890");
		});

		// Adding the contact object
		contactService.AddContact(contact);

		// Trying to remove a contact that is not there
		contactService.DeleteContact("555555");

		// This flows from that DeleteContact above.
		// The list is still not empty && the count does != 0
		assertTrue(!contactService.GetContactList().isEmpty());
		assertTrue(contactService.GetContactCount() != 0);

		// Removing the object created above
		contactService.DeleteContact(testID);

		// This flows from the DeleteContact above.
		// This IS empty && the count DOES == 0
		assertTrue(contactService.GetContactCount() == 0);
		assertTrue(contactService.GetContactList().isEmpty());

	}

	@Test
		void testUpdateContactMethodErrors() {
		ContactService contactService = new ContactService();
		// The contact list is empty
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
		contactService.UpdateContact("987654", "Glenda", 1);
		});

		// This creates a new contact and adds it to the list
		String testID = contactService.UniqueID();
		Contact contact = new Contact(testID, "Nickolas", "Spence", "9995557171", "999 Willow Ln");
		contactService.AddContact(contact);
		// He we make sure that it was added to the vector
		assertTrue(!contactService.GetContactList().isEmpty());

		// This ID is too long and it shouldn't work
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.UpdateContact("333333333333333333333", "Witwicky", 1);
		});
		// This ID is null and shouldn't work
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.UpdateContact(null, "Reilly", 1);
		});
		// The new update information being passed in is null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.UpdateContact("987654", null, 1);
		});
		// The selection in the contact vector is negative and therefore can't work
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.UpdateContact("654321", "Helen", -1);
		});



	}

	@Test
		void testUpdateContactMethod() {
		ContactService contactService = new ContactService();
		String testID = contactService.UniqueID();
		Contact contact = new Contact(testID, "Lauren", "Willows", "5309998798", "591 Monterey Way");
		contactService.AddContact(contact);
		assertTrue(!contactService.GetContactList().isEmpty());

		// update first name
		contactService.UpdateContact(testID, "Taren", 1);
		assertTrue(contactService
			.GetContactList()
			.elementAt(0)
			.getName()
			.equals("Taren Willows"));
		// update last name
		contactService.UpdateContact(testID, "Craig", 2);
		assertTrue(contactService
			.GetContactList()
			.elementAt(0)
			.getName()
			.equals("Taren Craig"));
		// update phone number
		contactService.UpdateContact(testID, "5307689999", 3);
		assertTrue(contactService
			.GetContactList()
			.elementAt(0)
			.getPhoneNumber()
			.equals("5307689999"));
		// update address
		contactService.UpdateContact(testID, "591 Hilltop Drive", 4);
		assertTrue(contactService
			.GetContactList()
			.elementAt(0)
			.getContactAddress()
			.equals("591 Hilltop Drive"));

		// update first name too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.UpdateContact(testID, "LawrenceJamesJoseph", 1);
		});

		// check that list has been updated
		// only one contact in list, check that it's updated by checking name
		assertTrue(contactService.GetContactCount() == 1);
		assertTrue(contactService.GetContactList().elementAt(0)
			.getName().equals("Taren Craig"));

	}

}