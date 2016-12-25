import java.util.*;
import java.lang.*;
class Main {
	
	static StringBuilder[] arena;
	static char di;
	static int crow;
	static int ccol;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int stickers = 0;
			int n = in.nextInt();
			int m = in.nextInt();
			int s = in.nextInt();
			if (n != 0 && m != 0) {
				in.nextLine();
				arena = new StringBuilder[n];
				for (int i = 0; i < n; i++) {
					arena[i] = new StringBuilder(in.nextLine());
				}
				String inst = in.nextLine();
				find(n, m);
				for (int i = 0; i < inst.length(); i++) {
					if (inst.charAt(i) == 'F') {
						move(n, m);
						if (arena[crow].charAt(ccol) == '*') {
							stickers++;
							arena[crow].setCharAt(ccol, '.');
						}
					}
					else turn(inst.charAt(i));
					
					//System.out.printf("%d %d %c\n", crow, ccol, di);
				}
				System.out.println(stickers);
			}
			
		}
	}
	
	static void move(int n, int m) {
		if (di == 'N' && crow - 1 >= 0 && arena[crow - 1].charAt(ccol) != '#') crow -= 1;
		if (di == 'S' && crow + 1 < n && arena[crow + 1].charAt(ccol) != '#') crow += 1;
		if (di == 'L' && ccol + 1 < m && arena[crow].charAt(ccol + 1) != '#') ccol += 1;
		if (di == 'O' && ccol - 1 >= 0 && arena[crow].charAt(ccol - 1) != '#') ccol -= 1;
	}
	
	static void turn(char d) {
		if (d == 'D') {
			if (di == 'N') di = 'L';
			else if (di == 'L') di = 'S';
			else if (di == 'S') di = 'O';
			else if (di == 'O') di = 'N';
		}
		if (d == 'E') {
			if (di == 'N') di = 'O';
			else if (di == 'O') di = 'S';
			else if (di == 'S') di = 'L';
			else if (di == 'L') di = 'N';
		}
	}
	
	static void find(int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arena[i].charAt(j) == 'N' ||
						arena[i].charAt(j) == 'S' ||
						arena[i].charAt(j) == 'L' ||
						arena[i].charAt(j) == 'O') {
					crow = i;
					ccol = j;
					di = arena[i].charAt(j);
					break;
				}
			}
		}
	}
}
