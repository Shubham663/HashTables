package com.bridgelabz.hashtables;

import java.util.Scanner;

/**
 * @author Shubham, class defining data structure
 *
 */
public class LinkedList {
	private int size;
	private MyMapNode head;

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @return the head
	 */
	public MyMapNode getHead() {
		return head;
	}

	/**
	 * @author Shubham, class defining an element of Linked List
	 *
	 * @param <T>, generic data type that the linked list stores
	 */
	static class MyMapNode<T extends Comparable<T>, V> {
		private T key;
		private V value;
		private MyMapNode next;

		/**
		 * @return the next
		 */
		public MyMapNode getNext() {
			return next;
		}

		/**
		 * @param next the next to set
		 */
		public void setNext(MyMapNode next) {
			this.next = next;
		}

		/**
		 * @return the key
		 */
		public T getKey() {
			return key;
		}

		/**
		 * @param key the key to set
		 */
		public void setKey(T key) {
			this.key = key;
		}

		/**
		 * @return the value
		 */
		public V getValue() {
			return value;
		}

		/**
		 * @param value the value to set
		 */
		public void setValue(V value) {
			this.value = value;
		}

		/**
		 * @param key
		 * @param value
		 */
		public MyMapNode(T key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	/**
	 * This method adds a node at the last
	 * @param <T>,  generic type that linkedlist stores
	 * @param data, the data to be stored
	 */
	public <T extends Comparable<T>, V> void addNodeAtLast(T data, V value) {
		MyMapNode n = new MyMapNode(data, value);
		MyMapNode t = head;
		if (t == null) {
			head = n;
		} else {
			while (t.next != null)
				t = t.next;
			t.next = n;
		}
		size++;
	}

	/**
	 * prints the linked list
	 */
	public <T> void printList() {
		MyMapNode t = head;
//		System.out.println("The map entries are as follows");
		while (t != null) {
			System.out.println( t.key + " -> "+ t.value);
			t = t.next;
		}
		System.out.println();
	}

	/**
	 * @param data,the data which is searched for inside linked list 
	 * @return, returns true if data present in linked list, else returns
	 *                 false
	 */
	public <T> boolean search(T key) {
		MyMapNode n = head;
		while (n != null) {
			if (((String) n.key).compareToIgnoreCase((String) key) == 0)
				return true;
			n = n.next;
		}
		return false;
	}
}