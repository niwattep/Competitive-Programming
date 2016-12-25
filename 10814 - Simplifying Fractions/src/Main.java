import java.util.*;
import java.math.*;
public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while (n-- > 0) {
			BigInteger p = s.nextBigInteger();
			s.next();
			BigInteger q = s.nextBigInteger();
			BigInteger gcd = p.gcd(q);
			System.out.println(p.divide(gcd) + " / " + q.divide(gcd));
		}
	}

}
