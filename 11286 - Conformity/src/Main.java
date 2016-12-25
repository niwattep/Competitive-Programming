import java.util.*;
class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			int n = s.nextInt();
			if (n != 0) {
				TreeMap<Set, Integer> pop = new TreeMap<Set, Integer>();
				for (int i = 0; i < n; i++) {
					TreeSet<Integer> set = new TreeSet<Integer>();
					for (int j = 0; j < 5; j++) {
						set.add(s.nextInt());
					}
					if (!pop.containsKey(set)) pop.put(set, 1);
					else pop.put(set, pop.get(set) + 1);
				}
			}
		}
	}
}
