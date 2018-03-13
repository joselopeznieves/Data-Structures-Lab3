package linkedLists;

import java.util.NoSuchElementException;

/** Clonable problem: 
 * It would not suffice to add an intermediate AbstractLinkedList class
 * since at that level, there is not enough information on how the
 * lists are implemented. SLL and DLL are implemented differently 
 * and they deal with nodes differently. In order to properly 
 * implement a clone method, the method would need to know 
 * how are the internal nodes of each class handled.  
 * **/ 

public interface LinkedList<E> {
	
	/**
	 * Determines the number of nodes currently in the linked list. 
	 * @return integer value (>= 0) corresponding to the number of
	 * nodes actually in the linked list.
	 */
	int length(); 

	/**
	 * 
	 * @param target
	 * @return
	 * @throws NoSuchElementException
	 */
	Node<E> getNodeBefore(Node<E> target) throws NoSuchElementException; 
	
	/**
	 * 
	 * @param target
	 * @return
	 * @throws INoSuchElementException
	 */
	Node<E> getNodeAfter(Node<E> target) throws NoSuchElementException; 
	
	/**
	 *  @return reference to the first node of the linked list
	 *  @throws INoSuchElementException if the linked list is empty
	 */
	Node<E> getFirstNode() throws NoSuchElementException; 
	
	/**
	 * 
	 * @return
	 * @throws INoSuchElementException
	 */
	Node<E> getLastNode() throws NoSuchElementException; 
	
	/**
	 * 
	 * @param nuevo
	 */
	void addFirstNode(Node<E> nuevo); 
	
	/**
	 * 
	 * @param newNode
	 */
	void addLastNode(Node<E> newNode); 
	
	/**
	 * 
	 * @param target
	 * @param nuevo
	 */
	void addNodeAfter(Node<E> target, Node<E> nuevo); 
	
	/**
	 * 
	 * @param target
	 * @param nuevo
	 */
	void addNodeBefore(Node<E> target, Node<E> nuevo); 
		
	/**
	 * 
	 * @param target
	 */
	void removeNode(Node<E> target); 
	
		
	/**
	 * Creates a new node instance of the type of nodes that the linked list
	 * uses. The new node will have all its instance fields initialized to
	 * null. The new node is not linked to the list in any way.
	 * @return reference to the new node instance. 
	 */
	Node<E> createNewNode(); 

}
