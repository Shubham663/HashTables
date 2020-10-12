package com.bridgelabz.hashtables;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.hashtables.LinkedList.MyMapNode;

/**
 * @author Shubham, The class for defining hashtables
 *
 */
public class HashTable {
	LinkedList[] hashtable;

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
		int index = val % 10;
		if (hashtable[index] == null)
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

	/**
	 * Deletes specified element if present inside hashtable
	 */
	public <T> void delete(T t) {
		String toBeDeleted = (String) t;
		int hashValue = Math.abs(toBeDeleted.hashCode());
		int index = hashValue % 10;
		LinkedList linkedList = hashtable[index];
		if (linkedList == null) {
			System.out.println("Word " + t + " not present in hashtable");
			return;
		}
		MyMapNode myMapNode = linkedList.getHead(), prev = null;
		while (myMapNode != null && myMapNode.getKey().compareTo(toBeDeleted) != 0) {
			prev = myMapNode;
			myMapNode = myMapNode.getNext();
		}
		if (myMapNode == null) {
			System.out.println("Word " + t + " not there in hashtable");
			return;
		}
		prev.setNext(myMapNode.getNext());
	}

	/**
	 * Prints the hashtable
	 */
	public void printHashTable() {
		System.out.println("The hashtable is as foolows- ");
		for (LinkedList linkedList : hashtable) {
			if (linkedList != null)
				linkedList.printList();
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
		hashTable.printHashTable();
		hashTable.delete("avoidable");
		hashTable.printHashTable();
	}
}