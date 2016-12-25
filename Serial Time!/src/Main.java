import java.io.*;
import java.util.*;
public class Main {

	static StringBuilder[][] plate;
	
	public static void main(String[] args) { 
		FastReader in = new FastReader();
		int k = in.nextInt();
		int n = in.nextInt();
		int m = in.nextInt();
		plate = new StringBuilder[k][n];
		in.nextLine();
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < n; j++) {
				plate[i][j] = new StringBuilder(in.nextLine());
			}
			in.nextLine();
		}
		int x = in.nextInt() - 1;
		int y = in.nextInt() - 1;
		
		System.out.println(flood(x, y, 0, n, m, k));
	}
	
	static int flood(int x, int y, int z, int n, int m, int k) {
		int[] dx = {-1,0,1,0,0,0};
		int[] dy = {0,1,0,-1,0,0};
		int[] dz = {0,0,0,0,1,-1};
		if (x < 0 || x >= n || y < 0 || y >= m || z < 0 || z >= k) return 0;
		if (plate[z][x].charAt(y) == '#') return 0;
		int ans = 1;
		plate[z][x].setCharAt(y, '#');
		for (int i = 0; i < 6; i++) {
			ans += flood(x + dx[i], y + dy[i], z + dz[i], n, m, k);
		}
		return ans;
	}
	
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		boolean hasNext() {
			try {
				if (st == null || !st.hasMoreElements()) return true;
				else return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException  e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}
