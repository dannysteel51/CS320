package Contact.contactService;
import java.util.Vector;
import java.util.Random;


public class ContactService {
	

			private Vector<Contact> ContactList = new Vector<Contact>();
			private int ContactCount = 0;
			
			// public getter for the ContactCount
			public int GetContactCount() {
				return ContactCount;
			}
			
			//public getter for the ContactList vector
			public Vector<Contact> GetContactList(){
				return ContactList;
			}

			// Calls the AddContact() method passing in the arguments and creates new Contact object newContact
			// Then it adds the newContact to the vector, ContactList. 
			// Lastly, it increased the ContactCount by one
			public void AddContact(String id, String firstName, String lastName, String phoneNumber, String address) {
				Contact newContact = new Contact(
						id,
						firstName,
						lastName,
						phoneNumber,
						address);
				
				ContactList.add(newContact);
				ContactCount++;
			}
			
			// Adds a contact to the list and increases the count
			public void AddContact(Contact contact) {
				ContactList.add(contact);
				ContactCount++;
			}
			
			// This function checks to make sure the list isn't empty, the index is correct, or if there
			// is a matching entry in the vector, and if one match is found, it is removed, subtracting one from
			// the total count
			public void DeleteContact(String id) {
				if(id == null || id.length() > 10) {
					throw new IllegalArgumentException("Invalid ID");
					
				}
				
				if(ContactList.isEmpty()) {
					throw new IllegalArgumentException("No contacts to delete");
				}
				
				int index = -1;
				for (Contact i : ContactList) {
					if (i.getID() == id) {
						index = ContactList.indexOf(i);
					}
					
				}
				if (index == -1) {
					System.out.println("Contact not found.");
					return;
				}
				else{
					ContactList.remove(index);
					ContactCount--;
					System.out.println("Contact has been removed.");
				}
				
				
			}
			
			private void DeleteContact(Contact contact) {
				ContactList.remove(contact);
				ContactCount--;
			}
			
			// This function checks to see if the vector is empty, is the index is correct, and then
			// it uses a switch case to update a specific part of the contact information using the set functions
			// from the Contact.java file
			public void UpdateContact(String id, String update, int selection) {
				if(id == null || id.length() > 10 || update == null || selection < 0) {
					throw new IllegalArgumentException("Invalid ID");
				}
				
				if(ContactList.isEmpty()) {
					throw new IllegalArgumentException("No contacts exist in list");
				}
				
				int index = -1;
				for (Contact i : ContactList) {
					if (i.getID() == id) {
						index = ContactList.indexOf(i);
					}
					
				}
				if (index == -1) {
					System.out.println("Contact not found.");
					return;
				}
				
				Contact updateContact = ContactList.get(index);
				
				switch (selection){
				case 1:{
					updateContact.setFirstName(update);
					break;
				}
				case 2:{
					updateContact.setLastName(update);
					break;
				}
				case 3:{
					updateContact.setPhoneNumber(update);
					break;
				}
				case 4:{
					updateContact.setAddress(update);
					break;
				}
				default:{
					System.out.println("Contact not updated--Illegal operation.");
					break;
				}
				}
				
				DeleteContact(ContactList.elementAt(index));
				AddContact(updateContact);
						
			}
			
			public void UpdateContact(String id, String firstName, String lastName, String phoneNumber, String address) {
				if(id == null || id.length() > 10) {
					throw new IllegalArgumentException("Invalid ID");
				}
				
				if(ContactList.isEmpty()) {
					throw new IllegalArgumentException("The contact list is empty");
				}
				
				int index = -1;
				for (Contact i : ContactList) {
					if (i.getID() == id) {
						index = ContactList.indexOf(i);
					}
					
				}
				if (index == -1) {
					System.out.println("Contact not found.");
					return;
				}
				
				Contact tempContact = ContactList.get(index);
				tempContact.setFirstName(firstName);
				tempContact.setLastName(lastName);
				tempContact.setAddress(address);
				tempContact.setPhoneNumber(phoneNumber);
				
				ContactList.remove(index);
				ContactList.add(tempContact);
						
			}
			
			// Generates the ID's for the contacts
			public String UniqueID() {
				// using the rand function, we are able to generate a random ID for the contacts 
				Random rand = new Random();
				int newID = rand.nextInt(1000000000);
				String uniqueID = Integer.toString(newID);
				
				// Parses through the ContactList to see if there is a matching ID. If there is, 
				// the uniqueID is set as the newID on the contacts information. 
				for (Contact i : ContactList) {
					while (i.getID() == uniqueID) {
						newID = rand.nextInt(1000000000);
						uniqueID = Integer.toString(newID);
					}
					
				}
				
				System.out.println("Your ID is: " + uniqueID);
						
				return uniqueID;
			}
			
	}