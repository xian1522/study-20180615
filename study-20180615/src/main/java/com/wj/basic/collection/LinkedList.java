package com.wj.basic.collection;

public class LinkedList<E> {
	
	Node<E> last;
	Node<E> first;
	
	private int size;
	
	public LinkedList() {
		
	}
	
	public boolean add(E e) {
		linkLast(e);
		return true;
	}
	
	void linkLast(E e) {
		Node<E> l = last;
		Node<E> newNode = new Node<E>(l,e,null);
		last = newNode;
		if(l==null) {
			first = newNode;
		}else {
			l.next = newNode;
		}
		size++;
	}
	
	private static class Node<E>{
		E item;
		Node<E> prev;
		Node<E> next;
		
		Node(Node<E> prev,E item, Node<E>next){
			this.prev = prev;
			this.item = item;
			this.next = next;
		}
	}
}
