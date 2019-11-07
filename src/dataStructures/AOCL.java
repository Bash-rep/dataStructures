package dataStructures;

public class AOCL {
	
	DoublyLinkedList<Integer>[] elements;
	int size;
	
	
	public void initialize(int size){
		this.size = size;
		for(int i = 0 ; i < size ; i++) {
			elements[i] = new DoublyLinkedList<Integer>();
		}
	}
	
	public void insert(int index,int element) {
		elements[index].addFirst(element);
	}
	
	public  DoublyLinkedList<Integer> concatAll() {
		return null;
	}
}
