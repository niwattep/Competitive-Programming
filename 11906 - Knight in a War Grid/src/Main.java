import java.io.*;
import java.util.*;

class Main {

	static int[][] land;
	static int[][] visit;
	static int r, c, m, n;

	public static void main(String[] args) {
		FastReader in = new FastReader();
		StringBuilder sb = new StringBuilder(25000);
		int t = in.nextInt();
		int tc = 1;
		while (t-- > 0) {
			r = in.nextInt();
			c = in.nextInt();
			land = new int[r][c];
			visit = new int[r][c];
			for (int i = 0; i < r; i++) {
				Arrays.fill(land[i], -2);
				Arrays.fill(visit[i], 0);
			}
			m = in.nextInt();
			n = in.nextInt();
			int w = in.nextInt();
			for (int i = 0; i < w; i++) {
				int wx = in.nextInt();
				int wy = in.nextInt();
				land[wx][wy] = -1;
			}
			letsJump(0, 0);
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					System.out.print(land[i][j]);
				}
				System.out.println();
			}
			int even = 0;
			int odd = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (land[i][j] != -1 && land[i][j] != -2) {
						if (land[i][j] % 2 == 0 || land[i][j] == 0) even++;
						else odd++;
					}
				}
			}
			System.out.printf("Case %d: %d %d\n", tc++, even, odd);
		}
	}

	static void letsJump(int x, int y) {
		int ans = 0;
		int[] dx = {1, -1, -1, 1};
		int[] dy = {1, -1, 1, -1};
		if (x < 0 || x >= r || y < 0 || y >= c)
			return;
		if (land[x][y] == -1)
			return;
		visit[x][y] = 1;
		for (int i = 0; i < 4; i++) {
			int x1 = x + m * dx[i];
			int y1 = y + n * dy[i];
			int x2 = x + n * dx[i];
			int y2 = y + m * dy[i];
			if (x1 >= 0 && x1 < r && y1 >= 0 && y1 < c && land[x1][y1] != -1) {
				ans++;
				if (visit[x1][y1] == 0) letsJump(x1, y1);
			}
			if (x2 >= 0 && x2 < r && y2 >= 0 && y2 < c && land[x2][y2] != -1) {
				ans++;
				if (visit[x2][y2] == 0) letsJump(x2, y2);
			}
		}
		land[x][y] = ans;

	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		boolean hasNext() {
			try {
				// if (st == null || !st.hasMoreElements()) return true;
				return br.ready() || st == null;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
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
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}
