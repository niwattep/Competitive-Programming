import java.util.*;
import java.math.*;
class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			int p = s.nextInt();
			int a = s.nextInt();
			BigInteger BP = BigInteger.valueOf(p);
			BigInteger BA = BigInteger.valueOf(a);
			if (p != 0) {
				if (!BP.isProbablePrime(10) && BA.modPow(BP, BP).equals(BA))
					System.out.println("yes");
				else System.out.println("no");
			}
		}
	}
}
