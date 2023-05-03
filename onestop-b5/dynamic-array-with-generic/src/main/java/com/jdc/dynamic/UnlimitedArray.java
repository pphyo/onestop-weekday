package com.jdc.dynamic;

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

	@Override
	public int deleteFirst() {
		return 0;
	}

	@Override
	public int deleteLast() {
		return 0;
	}

	@Override
	public int delete(int index) {
		return 0;
	}
	
	public int size() {
		return this.array.length;
	}

}
