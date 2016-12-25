import java.util.*;
import java.math.*;
class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			int n = s.nextInt();
			int a = s.nextInt();
			BigInteger sum = BigInteger.valueOf(0);
			for (int i = 1; i <= n; i++) {
				BigInteger b = (BigInteger.valueOf(i)).multiply((BigInteger.valueOf(a)).pow(i));
				//System.out.println(b);
				sum = sum.add(b);
			}
			System.out.println(sum);
		}
	}

}
