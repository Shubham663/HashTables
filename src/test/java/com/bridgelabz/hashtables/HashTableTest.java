package com.bridgelabz.hashtables;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.bridgelabz.hashtables.LinkedList.MyMapNode;

/**
 * Unit test for simple App.
 */
public class HashTableTest 
{
	HashTable hashTable;
	
	@Before
	public void initialize() {
		hashTable = new HashTable();
		String input = new String("Paranoids are not paranoid because they are paranoid"
				+ " but because they keep putting themselves deliberately into paranoid"
				+ " avoidable situations");
		String []words = input.split(" ");
		for(String word : words)
			hashTable.add(word);
	}
    
    /**
     * Checks that a particular value is present inside hashtable
     */
    @Test
    public void findFrequencyTest_Correct(){
		int val = (  Math.abs("into".hashCode())  ) % 10;
        assertNotNull(hashTable.hashtable[val]);
    }
    
    /**
     * Checks that a particular value is not present inside hashtable
     */
    @Test
    public void findFrequencyTest_InCorrect(){
    	int index = (  Math.abs("notonoto".hashCode())  ) % 10;
    	LinkedList linkedList = hashTable.hashtable[index];
    	MyMapNode myMapNode = linkedList.getHead();
    	while(myMapNode != null && myMapNode.getKey().compareTo("notonoto") != 0)
    		myMapNode = myMapNode.getNext();
    	assertNull(myMapNode);
    }
}
