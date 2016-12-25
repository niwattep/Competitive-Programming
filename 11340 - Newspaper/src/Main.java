import java.util.*;
import java.io.*;

//This problem uses Direct Addressing Table
//Unsolved
class Main {
	public static void main (String[] args) throws UnsupportedEncodingException
	{
		FastReader s = new FastReader();
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int[] cost = new int[256];
			for (int i = 0; i < n; i++) {
				String ch = s.next();
				int c = s.nextInt();
				cost[(int)ch.charAt(0)] = c;
			}
			
			int m = s.nextInt();
			String[] article = new String[m];
			for (int i = 0; i < m; i++) {
				article[i] = s.nextLine();
			}
			int arCost = assignCost(article, cost, m);
			//double total = arCost / 100f;
			//System.out.printf("%.2f$\n", total);
			System.out.print(arCost/100 + ".");
			System.out.printf("%02d$\n",arCost%100);
		}
		
	}
 
	static int assignCost(String[] ar, int[] cost, int m) {
		int arCost = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < ar[i].length(); j++) {
				arCost += cost[(int)ar[i].charAt(j)];
			}
			
		}
		return arCost;
	}
	
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() throws UnsupportedEncodingException {
			br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
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
