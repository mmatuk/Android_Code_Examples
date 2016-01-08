//************************************************************************
//	DoubleOrderList.java 						Matt Matuk
// 	CSIT 268								Project 6-6
//	1.	This class extends the DoubleList class and adds the add 
//	method to the class. 
//	2.	The add method will add items to the list in the proper order
//	3.	All methods and variables are generic 
//	4.	All methods are public unless otherwise stated
//************************************************************************	

package net.androidbootcamp.yourpersonalplaylist;

public class DoubleOrderList<T> extends DoubleList<T>
{
	public DoubleOrderList()
	{
		count = 0;
		head = tail = null;
	}
	
	/**
	 * Adds a element to the list and places the element in the proper 
	 * order. Keeps the list ordered.
	 * 
	 * @param element The element to be added
	 * @throws Exception Thrown of the element is not comparable
	 */
	public void add(T element) throws Exception
	{
		if (!(element instanceof Comparable))
		{
			throw new Exception("Element is not comparable");
		}
		
		// this is for if the list is empty
		if (isEmpty())
		{
			head = new DoubleNode<T>(element);
			tail = head;
		}
		else
		{
			@SuppressWarnings("unchecked")
			Comparable<T> comparableElement = (Comparable<T>)element;
			
			DoubleNode<T> previous = null;
			DoubleNode<T> current = head;
			DoubleNode<T> newNode = new DoubleNode<T>(element);
			int scan = 0;
			
			// loops until the element goes before the current element 
			// being checked
			while ((scan < count && current != null) && comparableElement.compareTo(current.getElement()) < 0)
			{
				previous = current;
				current = current.getNext();
			}
			
			if (current == head) // if the element goes at the front
			{
				head.setPrevious(newNode);
				newNode.setNext(head);
				head = newNode;
				head.setPrevious(tail);
				tail.setNext(head);
			}
			else if (current == null) // if the element goes at the end
			{
				tail.setNext(newNode);
				newNode.setPrevious(tail);
				tail =newNode;
				tail.setNext(head);
				head.setPrevious(tail);
			}
			else
			{
				previous.setNext(newNode);
				newNode.setPrevious(previous);
				newNode.setNext(current);
				current.setPrevious(newNode);
			}
			
		}
		
		count++;
		modCount++;
	}
}
