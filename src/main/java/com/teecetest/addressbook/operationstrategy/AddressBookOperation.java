package com.teecetest.addressbook.operationstrategy;

import com.teecetest.addressbook.AddressBook;
import com.teecetest.addressbook.Contact;

/**
 * Operations can be done by an address book
 * 
 * @author George Zheng
 */
public class AddressBookOperation implements Operation<Contact> {

	private AddressBook addressBook;

	public AddressBookOperation(AddressBook addressBook) {
		this.addressBook = addressBook;
	}

	@Override
	public void add(Contact t) {
		if (exist(t)) {
			addressBook.getContacts().stream().filter(p -> p.getName().equals(t.getName())).forEach(con -> {
				con.getPhoneNumbers().addAll(t.getPhoneNumbers());
			});
		} else {
			addressBook.getContacts().add(t);
		}
	}

	@Override
	public boolean remove(Contact t) {
		return addressBook.getContacts().removeIf(p -> p.getName().equals(t.getName()));
	}

	@Override
	public void print() {
		addressBook.getContacts().stream().forEach(p -> p.print());
	}

	@Override
	public boolean exist(Contact t) {
		return addressBook.getContacts().stream().anyMatch(contact -> contact.getName().equals(t.getName()));
	}

}
