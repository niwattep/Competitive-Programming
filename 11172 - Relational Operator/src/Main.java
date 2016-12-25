import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			int a = s.nextInt();
			int b = s.nextInt();
			String op = "";
			if (a > b) op = ">";
			if (a < b) op = "<";
			if (a == b) op = "=";
			System.out.println(op);
		}
	}

}
