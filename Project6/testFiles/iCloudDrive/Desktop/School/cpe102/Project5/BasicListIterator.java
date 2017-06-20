public interface BasicListIterator<E> extends java.util.Iterator<E> {
	
	//Methods
	public boolean hasPrevious();
	//returns true if the iterator has a previous element

	public E previous();
	//returns the previous element and moves the iterator backward one position with O(1) performance

	//hasNext, next, and remove all are inherited from interface 

}