import java.util.*;

enum ShapeColor {
    Blue, Yellow, Red, Green, White
}

interface OnlyTwoD {
    double perimeter();
    void recolor(ShapeColor sc);
}

interface OnlyThreeD {
    double volume();
    void resize(double percentage);
}

interface Shape {
    double area();
}

abstract class TwoD implements OnlyTwoD, Shape {
    protected ShapeColor sc;
    protected int a;
    protected int b;
    protected int c;
    protected int d;

    public TwoD() {}

    public TwoD(ShapeColor sc, int a) {
        set(sc, a);
    }

    public TwoD(ShapeColor sc, int a, int b) {
        set(sc, a, b);
    }

    public TwoD(ShapeColor sc, int a, int b, int c) {
        set(sc, a, b, c);
    }

    public TwoD(ShapeColor sc, int a, int b, int c, int d) {
        set(sc, a, b, c, d);
    }

    public TwoD(TwoD tD) {
        this(tD.sc, tD.a, tD.b, tD.c, tD.d);
    }

    public int getA() {
        return this.a;
    }

    public int getB() {
        return this.b;
    }

    public int getC() {
        return this.c;
    }

    public int getD() {
        return this.d;
    }

    ShapeColor getShapeColor() {
        return this.sc;
    }

    public void set(ShapeColor sc, int a) {
        this.sc = sc;
        this.a = a;
    }

    public void set(ShapeColor sc, int a, int b) {
        this.sc = sc;
        this.a = a;
        this.b = b;
    }

