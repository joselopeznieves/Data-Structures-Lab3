package linkedLists;
/**
 * Singly linked list with references to its first and its

 * last node. 
 * 
 * @author pirvos
 *
 */

import java.util.NoSuchElementException;

import linkedLists.LinkedList;
import linkedLists.AbstractSLList.SNode;

public class SLFLList<E> extends SLList<E>
{
	private SNode<E> first, last;   // reference to the first node and to the last node
	int length; 
	
	public SLFLList() {       // to create an empty list instance
		first = last = null; 
		length = 0; 
	}
	
	
	public void addFirstNode(Node<E> nuevo) {
		((SNode<E>) nuevo).setNext(first);
		first = (SNode<E>) nuevo;
		if(length == 0) 
			last = (SNode<E>) nuevo;
		length++;
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		super.addNodeAfter(target, nuevo);
		if(((SNode<E>) nuevo).getNext() == null)
			last = (SNode<E>) nuevo;
		length++;
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		if(target == first){
			this.addFirstNode(nuevo);
		}
		else{
			Node<E> prev = getNodeBefore(target);
			addNodeAfter(prev, nuevo);
		}
		length++;
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		if(first == null) throw new NoSuchElementException("There is no first node");
		
		return first;
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		if(last == null) throw new NoSuchElementException("There is no last node");
		return last;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NoSuchElementException {
		if(((SNode<E>) target).getNext() == null) throw new NoSuchElementException("There is no node after");
		return ((SNode<E>) target).getNext();
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		if(target == first) throw new NoSuchElementException("There is no node before");
		else{
			SNode<E> prev = first; 
			while (prev != null && prev.getNext() != target) 
				prev = prev.getNext();  
			return prev; 
		}
	}

	public int length() {
		return this.length;
	}

	public void removeNode(Node<E> target) {
		if (target == first) {
			first = first.getNext();
			if(first == null){
				last = null;
			}
			else if (first.getNext() == null){
				last = first;
			}
		}
			 
		else { 
			SNode<E> prevNode = (SNode<E>) this.getNodeBefore(target); 
			prevNode.setNext(((SNode<E>) target).getNext()); 
			if(target == last){
				last = prevNode;
			}
		}
		((SNode<E>) target).clean();   // clear all references from target
		length--; 
		
	}
	
	public Node<E> createNewNode() {
		return new SNode<E>();
	}

}
