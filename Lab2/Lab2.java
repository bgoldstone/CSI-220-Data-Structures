/*
 *   A Linked List Class for implementing
 *   some simple recursive functions.
 *
 *   This program uses a singly linked list without sentinel.
 *   Also note that this is a generic class.
 */
public class Lab2 {
	public static void main(String[] args) {
		/*
		 * Old code // Construct lists of Strings, Integers, and Boolean. Lab2<String>
		 * strList = new Lab2<String>();
		 * 
		 * Lab2<Boolean> boolList = new Lab2<Boolean>();
		 * 
		 * // Now populate the lists.
		 * 
		 * strList.insertFirst("I'm first"); strList.insertFirst("No you're not!");
		 * strList.insertFirst("Move down buddy");
		 * strList.insertFirst("Hey make room for me");
		 * strList.insertFirst("Move over I'm coming in");
		 * strList.insertFirst("They'll let anyone in this list");
		 * 
		 * // Create a list with 68 integers.
		 * 
		 * for (int i = 0; i < 20; i++) intList.insertFirst(i); for (int i = 20; i < 68;
		 * i++) intList.insertLast(i);
		 * 
		 * // Display the list contents
		 * 
		 * strList.display(); intList.display(); boolList.display(); // Determine the
		 * length of each list iteratively.
		 * System.out.println("\nList lengths computed iteratively\n");
		 * System.out.println("strList number of nodes: " + strList.lengthIterative());
		 * System.out.println("intListnumber of nodes: " + intList.lengthIterative());
		 * System.out.println("boolListnumber of nodes: " + boolList.lengthIterative());
		 */
		LinkedList<Integer> intList = new LinkedList<Integer>();
		for (int i = 0; i < 20; i++) {
			intList.insertLast(i);
			if (i % 5 == 0) {
				intList.insertLast(i);
				intList.insertLast(i);
				intList.insertLast(i);
				intList.insertLast(i);
				intList.insertLast(i);
			}
		}
		LinkedList<String> strList = new LinkedList<String>();
		strList.insertLast("Hello");
		strList.insertLast("World!");
		strList.insertLast("I am here");
		for (int i = 0; i < 10; i++) {
			strList.insertLast("Hello");
			strList.insertLast("World!");
		}
		strList.insertLast("Hello?");
		testMethodInt(intList);
		testMethodStr(strList);

	}

	public static void testMethodInt(LinkedList<Integer> intList) {
		System.out.println(intList.toString());
		System.out.println("InsertFirst");
		intList.insertFirst(2);
		intList.insertFirst(3);
		System.out.println(intList.toString());
		System.out.println("InsertLast");
		intList.insertLast(4);
		intList.insertLast(6);
		System.out.println(intList.toString());
		System.out.println("InsertIndex");
		intList.insertIndex(5, 1);
		System.out.println(intList.toString());
		intList.insertIndex(5, 2);
		System.out.println(intList.toString());
		intList.insertIndex(5, 3);
		System.out.println(intList.toString());
		intList.insertIndex(5, 4);
		System.out.println(intList.toString());
		System.out.println("RemoveFirst");
		intList.removeFirst();
		intList.removeFirst();
		System.out.println(intList.toString());
		System.out.println("RemoveLast");
		intList.removeLast();
		intList.removeLast();
		System.out.println(intList.toString());
		System.out.println("RemoveIndex");
		intList.removeIndex(2);
		System.out.println(intList.toString());
		intList.removeIndex(3);
		System.out.println(intList.toString());
		System.out.println("SearchByValue");
		System.out.println(intList.searchByValue(0));
		System.out.println(intList.searchByValue(10));
		System.out.println("SearchByIndex");
		System.out.println(intList.searchByIndex(3));
		System.out.println(intList.searchByIndex(23));
		System.out.println(intList.searchByIndex(0));
		System.out.println(intList.searchByIndex(500));
		System.out.println("Update");
		System.out.println(intList.Update(1, 0));
		System.out.println(intList.toString());
		System.out.println(intList.Update(5, 500));
		System.out.println(intList.Update(-1, -1));
		System.out.println(intList.Update(500, -1));
		System.out.println(intList.toString());
		System.out.println("UpdateAllw/Times");
		System.out.println(intList.UpdateAll(0, -1, 3));
		System.out.println(intList.UpdateAll(3, 2, 2));
		System.out.println(intList.toString());
		System.out.println("UpdateAll");
		System.out.println(intList.UpdateAll(-1, 0));
		System.out.println(intList.UpdateAll(2, 3));
		System.out.println(intList.toString());
	}

