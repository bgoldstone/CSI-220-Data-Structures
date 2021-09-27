import java.util.Scanner;

public class fibonacci1 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Scanner scan = new Scanner(System.in);
		System.out.print("What fibonaci number would you like? ");
		int numTimes = scan.nextInt();
		scan.close();
		long[] numbers;
		System.out.println();

		if ((numTimes == 0) || (numTimes == 1))
			System.out.println(numTimes);
		else {
			numTimes++;
			numbers = new long[numTimes];
			numbers[0] = 0;
			numbers[1] = 1;
			for (int i = 2; i < numTimes; i++) {
				numbers[i] = numbers[i - 1] + numbers[i - 2];
			}
			System.out.println(numbers[numbers.length - 1]);
		}
		System.out.println((System.currentTimeMillis() - startTime) / 1000 + "s");
	}
}
