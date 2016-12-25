import java.util.*;
import java.math.*;
class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String n;
		while (!(n = in.next()).equals("0")) {
			String d = "" + n.charAt(n.length() - 1);
			String remaining = "";
			for (int i = 0; i < n.length() - 1; i++) {
				remaining += n.charAt(i);
			}
			BigInteger a1 = (new BigInteger(d)).multiply(BigInteger.valueOf(5));
			BigInteger a2 = new BigInteger(remaining);
			BigInteger a3 = a2.subtract(a1);
			//System.out.println(a2 + " - " + a1 + " = " + a3);
			if ((a3.mod(BigInteger.valueOf(17)).toString()).equals("0")) System.out.println(1);
			else System.out.println(0);
		}
	}

}
