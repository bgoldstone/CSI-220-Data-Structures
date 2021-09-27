
public class CircleList {
	Node header;
	Node tail;

	public CircleList() {
		header = null;
		tail = null;
	}

	/**
	 * Inserts new Node in the end of the List.
	 * 
	 * @param val an integer value containing the new value.
	 */
	public void insert(int val) {
		Node newNode = new Node(val);
		if (header == null) {
			header = newNode;
			header.next = header;
			tail = newNode;
		} else {

			tail.next = newNode;
			newNode.next = header;
			tail = newNode;
		}
	}

	public class Node {
		private int data;
		public Node next;

		public Node() {
			data = -99;
			next = null;
		}

		public Node(int data) {
			this.data = data;
			next = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

	}
}