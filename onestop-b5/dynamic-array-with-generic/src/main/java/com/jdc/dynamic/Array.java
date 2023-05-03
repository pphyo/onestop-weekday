package com.jdc.dynamic;

/**
 * 
 * @author pphyo
 *
 */

public interface Array<T> {
	
	// insert
	boolean insert(T data);
	
	// delete first element
	int deleteFirst();
	
	// delete last element
	int deleteLast();
	
	// delete at specific index
	int delete(int index);
	

}
