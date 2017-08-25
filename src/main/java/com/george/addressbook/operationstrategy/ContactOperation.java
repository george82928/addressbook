package com.george.addressbook.operationstrategy;

import com.george.addressbook.Contact;

/**
 * Operations can be done by a Contact
 * 
 * @author George Zheng
 */
public class ContactOperation implements Operation<String> {

	private Contact contact;

	/**
	 * Constructor of this class
	 * @param contact Contact object
	 */
	public ContactOperation(Contact contact) {
		this.contact = contact;
	}

	@Override
	public void add(String t) {
		contact.getPhoneNumbers().add(t);
	}

	@Override
	public boolean remove(String t) {
		return contact.getPhoneNumbers().remove(t);
	}

	@Override
	public void print() {
		System.out.print(contact.getName() + ":");
		contact.getPhoneNumbers().stream().sorted().forEach(p -> System.out.print(p + " "));
		System.out.println();
	}

	@Override
	public boolean exist(String t) {
		return contact.getPhoneNumbers().stream().anyMatch(number -> number.equals(t));
	}
}
