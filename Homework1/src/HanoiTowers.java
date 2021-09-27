import java.util.Scanner;

public class HanoiTowers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("How many disks for the tower of Hanoi? ");
		int disks = scan.nextInt();
		scan.close();
		hanoi(disks, 'A', 'C', 'B');
	}

	public static void hanoi(int numberOfDisks, char startRod, char endRod, char centerRod) {
		if (numberOfDisks == 1) {
			System.out.println("Move disk #1 from rod " + startRod + " to rod " + endRod);
			return;
		} else {
			hanoi(numberOfDisks - 1, startRod, centerRod, endRod);
			System.out.println("Move disk #" + numberOfDisks + " from rod " + startRod + " to rod " + endRod);
			hanoi(numberOfDisks - 1, centerRod, endRod, startRod);
		}
	}
}
