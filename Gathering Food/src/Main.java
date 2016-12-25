import java.util.*;

class Main {
	
	static String[] table;
	static int[][] dist;
	static final int INF = -1;
	static HashMap<Character, Integer> map;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			int n = s.nextInt();
			if (n != 0) {
				table = new String[n];
				dist = new int[n][n];
				map = new HashMap<Character, Integer>();
				for (int i = 0; i < n; i++) {
					table[i] = s.nextLine();
				}
			}
			for (char i = 'A' ; i < 'K'; i++) {
				for (int j = 0; j < n; j++) {
					if (table[j].indexOf(i) != -1) map.put(i, table[j].indexOf(i));
				}
			}
		}
	}
	
	static void reset() {
		for (int[] a : dist) {
			for (int b : a) {
				b = INF;
			}
		}
	}
	
	static void bfs(char A, char B) {
		
	}
}