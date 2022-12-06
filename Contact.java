package Contact.contactService;

public class Contact 
{

	private String ContactID;
	private String FirstName;
	private String LastName;
	private String PhoneNumber;
	private String Address;
	
	
	public Contact(String id, String firstName, String lastName, String phoneNumber, String address) {
		//String newID = UniqueID();
		
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		if(phoneNumber == null || phoneNumber.length() > 10 || phoneNumber.length() < 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		this.ContactID = id;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.PhoneNumber = phoneNumber;
		this.Address = address;
	}
	
	// getters for the program
		public String getID() {
			return this.ContactID;
		}
		
		public String getName() {
			return this.FirstName + " " + this.LastName;
		}
		
		public String getPhoneNumber() {
			return this.PhoneNumber;
		}
		
		public String getContactAddress() {
			return this.Address;
		}
		
		//setters for the program
		public void setContactID(String newId) {
			if (newId == null || newId.length() > 10) {
				throw new IllegalArgumentException("Invalid contact ID");
			}
			
			ContactID = newId;
		}
		
		public void setFirstName(String NewFirstName) {
			if (NewFirstName == null || NewFirstName.length() > 10) {
				throw new IllegalArgumentException("Invalid first name");
			}
			
			FirstName = NewFirstName;
		}
		
		public void setLastName(String NewLastName) {
			if (NewLastName == null || NewLastName.length() > 10) {
				throw new IllegalArgumentException("Invalid last name");
			}
			
			LastName = NewLastName;
		}
		
		public void setPhoneNumber(String NewPhoneNumber) {
			if (NewPhoneNumber == null || NewPhoneNumber.length() > 10 || NewPhoneNumber.length() < 10) {
				throw new IllegalArgumentException("Invalid phone number");
			}

			PhoneNumber = NewPhoneNumber;
		}
		
		public void setAddress(String NewAddress) {
			if (NewAddress == null || NewAddress.length() > 30) {
				throw new IllegalArgumentException("Invalid address");
			}
			
			Address = NewAddress;
		}
		
}
