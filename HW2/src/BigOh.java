
public class BigOh {

	public static void main(String[] args) {
		numberOne(10);
		numberThree(10);
		numberOne(100);
		numberThree(100);
		numberOne(1000);
		numberThree(1000);
		numberOne(100000);
		numberThree(10000);
	}

	public static void numberOne(int n) {
		long sum = 0;
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n * n; j++) {
				for (int k = 0; k < n + 2; k++) {
					sum++;

				}
			}
		}
		System.out.println(n + ": " + sum);
	}

	public static void numberThree(int n) {
		long sum1 = 0;
		long sum2 = 0;
		for (int i = 0; i < n + 1; i++) {
			if (i < 5) {
				for (int k = 0; k < n; k++) {
					sum1++;
				}
			} else {
				sum2++;
			}
		}
		System.out.println(n + ": " + sum1);
		System.out.println(n + ": " + sum2);
	}
}