	public static void testMethodStr(LinkedList<String> strList) {
		System.out.println(strList.toString());
		System.out.println("InsertFirst");
		strList.insertFirst("Hello");
		strList.insertFirst("World");
		System.out.println(strList.toString());
		System.out.println("InsertLast");
		strList.insertLast("End");
		strList.insertLast("List");
		System.out.println(strList.toString());
		System.out.println("InsertIndex");
		strList.insertIndex("Inserting", 1);
		System.out.println(strList.toString());
		strList.insertIndex("Next", 2);
		System.out.println(strList.toString());
		strList.insertIndex("Middle", 3);
		System.out.println(strList.toString());
		strList.insertIndex("Last", 4);
		System.out.println(strList.toString());
		System.out.println("RemoveFirst");
		strList.removeFirst();
		strList.removeFirst();
		System.out.println(strList.toString());
		System.out.println("RemoveLast");
		strList.removeLast();
		strList.removeLast();
		System.out.println(strList.toString());
		System.out.println("RemoveIndex");
		strList.removeIndex(2);
		System.out.println(strList.toString());
		strList.removeIndex(3);
		System.out.println(strList.toString());
		System.out.println("SearchByValue");
		System.out.println(strList.searchByValue("Hello"));
		System.out.println(strList.searchByValue("World"));
		System.out.println("SearchByIndex");
		System.out.println(strList.searchByIndex(3));
		System.out.println(strList.searchByIndex(23));
		System.out.println(strList.searchByIndex(0));
		System.out.println(strList.searchByIndex(500));
		System.out.println("Update");
		System.out.println(strList.Update(1, "Update"));
		System.out.println(strList.toString());
		System.out.println(strList.Update(5, "Update"));
		System.out.println(strList.Update(-1, "Update"));
		System.out.println(strList.Update(500, "Update"));
		System.out.println(strList.toString());
		System.out.println("UpdateAllw/Times");
		System.out.println(strList.UpdateAll("Hello", "NewUpdate", 3));
		System.out.println(strList.UpdateAll("World", "UpdateNow", 2));
		System.out.println(strList.toString());
		System.out.println("UpdateAll");
		System.out.println(strList.UpdateAll("Hello", "Next"));
		System.out.println(strList.UpdateAll("World!", "Nodes"));
		System.out.println(strList.toString());
	}

}

class LinkedList<T> {
	private Node header = null; // Pointer to the head of the list.
	// private Node tail = null;

	public void LinkedList() {
		header = null;
	}

	public void insertFirst(T val) {
		Node n = new Node(); // Construct a new node - ptr points to it.

		n.val = val; // New node's data is the parameter item.
		n.next = header; // New node points to current front item.

		header = n; // The new node becomes the front node.
	}

	public void insertLast(T val) {
		Node n = new Node();
		n.val = val;
		n.next = null;

		Node temp = header;
		if (temp == null) {
			header = n;
			return;
		}

		while (temp.next != null) {
			temp = temp.next;

		}
		temp.next = n;

	}

	/*
	 * / Inserts value at specified index.
	 */
	public void insertIndex(T val, int idx) {
		// takes position of header and uses that as a placeholder
		Node pos = header;
		// Creates a node of that data
		Node temp = new Node();
		temp.val = val;

		// If empty list
		if (pos == null) {
			header = temp;
			temp.next = null;

			// if index is 1
		} else if (idx == 1) {
			Node next = header;
			header = temp;
			temp.next = next;

		} else {
			// cycles through until pos is at index.
			for (int i = 0; i < idx - 2; i++) {
				// if index does not exist insert it at end of list
				if (pos.next == null) {
					pos.next = temp;
					temp.next = null;
					return;
					// else increment the position
				} else
					pos = pos.next;
			}
			Node next = pos.next;
			// sets before index
			pos.next = temp;
			// sets next index
			temp.next = next;

		}

	}

	/*
	 * Removes the first node
	 */
	public void removeFirst() {
		// sets header to next node.
		header = header.next;
	}

