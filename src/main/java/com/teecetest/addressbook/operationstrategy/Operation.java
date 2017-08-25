package com.teecetest.addressbook.operationstrategy;

/**
 * Operations that address books and contact entries can do
 * 
 * @author George Zheng
 *
 * @param <T> The object type that the operation can work on
 */
public interface Operation<T> {

	/**
	 * Add instance of data type T to the existing collection
	 * 
	 * @param t The instance of object type T to be added
	 */
	void add(T t);

	/**
	 * Remove instance of data type T from the existing collection
	 * 
	 * @param t The instance of data type T to be removed
	 * @return true if data removed successfully
	 */
	boolean remove(T t);

	/**
	 * Print items in the specific collection
	 */
	void print();

	/**
	 * Check if data type T exists in specific collection
	 * @param t The instance of data type T to be checked
	 * @return true if exists
	 */
	boolean exist(T t);
}
