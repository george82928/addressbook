package com.teecetest.addressbook;

import java.util.HashSet;
import java.util.Set;

import com.teecetest.addressbook.operationstrategy.AddressBookOperation;
import com.teecetest.addressbook.operationstrategy.Operation;

/**
 * This class represents an address book
 * 
 * @author George Zheng
 * 
 */
public class AddressBook {

	private String name;
	
	private Set<Contact> contacts = new HashSet<>();
	
	private final Operation<Contact> addressBookOperation;

	/**
	 * Constructor of this class
	 * 
	 * @param name Name of this address book
	 */
	public AddressBook(String name) {
		this.name = name;
		addressBookOperation = new AddressBookOperation(this);
	}

	/**
	 * Add contact to this address book
	 * 
	 * @param newContact Contact needs to be added
	 */
	public void addContact(Contact newContact) {
		addressBookOperation.add(newContact);
	}

	/**
	 * Remove specific contact from the address book
	 * 
	 * @param contact Contact needs to be removed
	 */
	public void removeContact(Contact contact) {
		addressBookOperation.remove(contact);
	}

	/**
	 * Print all contacts in this address book
	 */
	public void printContacts() {
		addressBookOperation.print();
	}
	
	/**
	 * Check if a contace is existing in this address book
	 * @param t
	 * @return
	 */
	public boolean exist(Contact t) {
		return addressBookOperation.exist(t);
	}

	/**
	 * Get the name of this address book
	 * @return
	 */
	public String getName() {
		return name;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}
}
