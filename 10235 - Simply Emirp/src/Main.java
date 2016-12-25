import java.util.*;
import java.math.*;
import java.lang.StringBuilder;
class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			BigInteger n = s.nextBigInteger();
			BigInteger rn = new BigInteger(new StringBuilder(n.toString()).reverse().toString());
			if (!n.isProbablePrime(10)) System.out.println(n + " is not prime.");
			else if (!n.equals(rn) && rn.isProbablePrime(10)) System.out.println(n + " is emirp.");
			else System.out.println(n + " is prime.");
		}
	}

}
