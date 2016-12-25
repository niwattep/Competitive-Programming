import java.util.*;
import java.math.*;
class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			int base = s.nextInt();
			if (base != 0) {
				String p = s.next();
				String m = s.next();
				String pTen = (new BigInteger(p, base)).toString(10); 
				String mTen = (new BigInteger(m, base)).toString(10);
				BigInteger result = (new BigInteger(pTen)).mod(new BigInteger(mTen));
				System.out.println(result.toString(base));
			}
		}
	}

}