    public void set(ShapeColor sc, int a, int b, int c) {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void set(ShapeColor sc, int a, int b, int c, int d) {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public void recolor(ShapeColor sc) {
        Random rand = new Random();
        ShapeColor sc1 = ShapeColor.values()[rand.nextInt(5)];

        while (getShapeColor() == sc1) {
            sc1 = ShapeColor.values()[rand.nextInt(5)];
        }

        this.sc = sc1;
    }

    @Override
    public String toString() {
        if ((getB() | getC() | getD()) == 0) {
            return String.format("%s (2D (%s, %d))%n", getClass().getSimpleName(), getShapeColor(), getA());
        } else if ((getC() | getD()) == 0) {
            return String.format("%s (2D (%s, %d, %d))%n", getClass().getSimpleName(), getShapeColor(), getA(), getB());
        } else if (getD() == 0) {
            return String.format("%s (2D (%s, %d, %d, %d))%n", getClass().getSimpleName(), getShapeColor(), getA(), getB(), getC());
        } else {
            return String.format("%s (2D (%s, %d, %d, %d, %d))%n", getClass().getSimpleName(), getShapeColor(), getA(), getB(), getC(), getD());
        }
    }
}

class Circle extends TwoD {
    public Circle() {}

    public Circle(ShapeColor sc, int radius) {
        super(sc, radius);
    }

    public Circle(Circle c) {
        this(c.sc, c.a);
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(getRadius(), 2);
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * getRadius();
    }

    public int getRadius() {
        return super.getA();
    }

    @Override
    public void set(ShapeColor sc, int radius) {
        this.sc = sc;
        this.a = radius;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Rectangle extends TwoD {

    public Rectangle() {}

    public Rectangle(ShapeColor sc, int length, int width) {
        super(sc, length, width);
    }

    public Rectangle(Rectangle r) {
        this(r.sc, r.a, r.b);
    }

    @Override
    public double area() {
        return (double)getLength() * getWidth();
    }

    @Override
    public double perimeter() {
        return (double)(2 * getLength()) + (2 * getWidth());
    }

    public int getLength() {
        return super.getA();
    }

    public int getWidth() {
        return super.getB();
    }

    @Override
    public void set(ShapeColor sc, int length, int width) {
        this.sc = sc;
        this.a = length;
        this.b = width;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Triangle extends TwoD {
    public Triangle() {}

    public Triangle(ShapeColor sc, int a, int b, int c) {
        super(sc, a, b, c);
    }

    public Triangle(Triangle t) {
        this(t.sc, t.a, t.b, t.c);
    }

    @Override
    public double area() {
        return (double)(getA() + getB() + getC()) / 2;
    }

    @Override
    public double perimeter() {
        return (double)getA() + getB() + getC();
    }

    @Override
    public int getA() {
        return super.getA();
    }

    @Override
    public int getB() {
        return super.getB();
    }

    @Override
    public int getC() {
        return super.getC();
    }

    @Override
    public void set(ShapeColor sc, int a, int b, int c) {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Trapezoid extends TwoD {
    private int h;

    public Trapezoid() {}

    public Trapezoid(ShapeColor sc, int a, int b, int c, int d, int h) {
        super(sc, a, b, c, d);
        this.h = h;
    }

    public Trapezoid(Trapezoid t) {
        this(t.sc, t.a, t.b, t.c, t.d, t.h);
    }

    @Override
    public double area() {
        return ((double)(getA() + getB()) / 2 ) * getHeight();
    }

    @Override
    public double perimeter() {
        return (double)getA() + getB() + getC() + getD();
    }

    @Override
    public int getA() {
        return super.getA();
    }

    @Override
    public int getB() {
        return super.getB();
    }

    @Override
    public int getC() {
        return super.getC();
    }

    @Override
    public int getD() {
        return super.getD();
    }

    public int getHeight() {
        return this.h;
    }

    @Override
    public void set(ShapeColor sc, int a, int b, int c, int d) {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

abstract class ThreeD implements OnlyThreeD, Shape{
    protected ShapeColor sc;
    protected double a;

    public ThreeD() {}

    public ThreeD(ShapeColor sc, double a) {
        this.sc = sc;
        this.a = a;
    }

    public ThreeD(ThreeD td) {
        this(td.sc, td.a);
    }

    public double getA() {
        return this.a;
    }

    public void set(ShapeColor sc, double a) {
        this.sc = sc;
        this.a = a;
    }

    public void resize(double percentage) {
        this.a = (1 - (percentage / 100)) * a;
    }

    @Override
    public String toString() {
        return String.format("%s (3D (%s, %.3f))%n", getClass().getName(), sc, a);
    }
}

class Cube extends ThreeD { 
    public Cube() {}

    public Cube(ShapeColor sc, double a) {
        super(sc, a);
    }

    public Cube(Cube c) {
        this(c.sc, c.a);
    }

    @Override
    public double area() {
        return 6 * Math.pow(this.a, 2);
    }

    @Override
    public double volume() {
        return Math.pow(this.a, 3);
    }

    @Override
    public double getA() {
        return this.a;
    }

    @Override
    public void set(ShapeColor sc, double a) {
        this.sc = sc;
        this.a = a;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}

class Tetrahedron extends ThreeD {
    public Tetrahedron() {}

    public Tetrahedron(ShapeColor sc, double a) {
        super(sc, a);
    }

    public Tetrahedron(Tetrahedron t) {
        this(t.sc, t.a);
    }

    @Override
    public double area() {
        return Math.sqrt(3) * Math.pow(this.a, 3);
    }

    @Override
    public double volume() {
        return (Math.pow(this.a, 3)) / (6 * Math.sqrt(2));
    }

    @Override
    public double getA() {
        return this.a;
    }

    @Override
    public void set(ShapeColor sc, double a) {
        this.sc = sc;
        this.a = a;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Sphere extends ThreeD {
    public Sphere() {}

    public Sphere(ShapeColor sc, double a) {
        super(sc, a);
    }

    public Sphere(Sphere s) {
        this(s.sc, s.a);
    }

    @Override
    public double area() {
        return 4 * (Math.PI * Math.pow(this.a, 2));
    }

    @Override
    public double volume() {
        return Math.pow(this.a, 3);
    }

    @Override
    public double getA() {
        return this.a;
    }

    @Override
    public void set(ShapeColor sc, double a) {
        this.sc = sc;
        this.a = a;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

public class MinZhanFoo_A2 {
    private static int getInt() {
        Random rand = new Random();
        return rand.nextInt(100);
    }

    private static double getDouble() {
        Random randDouble = new Random();
        return randDouble.nextDouble() * 10;
    }

    private static ShapeColor getColor() {
        Random rand = new Random();
        return ShapeColor.values()[rand.nextInt(5)];
    }

    private static Boolean isTriangle(int a, int b, int c) {
        return ((a + b > c) && (b + c > a) && (a + c > b));
    }

    private static TwoD getTwoD() {
        Random randTwoD = new Random();

        int i = randTwoD.nextInt(4);
        int a = getInt();
        int b = getInt();
        int c = getInt();

        while (!(isTriangle(a, b, c))) {
            a = getInt();
            b = getInt();
            c = getInt();
        }

        TwoD tri = new Triangle(getColor(), a, b, c);
        TwoD circle = new Circle(getColor(), getInt());
        TwoD rect = new Rectangle(getColor(), getInt(), getInt());
        TwoD trap = new Trapezoid(getColor(), getInt(), getInt(), getInt(), getInt(), getInt());

        switch (i) {
            case 0:
                return circle;
            case 1:
                return rect;
            case 2:
                return tri;
            case 3:
            default:
                return trap;
        }
    }

    private static ThreeD getThreeD() {
        Random randThreeD = new Random();

        int i = randThreeD.nextInt(3);

        ThreeD sphere = new Sphere(getColor(), getDouble());
        ThreeD cube = new Cube(getColor(), getDouble());
        ThreeD tetra = new Tetrahedron(getColor(), getDouble());

        switch (i) {
            case 0:
                return sphere;
            case 1:
                return cube;
            case 2:
            default:
                return tetra;
        }
    }

    private static void process2DShape(Shape ss) {
        TwoD d = (TwoD)ss;

        System.out.printf(d.toString());
        d.recolor(d.sc);

        System.out.printf("Updated color: %s%nArea = %.3f%nI am a %s Shape with color changed to %s%n",
        d.getShapeColor(), ss.area(), ss.getClass().getSimpleName().toLowerCase(), d.getShapeColor());
        System.out.println("-------------------------------------------------");
    }

    private static void process3DShape(Shape ss) {
        Random rand3D = new Random();
        double percentage = rand3D.nextDouble() * 100;
        ThreeD d3 = (ThreeD)ss;

        System.out.printf(d3.toString());
        System.out.printf("Surface area = %.3f%nVolumn = %.3f%n", d3.area(), d3.volume());

        d3.resize(percentage);

        System.out.printf("Size reduced by %.1f%%: %s (3D (%s, %.3f))%nUpdated surface area = %.3f%nUpdate volume: %.3f%n",
                percentage, ss.getClass().getSimpleName(), d3.sc, d3.a, ss.area(), d3.volume());
        System.out.printf("I am a %s shape%n", ss.getClass().getSimpleName().toLowerCase());
        System.out.println("-------------------------------------------------");
    }

    private static void displayList(ArrayList<Shape> alist) {
        if (alist.isEmpty()) {
            System.out.println("Arraylist is empty. Please roll again.\n");
        } else {
            int i = 1;

            for (Shape value : alist) {
                System.out.printf("Shape %d: ", i);
                if (value instanceof TwoD) {
                   process2DShape(value);
                } else {
                    process3DShape(value);
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Shape> alist = new ArrayList<>();
        Random rand = new Random();
        int k = rand.nextInt(4);

        while (k != 0) {
            if (k == 1) {
                alist.add(getTwoD());
            } else if (k == 2) {
                alist.add(getThreeD());
            }
            k = rand.nextInt(4);
        }
        displayList(alist);
    }
}