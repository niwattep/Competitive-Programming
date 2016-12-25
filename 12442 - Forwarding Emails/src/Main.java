import java.util.*;
import java.io.*;
//import java.lang.*;
class Main {
	
	static int[] ne;
	static int[] visit; //0 = unvisited 1 = visited
	static int[] deep;

	public static void main(String[] args) throws IOException {
		FastReader in = new FastReader();
		StringBuilder out = new StringBuilder(100000);
		BufferedWriter print = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = in.nextInt();
		int tcase = 1;
		while (t-- > 0) {
			int n = in.nextInt();
			ne = new int[n + 1];
			visit = new int[n + 1];
			deep = new int[n + 1];
			Arrays.fill(deep, 0);
			Arrays.fill(ne, 0);
			Arrays.fill(visit, 0);
			for (int i = 0; i < n; i++) {
				int u = in.nextInt();
				int v = in.nextInt();
				ne[u] = v;
			}
			/*for (int i = 1; i <= n; i++) {
				out.append(i + "--->" + ne[i] + "\n");
			}*/
			System.out.print(out);
			out.setLength(0);
			for (int i = 1; i <= n && deep[i] == 0; i++) {
				int cur = i;
				visit[cur] = 1;
				while (visit[ne[cur]] != 1) {
					cur = ne[cur];
					visit[cur] = 1;
					deep[i]++;
				}
				Arrays.fill(visit, 0);
			}
			/*for (int i = 1; i <= n; i++) {
				out.append(i + " deep" + deep[i] + "\n");
			}*/
			int max = 0;
			int index = 0;
			for (int i = 1; i <= n; i++) {
				if (deep[i] > max) {
					max = deep[i];
					index = i;
				}
			}
			System.out.println("Case" + (tcase++) + ": " + index);
			//out.setLength(0);
		}
	}
	
	static void dfs(int i) {
		int cur = i;
		visit[cur] = 1;
		int cycleStart = 0;
		while (true) {
			if (visit[ne[cur]] != 1) {
				cur = ne[cur];
				visit[cur] = 1;
				deep[i]++;
			} else {
				cycleStart = ne[cur];
				break;
			}
		}
		while(true) {
			
		}
		Arrays.fill(visit, 0);
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


