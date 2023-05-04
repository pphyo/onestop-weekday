package com.jdc.dynamic;

import java.util.Arrays;

public class UnlimitedArray<T> implements Array<T> {

	private Object[] array = new Object[0];
	
	@Override
	public boolean insert(T data) {
		
		if(null != data) {
			Object[] temp = new Object[array.length + 1];
			
			for(int i = 0; i < array.length; i++)
				temp[i] = array[i];
			
			temp[temp.length - 1] = data;
			
			array = temp;
			
			return true;
		}
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T deleteFirst() {
		if(array.length == 0)
			throw new IllegalArgumentException("No data in array!");

		var result = array[0];
		
		Object[] temp = new Object[array.length - 1];
		
		for(int i = 0; i < temp.length; i++)
			temp[i] = array[i + 1];
		
		array = temp;
		
		return (T) result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T deleteLast() {
		if(array.length == 0)
			throw new IllegalArgumentException("No data in array!");
		
		var result = array[array.length - 1];
		
		Object[] temp = new Object[array.length - 1];
		
		for(int i = 0; i < temp.length; i++)
			temp[i] = array[i];
		
		array = temp;
		
		return (T) result;
	}

	@Override
	public int delete(int index) {
		return 0;
	}
	
	public int size() {
		return array.length;
	}
	
	@SuppressWarnings("unchecked")
	public T[] getArray() {
		return (T[]) Arrays.copyOf(array, array.length);
	}

}
