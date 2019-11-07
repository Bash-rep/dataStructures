package dataStructures;

public class Main {
	public static void main(String args[]) {
		int size = 10;

		AOCL test = new AOCL(size);
		
		
		test.insert(1, 1);
		test.insert(1, 2);
		test.insert(1, 3);
		test.insert(1, 4);
		test.insert(1, 5);
		test.insert(7, 6);
		test.insert(8, 7);
		test.insert(8, 8);

		DListNode<Integer> node = test.concatAll();
		
		if(node.next == null) {
			System.out.println("something is wrong");
		}
		
		while (node != null) {
			System.out.println(node.getElement().toString()+" ;");
			node = node.next;
		}
	}
}
