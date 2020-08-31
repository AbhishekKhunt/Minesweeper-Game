import java.util.Scanner;

public class Utility {
	static Scanner sc = new Scanner(System.in);

	static int getInt(String message) {
		System.out.print(message);
		return sc.nextInt();
	}

	static int generateRandomNumber(int num) {
		return (int) (Math.random() * num);
	}

}
