import java.util.*;
import java.math.*;
class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while (n-- > 0) {
			double x1 = s.nextDouble();
			double y1 = s.nextDouble();
			double x2 = s.nextDouble();
			double y2 = s.nextDouble();
			
			Line k = new Line(new Point(x1, y1), new Point(x2, y2));

			double xL = s.nextDouble();
			double yT = s.nextDouble();
			double xR = s.nextDouble();
			double yB = s.nextDouble();
			
			Line L = new Line(new Point(xL, yT), new Point(xL, yB));
			Line R = new Line(new Point(xR, yT), new Point(xR, yB));
			Line T = new Line(new Point(xL, yT), new Point(xR, yT));
			Line B = new Line(new Point(xL, yB), new Point(xR, yB));
			
			if (isIntersect(k, L) == true) System.out.println("T");
			else if (isIntersect(k, R) == true) System.out.println("T");
			else if (isIntersect(k, T) == true) System.out.println("T");
			else if (isIntersect(k, B) == true) System.out.println("T");
			else System.out.println("F");
			
		}
	}
	
	static boolean isIntersect(Line a, Line b) {
		int o1 = checkOrientation(a.a, a.b, b.a);
		int o2 = checkOrientation(a.a, a.b, b.b);
		int o3 = checkOrientation(b.a, b.b, a.a);
		int o4 = checkOrientation(b.a, b.b, a.b);
		
	    if (o1 != o2 && o3 != o4) return true;
	 
	    if (o1 == 0 && onSegment(a.a, a.b, b.a)) return true;
	 
	    if (o2 == 0 && onSegment(a.a, a.b, b.b)) return true;
	 
	    if (o3 == 0 && onSegment(b.a, b.b, a.a)) return true;
	 
	    if (o4 == 0 && onSegment(b.a, b.b, a.b)) return true;
	 
	    return false;
	}
	
	static int checkOrientation(Point p, Point q, Point r) {
		double val = (q.y - p.y) * (r.x - q.x) -
	              (q.x - p.x) * (r.y - q.y);
	    if (val == 0) return 0; //cl
	    return (val > 0)? 1: 2; // c or cc
	}
	
	static boolean onSegment(Point p, Point q, Point r) {
		if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
				q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y))
			return true;
		return false;
	}

}

class Line {
	Point a, b;
	public Line(Point a, Point b) {
		this.a = a;
		this.b = b;
	}
}

class Point {
	double x, y;
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
