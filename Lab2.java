import java.util.Random;

// Point class
class Point {
    private int x;
    private int y;

    public Point() {}

    public Point(int x, int y) {
        set(x, y);
    }

    public Point(Point p) {
        this(p.x, p.y);
    }

    // To calculate and return distance between 2 points
    private double distance(Point p) {
        return Math.sqrt(Math.pow((p.getX() - getX()), 2) + Math.pow((p.getY() - getY()), 2));
    }

    // To get the value from distance method
    public double getDistance(Point p) {
        return this.distance(p);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // To print object as string
    public String toString() {
        return String.format("Given Point (%d, %d)", getX(), getY());
    }
}

// Line class
class Line {
    private Point p1;
    private Point p2;

    public Line() {}

    public Line(Point p1, Point p2) {
        set(p1, p2);
    }

    public Line(Line aline) {
        this(aline.p1, aline.p2);
    }

    // To get distance value from Point class
    public double getDistance() {
        return this.p1.getDistance(p2);    
    }

    public Point getP1() {
        return this.p1;
    }

    public Point getP2() {
        return this.p2;
    }

    public void set(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    // To print object as string
    public String toString() {
        return String.format("Line ( Point (%d, %d), Point (%d,%d), distance = %.4f)", 
        p1.getX(), p1.getY(), p2.getX(), p2.getY(), getDistance());
    }
}

// Main class
public class Lab2 {
    static Random rand = new Random();

    // To generate and return random value from 0 - 100
    private static int getInt() {
        return rand.nextInt(100);
    }    

    // To generate and return 2 random points with random value
    private static void getTwoPoints(Point p1, Point p2) {
        p1.set(getInt(), getInt());
        p2.set(getInt(), getInt());
    }

    // Driver code
    public static void main(String[] args) {
        
        // To create 5 sets of different given points and return distance
        for (int i = 1; i <= 5; i++) {
            Point p1 = new Point();
            Point p2 = new Point(p1);

            getTwoPoints(p1, p2);
            
            Line aline = new Line(p1, p2);

            System.out.printf("Set %d%n", i);
            System.out.printf("%s%n%s%n", p1,p2);
            System.out.println(aline);
            System.out.println("------------------------");
        }
    }
}
