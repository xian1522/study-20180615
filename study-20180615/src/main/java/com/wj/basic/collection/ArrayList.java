package com.wj.basic.collection;

import java.util.Arrays;

/**
 * 动态数组
 * 数组容量小于10时，扩容至10,大于10,新增当前数据一半容量
 * 底层数组实现 快速查找，顺序添加元素;
 * 指定位置插入元素/删除元素，需要复制数组，耗费性能 
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
	 * 新增
	 * @param e
	 * @return
	 */
	public boolean add(E e){
		ensureCapacityInternal(size + 1);
		elementData[size++] = e;
		return true;
	}
	
	/**
	 * 添加至指定位置
	 * @param e
	 * @param index
	 */
	public void add(E e,int index){
		if(index > size || size < 0){
			System.out.println("数组越界");
			return;
		}
		ensureCapacityInternal(size + 1);
		System.arraycopy(elementData, index, elementData, index+1, size-index);
		elementData[index] = e;
		size++;
	}
	
	/**
	 * 容量校验
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
	 * 扩容
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
