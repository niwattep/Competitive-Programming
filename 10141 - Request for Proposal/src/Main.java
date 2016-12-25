import java.util.*;
import java.math.*;

class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int c = 1;
		boolean first = true;
		while (s.hasNext()) {
			int req = s.nextInt();
			if (req != 0) {
				if (first == false) System.out.println(); 
				first = false;
				int prop = s.nextInt();
				s.nextLine();
				for (int i = 0; i < req; i++) {
					s.nextLine();
				}
				
				String best = "";
				double lowestPrice = Double.MAX_VALUE;
				double maxCompl = Double.MIN_VALUE;
				
				
				for (int i = 0; i < prop; i++) {
					String company = s.nextLine();
					double price = s.nextDouble();
					int met = s.nextInt();
					double compl = (double)met / req;
					//System.out.printf("%s %f %d %f", company, price, met, compl);
					s.nextLine();
					for (int j = 0; j < met; j++) {
						s.nextLine();
					}
					
					if (compl > maxCompl) {
						best = company;
						lowestPrice = price;
						maxCompl = compl;
					}
					else if (compl == maxCompl) {
						if (price < lowestPrice) {
							best = company;
							lowestPrice = price;
							maxCompl = compl;
						}
					}
					//System.out.printf("%s %f %f", best, lowestPrice,maxCompl);
				}
				
				System.out.printf("RFP #%d\n%s\n", c++, best);
			}
		}
	}

}
