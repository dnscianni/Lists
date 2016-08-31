/**
 * CS 241: Data Structures and Algorithms II
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment #1
 *
 * This assignment is used to help us learn to used Lists. 
 * We will use both linked lists and array lists in our code, 
 * and will execute 6 exercises that will complete the program.
 *
 * David Scianni
 */
package edu.csupomona.cs.cs241.prog_assgmnt_1;

/**
 * @author David Scianni
 * 
 */
public class Item<K extends Comparable<K>, V> {
	
	protected K key;
	protected V value;
	protected Item<K, V> next;
	
	public Item(K key, V value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}

}
