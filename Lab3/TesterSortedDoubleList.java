public class TesterSortedDoubleList {
	public static void main(String[] args) {
		// initialize lists
		SortedDoubleList<String> strList = new SortedDoubleList<>();
		SortedDoubleList<Integer> intList = new SortedDoubleList<>();
		int[] ints = { 5, 2, 3, 6, 45, 8, 4, 60, 4, 5, 500, 7, 45785, 658, 4 };
		for (int item : ints) {
			intList.insert(item);
		}
		String[] strs = { "Hello", "I", "Am", "A", "Sorted", "List", "Hopefully", "I", "Hope", "I" };
		for (String item : strs) {
			strList.insert(item);
		}
		printLists(intList, strList);
		// test cases

		// size
		System.out.println("\nInt Size: " + intList.size());
		System.out.println("Str Size: " + strList.size());

		// Front
		System.out.println("\nInt List Front: " + intList.front());
		System.out.println("Str List Front: " + strList.front());

		// Back
		System.out.println("\nInt List Back: " + intList.back());
		System.out.println("Str List Back: " + strList.back());

		// Count
		System.out.println("\nInt List Count: " + intList.count(5));
		System.out.println("Str List Count: " + strList.count("I"));

		// pop front
		System.out.println("\nBefore");
		printLists(intList, strList);
		System.out.println("Int list pop: " + intList.pop_front());
		System.out.println("Str list pop: " + strList.pop_front());
		System.out.println("After pop_front()");
		printLists(intList, strList);

		// pop back
		System.out.println("\nBefore");
		printLists(intList, strList);
		System.out.println("Int list pop: " + intList.pop_back());
		System.out.println("Str list pop: " + strList.pop_back());
		System.out.println("After pop_back()");
		printLists(intList, strList);

		// erase
		System.out.println("\nBefore");
		printLists(intList, strList);
		System.out.println("Int list remove: " + intList.erase(4));
		System.out.println("Str list remove: " + strList.erase("I"));
		System.out.println("After erase()");
		printLists(intList, strList);

	}

	/**
	 * Prints both Lists.
	 *
	 * @param intList Integer List.
	 * @param strList String List.
	 */
	public static void printLists(SortedDoubleList<Integer> intList, SortedDoubleList<String> strList) {
		System.out.println(intList.toString());
		System.out.println(strList.toString());
	}
}
