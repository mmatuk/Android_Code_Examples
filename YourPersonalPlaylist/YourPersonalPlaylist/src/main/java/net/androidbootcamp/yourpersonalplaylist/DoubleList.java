//************************************************************************
//	DoubleList.java 						Matt Matuk
// 	CSIT 268								Project 6-6
//	1.	This class will contain all the methods needed to create a 
//	double linked list
//	2.	The class will be the parent class for DoubleOrderList
//	3.	All methods are public and void unless otherwise stated
//	4.	All methods and variables are generic unless otherwise stated
// 	5.	This class will also contain a private class for the Iterator
//	6.	This class will be adstract
//************************************************************************	

package net.androidbootcamp.yourpersonalplaylist;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class DoubleList<T> implements Iterable<T>
{
	protected int count;
	protected DoubleNode<T> head, tail;
	protected int modCount;
	
	/**
	 * Removes the first element
	 * 
	 * @return The element that will be removed
	 */
	public T removeFirst()
	{
		if (!isEmpty())
		{
			T result = head.getElement();
			DoubleNode<T> tmp = head.getNext();
			tmp.setPrevious(null);
			head = tmp;
			
			count--;
			modCount++;
			
			return result;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Removes the last element 
	 * 
	 * @return The element removed
	 */
	public T removeLast()
	{
		if (!isEmpty())
		{
			T result = tail.getElement();
			DoubleNode<T> tmp = tail.getPrevious();
			tmp.setNext(null);
			tail = tmp;
			
			count--;
			modCount++;
			
			return result;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Removes a certain element
	 * 
	 * @exception Throws exception if the element was not found
	 * @param element The element to be removed
	 * @return The element that was removed
	 */
	public T remove(T element)
	{
		DoubleNode<T> tmp = find(element);
		
		if (tmp == null)
		{
			throw new NoSuchElementException("DoubleList");
		}
		else
		{
			DoubleNode<T> previous, next;
			
			if (tmp == head) // if element = the first element
			{
				next = head.getNext();
				next.setPrevious(null);
				head = next;
			}
			else if (tmp == tail) //  if element = the last element
			{
				previous = tail.getPrevious();
				previous.setNext(null);
				tail = previous;
			}
			else
			{
				previous = tmp.getPrevious();
				next = tmp.getNext();
				previous.setNext(next);
				next.setPrevious(previous);
			}
			
			count--;
			modCount++;
			
			return tmp.getElement();
		}
	}
	
	/**
	 * 
	 * @return The first element 
	 */
	public T first()
	{
		return head.getElement();
	}
	
	/**
	 * 
	 * @return The last element
	 */
	public T last()
	{
		return tail.getElement();
	}
	
	/**
	 * 
	 * @return True if empty
	 */
	public boolean isEmpty()
	{
		return (count == 0);
	}
	
	/**
	 * 
	 * @return The size of teh collection
	 */
	public int size()
	{
		return count;
	}
	
	/**
	 * Creates a iterator for the collection
	 * 
	 * @return the iterator created
	 */
	public Iterator<T> iterator()
	{
		return new DoubleIterator();
	}
	
	/**
	 * Find a certain element
	 * 
	 * @param target Element to be found
	 * @return The node which contains the element
	 */
	public DoubleNode<T> find(T target)
	{
		DoubleNode<T> result = null;
		DoubleNode<T> current = head;
		
		if (!isEmpty())
		{
			while (result == null && current != null)
			{
				if (current.getElement().equals(target))
				{
					result = current;
				}
				else
				{
					current = current.getNext();
				}
			}
		}
		return result;
	}
	
	/**
	 * Checks to see if a certain element is in the collection 
	 * 
	 * @param target The target element 
	 * @return True if found 
	 */
	public boolean contains(T target)
	{
		return (find(target) != null);
	}
	
	/**
	 * Converts the last to Strings
	 * @return The String which contains all the elements in the collection
	 */
	public String toString()
	{
		String result = "";
		
		if (count == 0)
		{
			result = "Empty";
		}
		else
		{
			DoubleNode<T> tmp = head.getNext();
			result = (String)head.getElement();
			while (tmp.getNext() != null)
			{
				result = result + "\n" + tmp.getElement();
				tmp = tmp.getNext();
			}
			result = result + "\n" + tmp.getElement();
		}
		return result;
	}
	
	/**
	 * A private class that contains the iterator for this collection
	 * @author Matt
	 *
	 */
	private class DoubleIterator implements Iterator<T>
	{
		private int iteratorModCount;
		private DoubleNode<T> current;
		
		/**
		 * Create the iterator
		 */
		public DoubleIterator()
		{
			current = head;
			iteratorModCount = modCount;
		}
		
		/**
		 * Checks to see if the iterator has another item.
		 * 
		 * @return True if there is another item
		 */
		public boolean hasNext() throws ConcurrentModificationException
		{
			if (iteratorModCount != modCount)
			{
				throw new ConcurrentModificationException();
			}
			
			return (current != null);
		}
		
		/**
		 * returns the next item in the iteration
		 */
		public T next() throws NoSuchElementException
		{
			if (hasNext() == false)
			{
				throw new NoSuchElementException();
			}
			
			T result = current.getElement();
			current = current.getNext();
			return result;
		}
		
		public void remove()
		{	
		}
	
	}

}
