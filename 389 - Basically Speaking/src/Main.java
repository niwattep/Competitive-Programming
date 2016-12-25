import java.util.*;
import java.math.*;
class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String n = s.next();
			int sb = s.nextInt();
			int db = s.nextInt();
			System.out.println(toBase(sb, db, n));
		}
	}
	
	static String toBase(int sb, int db, String n) {
		BigInteger y = toBaseTen(sb, n);
		String result = "";
		BigInteger cur = y;
		do {
			result += cur.mod(BigInteger.valueOf(db)).toString();
			cur = cur.divide(BigInteger.valueOf(db));
			if (cur == BigInteger.valueOf(1)) {
				result += cur.toString();
			}
			else if (cur == BigInteger.valueOf(0)) {
				result += cur.toString();
			}
			System.out.println(cur);
		} while (cur != BigInteger.valueOf(1) && cur != BigInteger.valueOf(0));
		return reverse(result);
		
	}
	
	static BigInteger toBaseTen(int b, String n) {
		if (b == 10) return new BigInteger(n);
		BigInteger x = BigInteger.valueOf(0);
		for (int i = n.length() - 1, j = 0; i >= 0 && j < n.length(); i--, j++) {
			x = x.add((BigInteger.valueOf(Integer.parseInt(n.charAt(i) + ""))).multiply(BigInteger.valueOf(b).pow(j)));
		}
		return x;
	}
	 static String reverse(String n) {
		 String x = "";
		 for (int i = n.length() - 1; i >= 0; i--) {
			 x += n.charAt(i);
		 }
		 return x;
	 }

}
