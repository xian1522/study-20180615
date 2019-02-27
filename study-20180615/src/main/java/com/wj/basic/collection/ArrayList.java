package com.wj.basic.collection;

import java.util.Arrays;

/**
 * ��̬����
 * ��������С��10ʱ��������10,����10,������ǰ����һ������
 * �ײ�����ʵ�� ���ٲ��ң�˳�����Ԫ��;
 * ָ��λ�ò���Ԫ��/ɾ��Ԫ�أ���Ҫ�������飬�ķ����� 
 * @author Administrator
 *
 */
public class ArrayList<E> {
	
	private int size;
	
	private static final Object[] EMPTY_ELEMENTDATA = {};
	
	private static int DEFAULT_CAPACITY = 10;
	
	private Object[] elementData;
	
	public ArrayList(){
		this.elementData = EMPTY_ELEMENTDATA;
	}
	
	public static void main(String args[]){
		ArrayList<String> list = new ArrayList<String>();
		list.add("we");
		list.add("are");
		//list.add("here",0);
		System.out.print(list);
	}
	
	
	/**
	 * ����
	 * @param e
	 * @return
	 */
	public boolean add(E e){
		ensureCapacityInternal(size + 1);
		elementData[size++] = e;
		return true;
	}
	
	/**
	 * �����ָ��λ��
	 * @param e
	 * @param index
	 */
	public void add(E e,int index){
		if(index > size || size < 0){
			System.out.println("����Խ��");
			return;
		}
		ensureCapacityInternal(size + 1);
		System.arraycopy(elementData, index, elementData, index+1, size-index);
		elementData[index] = e;
		size++;
	}
	
	/**
	 * ����У��
	 * @param minCapacity
	 */
	private void ensureCapacityInternal(int minCapacity){
		if(this.elementData == EMPTY_ELEMENTDATA){
			minCapacity = Math.max(DEFAULT_CAPACITY,minCapacity);
		}
		if(minCapacity - this.elementData.length > 0){
			grow(minCapacity);
		}
	}
	
	/**
	 * ����
	 * @param minCapacity
	 */
	private void grow(int minCapacity){
		int oldCapacity = this.elementData.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		if(newCapacity < minCapacity){
			newCapacity = minCapacity;
		}
		elementData = Arrays.copyOf(this.elementData, newCapacity);
	}
	
	public String toString(){
		String str = "";
		for(Object obj : this.elementData){
			if(obj != null){
				str += obj.toString()+" ";
			}
		}
		return str;
	}
}
