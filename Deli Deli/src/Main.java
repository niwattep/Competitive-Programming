import java.util.*;
import java.lang.*;

class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int ir = s.nextInt();
		int n = s.nextInt();
		TreeMap irr = new TreeMap();
		for (int i = 0; i < ir; i++) {
			irr.put(s.next(), s.next());
		}
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.next();
		}
		for (int i = 0; i< n; i++) {
			StringBuilder a = new StringBuilder(arr[i]);
			int l = a.length();
			if (arr[i].length() == 1) {
				if (irr.containsKey(arr[i])) System.out.println(irr.get(arr[i]));
				else if (arr[i].equals("o") || arr[i].equals("s") || arr[i].equals("x")) System.out.println(arr[i] + "es");
				else System.out.println(a.append("s"));
			} else {
				if (irr.containsKey(arr[i])) System.out.println(irr.get(arr[i]));
				else if (a.charAt(l - 1) == 'y' &&
						a.charAt(l - 2) != 'a' &&
						a.charAt(l - 2) != 'e' &&
						a.charAt(l - 2) != 'i' &&
						a.charAt(l - 2) != 'o' &&
						a.charAt(l - 2) != 'u') {
					a.deleteCharAt(l - 1);
					System.out.println(a.append("ies"));
				} else if (a.substring(l - 2).equals("ch") ||
						a.substring(l - 2).equals("sh")) {
					System.out.println(arr[i] + "es");
				} else if (a.charAt(l - 1) == 'o' ||
						a.charAt(l - 1) == 's' ||
						a.charAt(l - 1) == 'x') {
					System.out.println(arr[i] + "es");
				} else System.out.println(arr[i] + "s");
			}
		}
	}

}
