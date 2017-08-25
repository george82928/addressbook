package com.teecetest.addressbook;

import java.util.HashSet;
import java.util.Set;

import com.teecetest.addressbook.operationstrategy.Operation;
import com.teecetest.addressbook.operationstrategy.UserOperation;

/**
 * This class represents an end user
 * 
 * @author George Zheng
 *
 */
public class User {

	private Set<AddressBook> addressBookList = new HashSet<>();

	private final Operation<AddressBook> userOperation;

	/**
	 * Constructor of this class
	 */
	public User() {
		userOperation = new UserOperation(this);
	}

	/**
	 * Add a contact to specific address book
	 * 
	 * @param addressBookName The name of the address book
	 * @param contact The contact which needs to be added to the address book
	 */
	public void addContact(String addressBookName, Contact contact) {
		addressBookList.stream().filter(p -> p.getName().equals(addressBookName)).forEach(n -> n.addContact(contact));
	}

	public void removeExistContact(String addressBookName, Contact contact) {
		addressBookList.stream().filter(p -> p.getName().equals(addressBookName))
				.forEach(n -> n.removeContact(contact));
	}

	/**
	 * Print all contacts in the designated address book
	 * 
	 * @param addressBookName The name of the designated address book
	 */
	public void printAllContactsInOneAddressBook(String addressBookName) {
		addressBookList.stream().filter(p -> p.getName().equals(addressBookName)).forEach(n -> n.printContacts());
	}

	/**
	 * Print a unique set of all contacts across all address books
	 */
	public void printUniqueSet() {
		userOperation.print();
	}
	
	/**
	 * Add an address book to this user
	 * 
	 * @param ab The address book needs to be added
	 */
	public void addAddressBook(AddressBook ab) {
		userOperation.add(ab);
	}

	/**
	 * Remove specific address book from the user
	 * 
	 * @param ab The address book needs to be removed
	 */
	public void removeAddressBook(AddressBook ab) {
		userOperation.remove(ab);
	}

	/**
	 * Get all address books owned by this user
	 * 
	 * @return Set of all address books owned by this user
	 */
	public Set<AddressBook> getAddressBookList() {
		return addressBookList;
	}
}
