import java.util.*;
import java.math.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		BigInteger m = s.nextBigInteger();
		BigInteger p = (BigInteger.valueOf(2).pow(k)).subtract(BigInteger.ONE);
		
		BigInteger sum = BigInteger.ZERO;
		
		for (int i = 1; i <= n; i++) {
			sum = sum.add(solve(BigInteger.valueOf(i), p));
		}
		System.out.println(sum.mod(m));
	}
	
	static BigInteger solve(BigInteger n, BigInteger k) {
		if (k.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) == -1) return n.pow(k.intValue());
		else {
			k = (k.subtract(BigInteger.ONE)).divide(BigInteger.valueOf(2));
			return n.multiply(solve(n, k)).multiply(solve(n, k));
		}
	}

}
