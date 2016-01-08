//************************************************************************
//	DoubleNode.java 						Matt Matuk
// 	CSIT 268								Project 6-6
//	1.	This class is a double node that will contains a reference
//	to the next and previous nodes.
//	2.	This class will also contain a element
//	3.	All methods and variables are generic
//************************************************************************	

package net.androidbootcamp.yourpersonalplaylist;

public class DoubleNode<T> 
{
	private DoubleNode<T> next, previous;
	private T element;
	
	/**
	 * Creates a Double linked node with a element
	 */
	public DoubleNode()
	{
		element = null;
		next = previous = null;
	}
	
	/**
	 * Creates a double linked node with a passed element
	 * 
	 * @param elem The element to be set for this node
	 */
	public DoubleNode(T elem)
	{
		element = elem;
		next = previous = null;
	}
	
	/**
	 * Sets the next node
	 * 
	 * @param node Node to be set
	 */
	public void setNext(DoubleNode<T> node)
	{
		next = node;
	}
	
	/**
	 * Sets the previous node
	 * 
	 * @param node The node to be set
	 */
	public void setPrevious(DoubleNode<T> node)
	{
		previous = node;
	}
	
	/**
	 * Gets the next node
	 * 
	 * @return The next node
	 */
	public DoubleNode<T> getNext()
	{
		return next;
	}
	
	/**
	 * Gets the previous node
	 * 
	 * @return The previous node
	 */
	public DoubleNode<T> getPrevious()
	{
		return previous;
	}
	
	/**
	 * Gets the element for this node
	 * 
	 * @return The element
	 */
	public T getElement()
	{
		return element;
	}
	
	/**
	 * Sets the element for this node
	 * 
	 * @param elem Element to be set
	 */
	public void setElement(T elem)
	{
		element = elem;
	}

}
