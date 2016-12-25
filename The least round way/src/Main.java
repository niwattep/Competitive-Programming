import java.util.*;
import java.io.*;
public class Main {

	static int n;
	static int[][] board;
	static int[][] visit;
	static char[] path;
	public static void main(String[] args) {
		FastReader in = new FastReader();
		StringBuilder sb = new StringBuilder(25000);
		BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
		n = in.nextInt();
		board = new int[n][n];
		visit = new int[n][n];
		path = new char[n + n - 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = in.nextInt();
			}
		}
		
	}
	
	static void bfs(int r, int c) {
		if (r == n - 1 && c == n - 1) return;
		visit[r][c] = 1;
		if (board[r][c] )
		
	}
	
	
	
	static 
	
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		boolean hasNext() {
	        	try {
				//if (st == null || !st.hasMoreElements()) return true;
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
