package com.george.addressbook.operationstrategy;

import com.george.addressbook.AddressBook;
import com.george.addressbook.User;

/**
 * Operations can be done by a user
 * @author George Zheng
 *
 */
public class UserOperation implements Operation<AddressBook> {

	private User user;
	
	/**
	 * Constructor of this class
	 * @param user {@code User} object
	 */
	public UserOperation(User user) {
		this.user = user;
	}
	
	@Override
	public void add(AddressBook t) {
		if (!exist(t)) {
			user.getAddressBookList().add(t);
		}
	}

	@Override
	public boolean remove(AddressBook t) {
		return user.getAddressBookList().removeIf(p -> p.getName().equals(t.getName()));
	}

	@Override
	public void print() {
		AddressBook ab = new AddressBook("new");
		user.getAddressBookList().stream().forEach(existingAb -> addAddressBook(existingAb, ab));
		ab.printContacts();
	}

	private Object addAddressBook(AddressBook addressBook, AddressBook ab) {
		addressBook.getContacts().stream().forEach(p -> ab.addContact(p));
		return ab;
	}
	
	@Override
	public boolean exist(AddressBook t) {
		return user.getAddressBookList().stream().anyMatch(p -> p.getName().equals(t.getName()));
	}

}
