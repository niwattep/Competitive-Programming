import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			int n = s.nextInt();
			if (n == 1) {
				s.nextInt();
				System.out.println("Jolly");
			}
			else {
				int[] k = new int[n];
				for (int i = 0; i < n; i++) {
					k[i] = s.nextInt();
				}
				for (int i = 0; i < n - 1; i++) {
					k[i] = Math.abs(k[i] - k[i + 1]);
				}
				k[n - 1] = 0;
				
				Arrays.sort(k);
				
				boolean jj = true;
				for (int i = 1; i <= n - 1; i++) {
					if (k[i] != i) {
						jj = false;
						break;
					}
				}
				if (jj == true) System.out.println("Jolly");
				else System.out.println("Not jolly");
			}
		}
		s.close();
	}

}
