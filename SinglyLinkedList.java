package dataStructures;

public class SinglyLinkedList<E> implements List<E> {
	// Node at the head of the list.
	protected SListNode<E> head;

	// Node at the tail of the list.
	protected SListNode<E> tail;

	// Number of elements in the list.
	protected int currentSize;

	@Override
	public boolean isEmpty() {
		return currentSize == 0;
	}

	@Override
	public int size() {
		return currentSize;
	}

	@Override
	public Iterator<E> iterator() throws NoElementException {
		if (currentSize == 0)
			throw new NoElementException("List is empty.");
		return new SinglyLLIterator<E>(head);
	}

	@Override
	public int find(E element) {
		SListNode<E> auxNo = head;
		int index = 0;
		while (auxNo != null) {
			if (auxNo.getElement().equals(element))
				return index;
			auxNo = auxNo.next;
			index++;
		}
		return -1;
	}

	@Override
	public E getFirst() throws NoElementException {
		return head.getElement();
	}

	@Override
	public E getLast() throws NoElementException {
		return tail.getElement();
	}

	@Override
	public E get(int position) throws InvalidPositionException {
		SListNode<E> aux = head;
		for (int i = 0; i < position; i++) {
			aux = aux.next;
		}
		return aux.getElement();
	}

	@Override
	public void addFirst(E element) {
		SListNode<E> newNo = new SListNode<E>(element, head);
		head = newNo;
		currentSize++;
		if(currentSize == 1) {
			tail = newNo;
		}
	}

	@Override
	public void addLast(E element) {
		SListNode<E> newNo = new SListNode<E>(element, null);
		if (tail != null)
			tail.next = newNo;
		tail = newNo;
		if (++currentSize == 1)
			head = newNo;
	}

	@Override
	public void add(int position, E element) throws InvalidPositionException {
		if (position < 0 || position > currentSize)
			throw new InvalidPositionException("Invalid Position.");
		if(position == 0) addFirst(element);
		else if(position == currentSize) addLast(element);
		else addMiddle(position,element);
	}

	private void addMiddle(int position, E element) {
		SListNode<E> pre = getNode(position-1);
		SListNode<E> aft = pre.next;
		SListNode<E> newNo = new SListNode<E>(element, aft);
		pre.next = newNo;
		currentSize++;
	}

	private SListNode<E> getNode(int position) {
		SListNode<E> auxNo = head;
		for(int i = 0 ; i <= position ; i++) {
			auxNo = auxNo.next;
		}
		return auxNo;
	}

	@Override
	public E removeFirst() throws NoElementException {
		if(isEmpty()) throw new NoElementException();
		SListNode<E> auxNo = head;
		head = auxNo.next;
		currentSize--;
		if(currentSize == 0) tail = null;
		return auxNo.getElement();
	}

	@Override
	public E removeLast() throws NoElementException {
		if(isEmpty()) throw new NoElementException();
		SListNode<E> auxNo = tail;
		//caso especial lista com 1 elemento
		if(currentSize == 1) {
			tail = null; head = null;
			currentSize--;
			return auxNo.getElement();
		}
		SListNode<E> prev = getNode(currentSize-2);
		prev.next = null;
		tail = prev;
		currentSize--;
		return auxNo.getElement();
	}

	@Override
	public E remove(int position) throws InvalidPositionException {
		if (position < 0 || position >= currentSize)
			throw new InvalidPositionException("Invalid position.");
		if (position == 0)
			return removeFirst();
		if (position == currentSize - 1)
			return removeLast();
		return removeMiddle(position);
	}

	private E removeMiddle(int position) {
		SListNode<E> prev = getNode(position-1);
		SListNode<E> toRemove = prev.next;
		SListNode<E> next = toRemove.next;
		prev.next = next;
		currentSize--;
		return toRemove.getElement();
	}

}
