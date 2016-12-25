import java.util.*;
import java.math.*;
class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			int n = s.nextInt();
			int a = (n % 2 == 0) ? 3 : 2;
			int b = 0;
			int c = 0;
			int d = 0;
			int k = (n % 2 == 0) ? 7 : 6;
			for (int i = n - k; i > 0; i--) {
				if (isPrime(i)) b = i;
			}
			for (int i = 2; i * i <= n - a - b; i++) {
				if (isPrime(i) && isPrime(n - i)) {
					c = i;
					d = n - i;
				}
			}
			System.out.printf("%d %d %d %d\n", a,b,c,d);
		}



	}

	static boolean isPrime(int n) {
		if (n % 2 == 0) return false;
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) return false;
		}
		return true;
	}


}
