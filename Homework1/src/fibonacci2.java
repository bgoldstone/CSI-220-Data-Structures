import java.util.Scanner;

public class fibonacci2 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Scanner scan = new Scanner(System.in);
		System.out.print("What Fibonacci Number would you like ");
		int numTimes = scan.nextInt();
		scan.close();
		System.out.println();
		if ((numTimes == 0) || (numTimes == 1)) {
			System.out.println(numTimes);
		}
		System.out.println(fibonacci(numTimes));
		System.out.println((System.currentTimeMillis() - startTime) / 1000 + "s");
	}

	public static long fibonacci(long numTimes) {
		if ((numTimes == 0) || (numTimes == 1)) {
			return numTimes;
		}
		return fibonacci(numTimes - 1) + fibonacci(numTimes - 2);
	}
}
