package com.bridgelabz.hashtables;

import java.util.Scanner;

import com.bridgelabz.hashtables.LinkedList.MyMapNode;

/**
 * @author Shubham, The class for defining hashtables
 *
 */
public class HashTable {
	LinkedList hashtable;

	/**
	 * @return the hashtable
	 */
	public LinkedList getHashtable() {
		return hashtable;
	}

	/**
	 * 
	 */
	public HashTable() {
		hashtable = new LinkedList();
	}

	/**
	 * The method for entrying a key/value pair in hashtable
	 */
	public <T extends Comparable<T>, V> void add(T key) {
		MyMapNode myMapNode = hashtable.getHead();
		if (hashtable.search(key)) {
			while (!((String) myMapNode.getKey()).equalsIgnoreCase(((String) key))) {
				myMapNode = myMapNode.getNext();
			}
			int value = (int) myMapNode.getValue();
			value++;
			myMapNode.setValue(value);
		} else {
			hashtable.addNodeAtLast(key, 1);
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
		hashTable.hashtable.printList();

	}
}