package dataStructures;

import java.util.Scanner;

public class Main {
	static int TESTING_VALUE = 1000;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String cmd = "";

		while (!cmd.equalsIgnoreCase("exit")) {
			cmd = in.nextLine().toLowerCase().trim();

			switch (cmd.toLowerCase()) {
			case "dlllast":
				readDll(in);
				break;
			case "dllfirst":
				readDllFirst(in);
				break;
			case "dllmidle":
				readDllMidle(in);
				break;
			case "dllfail":
				testFail();
				break;
			//TODO remove
			default:
				System.out.println("invalid cmd");
			}
		}
		System.out.println("============");
		System.out.println("     END    ");
		System.out.println("============");
	}

	private static void testFail() {
		DoublyLinkedList<String> dll = new DoublyLinkedList<>();
		// search for an invalid element
		dll.addLast("tail");
		if (dll.find("head") == -1)
			System.out.println("invalid find success");

		// add to an invalid position
		try {
			dll.add(10, "fail");
		} catch (InvalidPositionException e) {
			System.out.println("invalid add success");
		}

		
		// more?
	}

	private static void readDllMidle(Scanner in) {
		String toAdd = "";
		int index = 0;
		DoublyLinkedList<String> dll = new DoublyLinkedList<>();

		loop: while (true) {
			System.out.print(">");
			toAdd = in.nextLine().trim();
			if (toAdd.equalsIgnoreCase("end"))
				break loop;
			dll.add(index++, toAdd);
		}

		Iterator<String> it = dll.iterator();
		System.out.println("get || iterator || find");
		for (int i = 0; i < dll.size(); i++) {
			String curr = dll.get(i);
			System.out.println(curr + " || " + it.next() + " || " + dll.find(curr));
		}
	}

	private static void readDllFirst(Scanner in) {
		String toAdd = "";

		DoublyLinkedList<String> dll = new DoublyLinkedList<>();

		loop: while (true) {
			System.out.print(">");
			toAdd = in.nextLine().trim();
			if (toAdd.equalsIgnoreCase("end"))
				break loop;
			dll.addFirst(toAdd);
		}

		Iterator<String> it = dll.iterator();
		System.out.println("get || iterator || find");
		for (int i = 0; i < dll.size(); i++) {
			String curr = dll.get(i);
			System.out.println(curr + " || " + it.next() + " || " + dll.find(curr));
		}
	}

	private static void readDll(Scanner in) {
		String toAdd = "";

		DoublyLinkedList<String> dll = new DoublyLinkedList<>();

		loop: while (true) {
			System.out.print(">");
			toAdd = in.nextLine().trim();
			if (toAdd.equalsIgnoreCase("end"))
				break loop;
			dll.addLast(toAdd);
		}

		Iterator<String> it = dll.iterator();
		System.out.println("get || iterator || find");
		for (int i = 0; i < dll.size(); i++) {
			String curr = dll.get(i);
			System.out.println(curr + " || " + it.next() + " || " + dll.find(curr));
		}
	}
}
