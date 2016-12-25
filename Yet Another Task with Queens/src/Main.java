import java.util.*;
import java.math.*;
public class Main {

	
	//static char[][] board;
	static int[] w = new int[9];
	static int[] qx;
	static int[] qy;
	static boolean[] flag = new boolean[8];
	static int m;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		m = s.nextInt();
		//board = new char[n + 1][n + 1];
		/*for (int i = 1; i <= n; i++){
			Arrays.fill(board[i], '.');
		}/*
		Arrays.fill(w, 0);
		/*for (int i = 0; i < m; i++) {
			board[s.nextInt()][s.nextInt()] = 'Q';
		}*/
		
		qx = new int[m];
		qy = new int[m];
		int[] dia1 = new int[2 * m - 1];
		int[] dia2 = new int[2 * m - 1];
		
		for (int i = 0; i < m; i++) {
			qx[i] = s.nextInt();
			qy[i] = s.nextInt();
			int d1 = qx[i] + qy[i] - 1;
			int d2 = qx[i] - qy[i] + 1;
			dia1[d1] = d2;
			dia2[d2] = d1;
		}
		int[] row = Arrays.copyOf(qx, m);
		int[] col = Arrays.copyOf(qy, m);
		Arrays.sort(row);
		Arrays.sort(col);
		
		for (int i = 0; i < m; i++) {
			int ans = 0;
			int x = Arrays.binarySearch(row, qx[i]);
			if (x == 0) {
				if (x == 0 || x == m - 1) ans++;
				else ans += 2;
			}
			int y = Arrays.binarySearch(col, qy[i]);
			if (y == 0) {
				if (y == 0 || y == m - 1) ans++;
				else ans += 2;
			}
			
			w[ans]++;
		}
		
		/*for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}*/
		/*for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (board[i][j] == 'Q') {
					int index = countTreat(i, j, n);
					w[index] += 1;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			System.out.print(w[i] + " ");
		}*/
	}
	
	/*static int countTreat(int x, int y, int n) {
		int ans = 0;
		int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};
		int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
		if (x < 1 || x > n || y < 1 || y > n) return 0;
		for (int i = 0; i < 8; i++) {
			ans += search(x + dx[i], y + dy[i], dx[i], dy[i], n);
		}
		return ans;
	}*/
	
	
	
	/*static int search(int x, int y, int dx, int dy, int n) {
		if (x < 1|| x > n || y < 1 || y > n) return 0;
		if (board[x][y] == 'Q') return 1;
		else return search(x + dx, y + dy, dx, dy, n);
	}*/

}
