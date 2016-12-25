import java.util.*;
import java.math.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		BigInteger sum = BigInteger.ZERO;
		int n = s.nextInt();
		for (int i = 1; i <= n; i++) {
			//System.out.println(solve(i));
			sum = sum.add(BigInteger.valueOf(solve(i)));
		}
		System.out.println(sum);
	}
	
	static int solve(int n) {
		if (n == 1) return 3;
		int count = 0;
		int i;
		for (i = 1; ; i++) {
			if (n < i) count++;
			else if (n % i != 0) count++;
			if (count == 2) break;
		}
		return i;			
	}

}
