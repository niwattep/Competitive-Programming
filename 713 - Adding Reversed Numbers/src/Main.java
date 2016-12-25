import java.math.BigInteger;
import java.util.*;
class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			BigInteger b1 = new BigInteger(reverse(in.next()));
			BigInteger b2 = new BigInteger(reverse(in.next()));
			BigInteger b3 = b1.add(b2);
			System.out.println(reverse(b3.toString()));
		}
	}
	
	static String reverse(String s) {
		String newS = "";
		int fIndex = s.length() - 1;
		for (int i = fIndex; i >= 0; i--) {
			if (s.charAt(i) != '0') {
				fIndex = i;
				break;
			}
		}
		for (int i = fIndex; i >= 0; i--) newS += s.charAt(i);
		return newS;
	}

}
