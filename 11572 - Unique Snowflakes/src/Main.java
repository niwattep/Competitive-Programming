import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			TreeSet<Integer> set = new TreeSet<Integer>();
			int n = s.nextInt();
			for (int i = 0; i < n; i++) {
				set.add(s.nextInt());
			}
			System.out.println(set.size());
		}
	}
}
