import java.util.*;
class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			int n = s.nextInt();
			int b = s.nextInt();
			int h = s.nextInt();
			int w = s.nextInt();
			int minPrice = Integer.MAX_VALUE;
			for (int i = 0; i < h; i++) {
				int p = s.nextInt();
				boolean canbook = false;
				for (int j = 0; j < w; j++) {
					if (s.nextInt() >= n) canbook = true;
				}
				if (canbook == true) {
					int totalPrice = n * p;
					if (totalPrice < minPrice) minPrice = totalPrice;
				}
			}
			if (minPrice > b) System.out.println("stay home");
			else System.out.println(minPrice);
					
		}
	}

}
