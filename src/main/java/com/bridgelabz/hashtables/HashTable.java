package com.bridgelabz.hashtables;

import java.util.Scanner;

import com.bridgelabz.hashtables.LinkedList.MyMapNode;

/**
 * @author Shubham, The class for defining hashtables
 *
 */
public class HashTable {
	LinkedList []hashtable;
	
	
	/**
	 * Allocates memory for indexing the linkedlists
	 */
	public HashTable() {
		hashtable = new LinkedList[10];
	}

	/**
	 * @return the hashtable
	 */
	public LinkedList[] getHashtable() {
		return hashtable;
	}

	/**
	 * The method for entrying a key/value pair in hashtable
	 */
	public <T extends Comparable<T>, V> void add(T key) {
		String toAdd = ((String) key).toLowerCase();
		int val = Math.abs(toAdd.hashCode());
		int index = val%10;
		if(hashtable[index] == null)
			hashtable[index] = new LinkedList();
		MyMapNode myMapNode = hashtable[index].getHead();
		if (hashtable[index].search(toAdd)) {
			while (!((String) myMapNode.getKey()).equalsIgnoreCase(toAdd)) {
				myMapNode = myMapNode.getNext();
			}
			int value = (int) myMapNode.getValue();
			value++;
			myMapNode.setValue(value);
		} else {
			hashtable[index].addNodeAtLast(toAdd, 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the string");
		String input = sc.nextLine();
		String[] words = input.split(" ");
		HashTable hashTable = new HashTable();
		for (String word : words) {
			hashTable.add(word);
		}
		for( LinkedList linkedList : hashTable.hashtable)
			linkedList.printList();

	}
}