package com.teecetest.addressbook.operationstrategy;

import com.teecetest.addressbook.Contact;

public class ContactOperation implements Operation<String> {

	private Contact contact;

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
		System.out.println(contact.getName() + " has the following phone number: ");
		contact.getPhoneNumbers().stream().forEach(System.out::println);
	}

	@Override
	public boolean exist(String t) {
		return contact.getPhoneNumbers().stream().anyMatch(number -> number.equals(t));
	}
}
