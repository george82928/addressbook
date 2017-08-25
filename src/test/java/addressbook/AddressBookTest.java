package addressbook;

import com.teecetest.addressbook.AddressBook;
import com.teecetest.addressbook.Contact;
import com.teecetest.addressbook.User;

import junit.framework.TestCase;

public class AddressBookTest  extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testUserCanAddNewContactEntry()
	{
		AddressBook ab1 = new AddressBook("ab1");
		User user = new User();
		user.addAddressBook(ab1);
		
		Contact contact = new Contact("George Zheng");
		contact.addPhoneNumber("0410668326");
		Contact contact2 = new Contact("James Bond");
		contact2.addPhoneNumber("00000000");
		
		user.addContact(ab1.getName(), contact);
		user.addContact(ab1.getName(), contact2);
		
		assertEquals(2, ab1.getContacts().size());
		assertTrue(ab1.getContacts().contains(contact));
		assertTrue(ab1.getContacts().contains(contact2));
	}
	
	public void testUserCanRemoveExistingContactEntry() {
		AddressBook ab1 = new AddressBook("ab1");
		User user = new User();
		user.addAddressBook(ab1);
		
		Contact contact = new Contact("George Zheng");
		contact.addPhoneNumber("0410668326");
		Contact contact2 = new Contact("James Bond");
		contact2.addPhoneNumber("00000000");
		ab1.addContact(contact);
		ab1.addContact(contact2);
		
		user.removeExistContact(ab1.getName(), contact2);
		
		assertEquals(1, ab1.getContacts().size());
		assertTrue(ab1.getContacts().contains(contact));
		assertFalse(ab1.getContacts().contains(contact2));
	}
	
//	should be able to print all contacts in an address book
	public void testUserCanPrintAllContactsInAddressBook() {
		
		AddressBook ab1 = new AddressBook("ab1");
		User user = new User();
		user.addAddressBook(ab1);
		
		Contact contact = new Contact("George Zheng");
		contact.addPhoneNumber("0410668326");
		contact.addPhoneNumber("0405338692");
		Contact contact2 = new Contact("James Bond");
		contact2.addPhoneNumber("00000000");
		ab1.addContact(contact);
		ab1.addContact(contact2);
		// TODO
		System.out.println("****");
		user.printAllContactsInOneAddressBook(ab1.getName());
		System.out.println("****");
	}
	
	public void testUserCanPrintUniqueSetOfAllContactsAcrossMultiAddressBooks() {
		User user = new User();
		
		Contact contact = new Contact("George Zheng");
		contact.addPhoneNumber("0410668326");
		contact.addPhoneNumber("0405338692");
		Contact contact2 = new Contact("James Bond");
		contact2.addPhoneNumber("00000000");
		Contact contact3 = new Contact("George Zheng");
		contact3.addPhoneNumber("0410668326");
		contact3.addPhoneNumber("0405338692");
		contact3.addPhoneNumber("0409526365");
		Contact contact4 = new Contact("William Wallace");
		contact4.addPhoneNumber("911");
		
		AddressBook ab1 = new AddressBook("ab1");
		AddressBook ab2 = new AddressBook("ab2");
		
		ab1.addContact(contact);
		ab1.addContact(contact2);
		ab2.addContact(contact3);
		ab2.addContact(contact4);
		
		user.addAddressBook(ab1);
		user.addAddressBook(ab2);
		
		user.printUniqueSet();
	}
	
	
}
