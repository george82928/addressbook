package com.teecetest.addressbook;

import java.util.HashSet;
import java.util.Set;

import com.teecetest.addressbook.operationstrategy.ContactOperation;
import com.teecetest.addressbook.operationstrategy.Operation;

/**
 * This class represents contact entry in a address book.
 * 
 * @author George Zheng
 */
public class Contact {

	private String name;
	
	private Set<String> phoneNumbers = new HashSet<String>();
	
	private final Operation<String> contactOperation;

	/**
	 * Constructor of the class
	 * 
	 * @param name Name of the contact entry
	 */
	public Contact(String name) {
		this.name = name;
		this.contactOperation = new ContactOperation(this);
	}

	/**
	 * Add a phone number to the contact entry
	 * 
	 * @param number The phone number needs to be added
	 */
	public void addPhoneNumber(String number) {
		contactOperation.add(number);
	}

	/**
	 * Remove the phone number from the number list of the contact
	 * 
	 * @param number
	 */
	public void removePhoneNumber(String number) {
		contactOperation.remove(number);
	}

	/**
	 * Print all numbers of this contact entry
	 */
	public void print() {
		contactOperation.print();
	}

	/**
	 * Get the name of this contact
	 *  
	 * @return String The name of this contact
	 */
	public String getName() {
		return name;
	}

	/**
	 * Check if the number is existing in this contact
	 * 
	 * @param t The number which need to checked
	 * @return True if the number is existing
	 */
	public boolean exist(String t) {
		return contactOperation.exist(t);
	}
	
	/**
	 * Get all phone numbers of this contact
	 * 
	 * @return All phone numbers of this contact
	 */
	public Set<String> getPhoneNumbers() {
		return phoneNumbers;
	}
}
