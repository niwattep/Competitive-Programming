import java.io.*;
import java.util.*;
import java.text.*;
class Main {

	public static void main(String[] args) throws IOException {
		FastReader in = new FastReader();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(25000);
		int t = in.nextInt();
		in.nextLine();
		boolean first = true;
		System.out.println(in.hasNext());
		while (in.hasNext()) {
			TreeMap<String, Double> trees = new TreeMap<String, Double>();
			String tree;
			int count = 0;
			while (!(tree = in.nextLine()).equals("")) {
				if (trees.containsKey(tree)) trees.put(tree, trees.get(tree) + 1);
				else trees.put(tree, (double)1);
				count++;
			}
			if (!first) sb.append("\n");
			first = false;
			for (String te : trees.keySet()) {
				double per = trees.get(te) / count * 100;
				NumberFormat f = new DecimalFormat("#0.0000");
				String output = f.format(per);
				sb.append(te + " " + output + "\n");
			}
			
			if (sb.length() >= 10000) {
				bw.write(sb.toString());
				sb = new StringBuilder(25000);
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		boolean hasNext() {
	        	try {
				//if (st == null || !st.hasMoreElements()) return true;
	        		return st == null || !st.hasMoreElements();
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
