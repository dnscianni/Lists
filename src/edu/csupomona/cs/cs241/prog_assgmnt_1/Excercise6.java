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

import java.util.*;

/**
 * @author David Scianni
 * 
 */
public class Excercise6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<String, String> theList = new LinkedList<String, String>();
		String name;
		String ID;
		String nameArray[];
		String IDArray[];
		int choice;
		Scanner scn = new Scanner(System.in);

		do {
			System.out
					.println("Would you like to add a name to the registry?(1 for yes, any number for no): ");
			choice = scn.nextInt();
			
			if (choice != 1) {
				break;
			}
			
			scn.nextLine();
			System.out.println("What is the name: ");
			name = scn.nextLine();
			
			System.out.println("What is the ID number of " + name + ": ");
			ID = scn.nextLine();
			System.out.println();
			
			theList.add(ID, name);
		} while (true);
		
		System.out.println("\n\n\n\n\n\n\n\n\n");
		
		do{
			System.out.println("==========================================");
			System.out.println("|                  Menu                  |");
			System.out.println("|                                        |");
			System.out.println("| 1. List names in alphebetical order.   |");
			System.out.println("| 2. List all ID's                       |");
			System.out.println("| 3. Get a name from ID number           |");
			System.out.println("| 4. Add a name                          |");
			System.out.println("| 5. Quit                                |");
			System.out.println("==========================================");
			System.out.println("\nInput: ");
			choice = scn.nextInt();
			
			if(choice < 1 || choice > 5) {
				System.out.println("Invalid Input.\n");
				continue;
			} else if(choice == 5) {
				break;
			} else if(choice == 1) {
				nameArray = theList.toArray();
				for(int i = 0; i < nameArray.length; i++) {
					System.out.println(nameArray[i]);
				}
			} else if(choice == 2) {
				IDArray = theList.getKeys();
				for(int i = 0; i < IDArray.length; i++) {
					System.out.println(IDArray[i]);
				}
			} else if(choice == 3) {
				scn.nextLine();
				System.out.println("Enter the ID number: ");
				ID = scn.nextLine();
				System.out.println("\n" + theList.get(ID) + ".\n");
			} else {
				scn.nextLine();
				System.out.println("What is the name: ");
				name = scn.nextLine();
				
				System.out.println("What is the ID number of " + name + ": ");
				ID = scn.nextLine();
				System.out.println();
				
				theList.add(ID, name);
			}
		}while(true);
		System.out.println("\nThank you for using my program.");
	}

}
