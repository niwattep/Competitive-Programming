import java.util.*;
import java.math.*;
class Main {
	
	static final double EPS = 1e-8;
	static final double INFI = Double.NEGATIVE_INFINITY;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println("INTERSECTING LINES OUTPUT");
		while (n-- > 0) {
			Point p1 = new Point(s.nextInt(), s.nextInt());
			Point p2 = new Point(s.nextInt(), s.nextInt());
			Point p3 = new Point(s.nextInt(), s.nextInt());
			Point p4 = new Point(s.nextInt(), s.nextInt());
			Point p = solve(p1, p2, p3, p4);
			if (p.x != INFI && p.y != INFI) {
				System.out.printf("POINT %.2f %.2f\n", p.x, p.y);
			}
			
		}
		System.out.println("END OF OUTPUT");
		s.close();
	}
	
	static Point solve(Point p1, Point p2, Point p3, Point p4) {
		Line l1 = pointToLine(p1, p2);
		Line l2 = pointToLine(p3, p4);
		
		Point p = new Point(INFI, INFI);
		
		if (Math.abs(l1.a - l2.a) < EPS 
				&& Math.abs(l1.b - l2.b) < EPS
				&& Math.abs(l1.c - l2.c) < EPS)
			System.out.println("LINE");
		else if (Math.abs(l1.a - l2.a) < EPS 
				&& Math.abs(l1.b - l2.b) < EPS)
			System.out.println("NONE");
		else {
			p.x = (l2.b * l1.c - l1.b * l2.c) /
					(l2.a * l2.b- l1.a * l2.b);
			if (Math.abs(l1.b) > EPS) p.y = -(l1.a * p.x + l1.c);
			else p.y = -(l2.a * p.x + l2.c);
		}
		return p;
		
	}
	
	static Line pointToLine(Point p1, Point p2) {
		if (Math.abs(p1.x - p2.x) < EPS) {
			return new Line(1.0, 0.0, -p1.x);
		} else {
			double a = -(double)(p1.y - p2.y) / (p1.x - p2.x);
			double b = 1.0;
			double c = -(double)(a * p1.x) - p1.y;
			return new Line(a, b, c);
		}
	}

}

class Line {
	double a, b, c;
	public Line(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}

class Point {
	double x, y;
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
