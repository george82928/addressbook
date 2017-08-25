package addressbook;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.george.addressbook.AddressBook;
import com.george.addressbook.Contact;
import com.george.addressbook.User;

import junit.framework.TestCase;

/**
 * Unit test of the application
 * 
 * @author George Zheng
 *
 */
public class AddressBookTest extends TestCase {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private static final String EXPECTED_RESULT_ONE = "George Zheng:0405338692 0410668326";
	private static final String EXPECTED_RESULT_TWO = "James Bond:00000000";
	private static final String EXPECTED_RESULT_THREE = "George Zheng:0405338692 0409526365 0410668326";
	private static final String EXPECTED_RESULT_FOUR = "William Wallace:911";
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		System.setOut(null);
		System.setErr(null);
	}
	
	/**
	 * Test user can add new entry to contact
	 */
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
	
	/**
	 * Test user can remove existing contact entry
	 */
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
	
	/**
	 * Test user should be able to print all contacts in address book
	 */
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
		user.printAllContactsInOneAddressBook(ab1.getName());
		assertTrue(outContent.toString().contains(EXPECTED_RESULT_ONE));
		assertTrue(outContent.toString().contains(EXPECTED_RESULT_TWO));
	}
	
	/**
	 * Test user can print unique set of all contacts across multiple address books
	 */
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
		assertTrue(outContent.toString().contains(EXPECTED_RESULT_TWO));
		assertTrue(outContent.toString().contains(EXPECTED_RESULT_THREE));
		assertTrue(outContent.toString().contains(EXPECTED_RESULT_FOUR));
	}
}
