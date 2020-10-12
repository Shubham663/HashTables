package com.bridgelabz.hashtables;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class HashTableTest {
	HashTable hashTable;

	@Before
	public void initialize() {
		hashTable = new HashTable();
		String input = new String("Paranoids are not paranoid because they are paranoid but"
				+ " because they keep putting themselves deliberately into paranoid "
				+ "avoidable situations");
		String[] words = input.split(" ");
		for (String word : words)
			hashTable.add(word);
	}

	/**
	 * Checks for deletion of word
	 */
	@Test
	public void deleteKeyTest_Correct() {
		hashTable.delete("avoidable");
		int index = (Math.abs("avoidable".hashCode())) % 10;
		assertFalse(hashTable.hashtable[index].search("avoidable"));
	}

	/**
	 * Checks for correct non deletion of word
	 */
	@Test
	public void deleteKeyTest_InCorrect() {
		hashTable.delete("to");
		int index = (Math.abs("avoidable".hashCode())) % 10;
		assertTrue(hashTable.hashtable[index].search("avoidable"));
	}
}
