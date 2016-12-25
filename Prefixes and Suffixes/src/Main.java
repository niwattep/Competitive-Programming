import java.util.*;
public class Main {

	static int[] ans1;
	static int[] ans2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		ans1 = new int[s.length()];
		ans2 = new int[s.length()];
		System.out.println(findPreSuff(s));
		for (int i = 0; i < s.length(); i++) {
			if (ans1[i] != 0) System.out.printf("%d %d\n", ans1[i], ans2[i]);
		}
	}
	
	static int findPreSuff(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			
			String prefix = s.substring(0, i + 1);
			String suffix = s.substring(s.length() - 1 - prefix.length() + 1);
			if (prefix.equals(suffix)) {
				ans1[i] = prefix.length();
				count++;
			}
			ans2[i] = findOccurence(prefix, s);
		}
		return count;
	}
	
	static int findOccurence(String prefix, String s) {
		int count = 0;
		boolean found = true;
		int startI = 0;
		while (found) {
			int index = s.indexOf(prefix, startI);
			if (index != -1) {
				count++;
				startI = index + 1;
			} else found = false;
		}
		return count;
	}

}
