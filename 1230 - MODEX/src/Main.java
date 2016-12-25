import java.util.*;
import java.math.*;
class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		while (N-- > 0) {
			BigInteger x = s.nextBigInteger();
			BigInteger y = s.nextBigInteger();
			BigInteger n = s.nextBigInteger();
			System.out.println(x.modPow(y,n));
					
		}
	}

}
