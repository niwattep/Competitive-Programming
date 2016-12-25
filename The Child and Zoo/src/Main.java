import java.util.*;
import java.math.*;
import java.io.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader in = new FastReader();
		int n = in.nextInt();
		int m = in.nextInt();
		
		int[] a = new int [n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = in.nextInt();
		}
		
		Vector<Edge> v = new Vector<Edge>();
		for (int i = 0; i < m; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
		}
		for (int i = 1; i < n - 1; i++) {
			for (int j = i + 1; j <n; j++) {
				Edge e = new Edge(i, j, Math.min(a[i], a[j]));
				v.add(e);
			}
		}
		double sum = 0;
		for (Edge e : v) {
			sum += e.f;
		}
		System.out.println((sum * 2) / (n * (n - 1)));
		
		
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

class Edge {
	int x;
	int y;
	int f;
	public Edge(int x, int y, int f) {
		super();
		this.x = x;
		this.y = y;
		this.f = f;
	}
	
}
