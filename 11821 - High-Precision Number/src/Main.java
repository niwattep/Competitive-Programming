import java.util.*;
import java.math.*;
class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while (n-- > 0) {
			BigDecimal sum = BigDecimal.valueOf(0);
			String d = "";
			while (!(d = s.next()).equals("0")) {
				sum = sum.add(new BigDecimal(d));
			}
			System.out.println(sum.stripTrailingZeros().toPlainString());
		}
	}

}
