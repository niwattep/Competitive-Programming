import java.util.*;
import java.io.*;
class Main {

	static StringBuilder[] land;
	
	public static void main(String[] args) {
		FastReader in = new FastReader();
		//StringBuilder sb = new StringBuilder(25000);
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (in.hasNext()) {
			int m = in.nextInt();
			int n = in.nextInt();
			land = new StringBuilder[m];
			for (int i = 0; i < m; i++) {
				land[i] = new StringBuilder(in.nextLine());
			}
			int x = in.nextInt();
			int y = in.nextInt();
			char l = land[x].charAt(y);
			in.nextLine();
			flood(x, y, m ,n, l);
			int maxRegion = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (land[i].charAt(j) == l) {
						int region = flood(i, j, m, n, l);
						if (region > maxRegion) maxRegion = region;
					}
				}
			}
			System.out.println(maxRegion);
		}
	}
	
	static int flood(int x, int y, int m, int n, char l) {
		int ans = 0;
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		if (x < 0 || x >= m) return 0;
		if (y >= n) y = 0;
		if (y < 0) y = n - 1;
		if (land[x].charAt(y) != l) return 0;
		
		ans++;
		land[x].setCharAt(y, (char)(l + 'a'));
		for (int i = 0; i < 4; i++) {
			ans += flood(x + dx[i], y + dy[i], m, n, l);
		}
		return ans;
		
	}
}

class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	boolean hasNext() {
		try {
			//if (st == null || !st.hasMoreElements()) return true;
			return  st == null || !st.hasMoreElements();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
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
