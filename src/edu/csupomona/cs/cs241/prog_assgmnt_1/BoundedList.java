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
public class BoundedList<K extends Comparable<K>, V> implements List<K, V> {

	private Item<K, V>[] theList;
	private int first;
	private int last;

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public BoundedList(int initialSize) {
		first = 0;
		last = 0;
		theList = new Item[initialSize];
	}

	public boolean add(K key, V value) {
		if ((last - first + 1) % theList.length != 0) { // the list is not empty
			Item<K, V> item = new Item<K, V>(key, value);

			if (first == last && theList[first] == null) {
				theList[last] = item;
			} else {
				last = (last + 1) % theList.length;
				theList[last] = item;
			}

			return true;
		}

		return false;
	}

	public V get(K key) {
		int index = findIndex(key);

		if (index >= 0) {
			return theList[index].value;
		} else {
			return null;
		}
	}

	public V remove() {
		if (first == last && theList[first] == null) {
			return null;
		} else {
			V value = theList[first].value;
			theList[first] = null;
			first = (first + 1) % theList.length;
			return value;
		}
	}

	public V remove(K key) {
		int index = findIndex(key);

		if (index >= 0) {
			V value = theList[index].value;
			theList[index] = null;
			fixList(index);
			return value;
		} else {
			return null;
		}
	}

	private void fixList(int index) {
		int next = (index + 1) % theList.length;
		
		while(theList[next] != null) {
			theList[index] = theList[next];
			index = next;
			next = (index + 1) % theList.length;
		}
		if(last == 0) {
			last = theList.length - 1;
		} else {
			last = (last - 1) % theList.length;
		}
	}

	private int findIndex(K key) {
		if (first == last && theList[first] == null) {
			return -1;
		} else {
			int afterLast = (last + 1) % theList.length;
			for (int current = first; current != afterLast; current = (current + 1)
					% theList.length) {
				if (theList[current].key.compareTo(key) == 0) {
					return current;
				}
			}
		}

		return -1;
	}

	public V get() {
		return theList[first].value;
	}

	public V getLast() {
		return theList[last].value;
	}

	public V removeLast() {
		if (first == last && theList[first] == null) {
			return null;
		} else {
			V value = theList[last].value;
			theList[last] = null;
			if(last == 0) {
				last = theList.length - 1;
			} else {
				last = (last - 1) % theList.length;
			}
			return value;
		}
	}

	@SuppressWarnings("unchecked")
	public V[] toArray() {
		
		if(first == last && theList[first] == null) {
			return null;
		}
		int size = 1;
		for(int temp = first; temp != last; temp = (temp + 1) % theList.length) {
			size++;
		}
		V[] valueArray = (V[])new Object[size];
		for(int i = 0, j = first; i < valueArray.length; i++, j = (j+1) % theList.length) {
			valueArray[i] = theList[j].value;
		}
		return valueArray;
	}
	
	public String toString(){
		String listString = "";
		for(int i = first; i != last; i = (i + 1) % theList.length) {
			listString += "(" + theList[i].key + ", " + theList[i].value + ") -- ";
		}
		listString += "(" + theList[last].key + ", " + theList[last].value + ")";
		return listString;
	}

	@SuppressWarnings("unchecked")
	public K[] getKeys() {
		if(first == last && theList[first] == null) {
			return null;
		}
		int size = 1;
		for(int temp = first; temp != last; temp = (temp + 1) % theList.length) {
			size++;
		}
		K[] keyArray = (K[])new Object[size];
		for(int i = 0, j = first; i < keyArray.length; i++, j = (j+1) % theList.length) {
			keyArray[i] = theList[j].key;
		}
		return keyArray;
	}

}
