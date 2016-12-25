import java.util.*;
import java.io.*;
import java.lang.*;
class Main {

	static int[] visit;
	static int[][] dominate;
	static Vector<Vector<Node>> adjList;
	public static void main(String[] args) throws IOException {
		FastReader s = new FastReader();
		BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		int t = s.nextInt();
		int c = 1;
		while (t-- > 0) {
			adjList = new Vector<Vector<Node>>();
			int n = s.nextInt();
			visit = new int[n];
			dominate = new int[n][n];
			for (int i = 0; i < n; i++) {
				visit[i] = 0;
			}
			for (int i = 0; i < n; i++) {
				Vector<Node> neighbor = new Vector<Node>();
				for (int j = 0; j < n; j++) {
					if (s.nextInt() == 1) {
						neighbor.add(new Node(j, 1));
					}
				}
				adjList.add(neighbor);
			}
			reset();
			
			dfs(0);
			int[] temp = Arrays.copyOf(visit, visit.length);
			
			for (int i = 0; i < n; i ++) {
				if (temp[i] == 0) {
					for (int j = 0; j < n; j++) dominate[i][j] = 1;
				} else {
					reset();
					dfs(0, i);
					for (int j = 0; j < n; j++) {
						if (i == j) visit[j] = 0;
						if (temp[j] == 0) dominate[i][j] = 1;
						else if (visit[j] == 0) dominate[i][j] = 0;
						else dominate[i][j] = 1;
					}
				}
				
			}
			
			/*System.out.printf("Case %d:\n", c++);
			System.out.print("+");
			for (int i = 0; i < 2 * n - 1; i++) System.out.print("-");
			System.out.print("+\n");
			
			for (int i = 0; i < n; i++) {
				System.out.print("|");
				for (int j = 0; j < n; j++) {
					if (dominate[i][j] == 0) {
						System.out.print("Y|");
					} else System.out.print("N|");
				}
				System.out.print("\n");
				System.out.print("+");
				for (int k = 0; k < 2 * n - 1; k++) System.out.print("-");
				System.out.print("+\n");
			}*/
			
			sb.append("Case " + (c++) + ":\n");
			sb.append("+");
			for (int i = 0; i < 2 * n - 1; i++) sb.append("-");
			sb.append("+\n");
			
			for (int i = 0; i < n; i++) {
				sb.append("|");
				for (int j = 0; j < n; j++) {
					if (dominate[i][j] == 0) {
						sb.append("Y|");
					} else sb.append("N|");
				}
				sb.append("\n");
				sb.append("+");
				for (int k = 0; k < 2 * n - 1; k++) sb.append("-");
				sb.append("+\n");
			}
			
			System.out.print(sb);
			sb.setLength(0);
			
			/*for (int i = 0; i < n; i++) {
				System.out.printf("Neighbor of %d: ", i);
				for (Node v : adjList.get(i)) {
					System.out.print(v.d + " ");
				}
				System.out.println();
			}*/
			
		}
	}
	
	static void dfs(int v, int x) {
		visit[v] = 1;
		if (v == x) return;
		for (int i = 0; i < adjList.get(v).size(); i++) {
			Node w = adjList.get(v).get(i);
			if (visit[w.d] == 0) dfs(w.d, x);
		}
	}
	
	static void dfs(int v) {
		visit[v] = 1;
		for (int i = 0; i < adjList.get(v).size(); i++) {
			Node w = adjList.get(v).get(i);
			if (visit[w.d] == 0) dfs(w.d);
		}


	}
	
	static void bfs(int v) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		visit[v] = 1;
		q.add(v);
		while (!q.isEmpty()) {
			int u = q.pop();
			for (int i = 0; i < adjList.get(u).size(); i++) {
				Node w = adjList.get(u).get(i);
				if (visit[w.d] == 0) {
					visit[w.d] = 1;
					q.add(w.d);
				}
			}
		}
		
	}
	
	static void bfs(int v, int x) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		visit[v] = 1;
		q.add(v);
		while (!q.isEmpty()) {
			int u = q.poll();
			if (u != x) {
				for (int i = 0; i < adjList.get(u).size(); i++) {
					Node w = adjList.get(u).get(i);
					if (visit[w.d] == 0) {
						visit[w.d] = 1;
						q.add(w.d);
					}
				}
			}
			
		}
		
	}
	
	static void reset() {
		for (int i = 0; i < visit.length; i++) {
			visit[i] = 0;
		}
	}
	
	static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

}

class Node {
	int d;
	int w;
	public Node(int d, int w) {
		super();
		this.d = d;
		this.w = w;
	}
}