	/*
	 * Removes the last node
	 */
	public void removeLast() {
		// Keeps track of position
		Node pos = header;
		// Returns next to last node
		while (pos.next.next != null) {
			pos = pos.next;
		}
		// Sets next to last node's next to null
		pos.next = null;
	}

	public void removeIndex(int idx) {
		Node pos = header;
		for (int i = 0; i < idx - 2; i++) {
			pos = pos.next;
		}
		pos.next = pos.next.next;
	}

	/*
	 * Searches for index position by value
	 */
	public int searchByValue(T val) {
		// Keeps track of position
		Node pos = header;
		int i = 1;
		// Iterates through the List
		while (pos.next != null) {
			// If the value is correct, return the index
			if (pos.val.equals(val))
				return i;
			// else "increment the index"
			else {
				pos = pos.next;
				i++;
			}
		}
		// if no value found return -1
		System.out.println("Value does not exist!");
		return -1;
	}

	public T searchByIndex(int idx) {
		Node pos = header;
		int i = 1;
		while (pos.next != null) {
			if (i == idx)
				return (T) pos.val;
			i++;
			pos = pos.next;
		}
		System.out.println("Index does not exist!");
		return null;
	}

	/*
	 * Updates value in specified index. Returns true if successfully else Returns
	 * false if unsuccessfully.
	 */
	public boolean Update(int idx, T newVal) {
		// Keeps track of position
		Node pos = header;
		int i = 1;
		// Iterates through the List
		while (pos.next != null) {
			// if right index, update the value
			if (i == idx) {
				pos.val = newVal;
				return true;
				// else "increment the index"
			} else {
				pos = pos.next;
				i++;
			}
		}
		// if index is not found return false
		return false;
	}

	/*
	 * Updates all old values with new values
	 */
	public int UpdateAll(T oldVal, T newVal, int times) {
		// Keeps track of position
		Node pos = header;

		int updatesMade = 0;

		// Iterates through the list
		while (updatesMade < times && pos.next != null) {
			// if position is oldVal, update it.
			if (pos.val.equals(oldVal)) {
				pos.val = newVal;
				// Adds one to the count of updates made
				updatesMade++;
			}
			// increments through list
			pos = pos.next;

		}
		return updatesMade;
	}

	/*
	 * Updates all old values with new values
	 */
	public int UpdateAll(T oldVal, T newVal) {
		// Keeps track of position
		Node pos = header;
		// counts number of updates
		int updatesMade = 0;

		// Iterates through the list
		while (pos.next != null) {

			// if position is oldVal, update it.
			if (pos.val.equals(oldVal)) {
				pos.val = newVal;
				// Adds one to the count of updates made
				updatesMade++;
			}
			// increments through list
			pos = pos.next;

		}
		return updatesMade;
	}

	/*
	 * Returns the LinkedList in a String Form
	 */
	public String toString() {
		// Keeps track of position
		Node pos = header;
		// Starts StringBuilder
		StringBuilder sb = new StringBuilder("[");
		// Iterates through the LinkedList
		while (pos != null) {
			// "Pulls value" from Node
			sb.append(pos.val);
			sb.append(",");
			// "increments" position
			pos = pos.next;
		}
		sb.append("]");
		return sb.toString();
	}

	/*
	 * Enter a data item at the front of the list.
	 */

	/*
	 * lengthIterative()
	 *
	 * Return the length of the list.
	 */

	public int lengthIterative() {
		Node ptr = header; // A pointer to travel the list.
		int count = 0; // Counts the number of nodes.

		while (ptr != null) // While not at the end of the list.
		{
			count++; // Add this node to the count.
			ptr = ptr.next; // Move to the next node.
		}

		return count; // Return the number of nodes.
	}

	/*
	 * Display the contents of the linked list.
	 */
	/*
	 * Old toString class? public void display() { Node ptr = header; // Pointer to
	 * traverse the list.
	 * 
	 * while (ptr != null) { // While not at the end of the list ... T data =
	 * ptr.val; // Get data of current node. System.out.println(data.toString()); //
	 * Print the data. ptr = ptr.next; // Move to the next node. }
	 * 
	 * System.out.println(""); }
	 */

	/*
	 * Inner Class - Node objects for a singly linked list.
	 *
	 */

	private class Node {
		public T val; // Data stored in the Node.
		public Node next; // Pointer to next Node in the list.

	}

}