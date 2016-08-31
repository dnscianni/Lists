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
public interface List<K, V> {
	
	public boolean add(K key, V value);
	
	public V get(K key);
	
	public V remove(K key);
	
	public V remove();
	
	public V get();
	
	public V getLast();
	
	public V removeLast();
	
	public V[] toArray();
	
	public String toString();
	
	public K[] getKeys();
}
