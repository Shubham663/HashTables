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
		int val = (  Math.abs("to".hashCode())  ) % 10;
        assertNotNull(hashTable.hashtable[val]);
    }
    
    /**
     * Checks that a particular value is not present inside hashtable
     */
    @Test
    public void findFrequencyTest_InCorrect(){
    	int val = (  Math.abs("noto".hashCode())  ) % 10;
        assertNull(hashTable.hashtable[val]);
    }
}
