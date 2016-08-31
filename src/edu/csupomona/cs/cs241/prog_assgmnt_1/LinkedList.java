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
public class LinkedList<K extends Comparable<K>, V> implements List<K, V> {

	private Item<K, V> head;
	
	public LinkedList() {
		head = new Item<K, V>(null, null);
	}
	
	public boolean add(K key, V value) {
		Item<K, V> node = new Item<K, V>(key, value);
		Item<K, V> currentNode = head;
		while(currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = node;
		return true;
	}
	
	public V get(K key) {
		if(head.next == null) {
			return null;
		}
		Item<K, V> currentNode = head.next;
		while(currentNode != null) {
			if(currentNode.key.compareTo(key) == 0) {
				return currentNode.value;
			}
			currentNode = currentNode.next;
		}
		return null;
	}
	
	public V remove() {
		if(head.next == null) {
			return null;
		}
		Item<K, V> currentNode = head.next;
		head.next = currentNode.next;
		return currentNode.value;
	}
	
	public V remove(K key) {
		if(head.next == null) {
			return null;
		}
		Item<K, V> currentNode = head;
		while(currentNode.next != null) {
			if(currentNode.next.key.compareTo(key) == 0) {
				V value = currentNode.next.value;
				currentNode.next = currentNode.next.next;
				return value;
			}
			currentNode = currentNode.next;
		}
		return null;
	}

	public V get() {
		if(head.next == null) {
			return null;
		}
		return head.next.value;
	}
	
	public V getLast() {
		if(head.next == null) {
			return null;
		}
		Item<K, V> currentNode = head;
		while(currentNode.next != null) {
			currentNode = currentNode.next;
		}
		return currentNode.value;
	}

	public V removeLast() {
		if(head.next == null) {
			return null;
		}
		Item<K, V> currentNode = head;
		while(currentNode.next.next != null) {
			currentNode = currentNode.next;
		}
		V value = currentNode.next.value;
		currentNode.next = currentNode.next.next;
		return value;
	}

	@SuppressWarnings("unchecked")
	public V[] toArray() {
		if(head.next == null) {
			return null;
		}
		int size = 0;
		Item<K, V> currentNode;
		for(currentNode = head; currentNode.next != null; currentNode = currentNode.next) {
			size++;
		}
		V[] valueArray = (V[]) new Object[size];
		currentNode = head.next;
		for(int i = 0; i < valueArray.length; i++) {
			valueArray[i] = currentNode.value;
			currentNode = currentNode.next;
		}
		return valueArray;
	}
	
	public String toString(){
		String listString = "";
		for(Item<K, V> currentNode = head.next; currentNode != null; currentNode = currentNode.next) {
			listString += "(" + currentNode.key + ", " + currentNode.value + ")";
			if(currentNode.next != null) {
				listString += " -- ";
			}
		}
		return listString;
	}

	@SuppressWarnings("unchecked")
	public K[] getKeys() {
		if(head.next == null) {
			return null;
		}
		int size = 0;
		Item<K, V> currentNode;
		for(currentNode = head; currentNode.next != null; currentNode = currentNode.next) {
			size++;
		}
		K[] keyArray = (K[])new Object[size];
		currentNode = head.next;
		for(int i = 0; i < keyArray.length; i++) {
			keyArray[i] = currentNode.key;
			currentNode = currentNode.next;
		}
		return keyArray;
	}
}
