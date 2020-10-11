package com.bridgelabz.hashtables;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class HashTableTest 
{
	HashTable hashTable;
	
	@Before
	public void initialize() {
		hashTable = new HashTable();
		String input = new String("To be or not to be");
		String []words = input.split(" ");
		for(String word : words)
			hashTable.add(word);
	}
    
    /**
     * Checks that a particular value is present inside hashtable
     */
    @Test
    public void findFrequencyTest_Correct(){
        assertTrue(hashTable.hashtable.search("To"));
    }
    
    /**
     * Checks that a particular value is not present inside hashtable
     */
    @Test
    public void findFrequencyTest_InCorrect(){
        assertFalse(hashTable.hashtable.search("nothing"));
    }
}
