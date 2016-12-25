import java.util.*;
import java.math.*;
class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			int n = s.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}
			int m = s.nextInt();
			s.nextLine();
			s.nextLine();
			Arrays.sort(arr);
			int low = 0;
			int hight = 0;
			for (int i = 1; i < n; i++) {
				hight = arr[i];
				int tori = Arrays.binarySearch(arr, 0, i, m - hight);
				if (tori >= 0) {
					low = arr[tori];
					break;
				}
			}
			if (low > hight) {
				int temp = hight;
				hight = low;
				low = temp;
			}
			System.out.printf("Peter should buy books whose prices are %d and %d.\n\n",low, hight);
		}
		
	}

}
