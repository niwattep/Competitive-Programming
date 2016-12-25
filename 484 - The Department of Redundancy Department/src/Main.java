import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Integer> numList = new ArrayList<Integer>();
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		while (s.hasNext()) {
			int x = s.nextInt();
			if (!numList.contains(x)) {
				numList.add(x);
				count.put(x, 1);
				//System.out.print(x);
			} else {
				count.put(x, count.get(x) + 1);
			}
		}
		s.close();
		//System.out.print(numList.size());
		for (Integer i : numList) {
			System.out.println("" + i + " " + count.get(i));
		}
		
	}

}
