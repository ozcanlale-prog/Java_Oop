public class TestMaxGeometricObject {
    public static void main(String[] args) {
        // İki Circle nesnesi ve büyük olanı bulma
        Circle c1 = new Circle(5);
        Circle c2 = new Circle(8);
        Circle maxCircle = (Circle) GeometricObject.max(c1, c2);
        System.out.printf("Larger circle area: %.2f%n", maxCircle.getArea());

        // İki Rectangle nesnesi ve büyük olanı bulma
        Rectangle r1 = new Rectangle(4, 6); // Alan: 24
        Rectangle r2 = new Rectangle(5, 7); // Alan: 35
        Rectangle maxRectangle = (Rectangle) GeometricObject.max(r1, r2);
        System.out.printf("Larger rectangle area: %.2f%n", maxRectangle.getArea());
    }
}

abstract class GeometricObject implements Comparable<GeometricObject> {
    private String color = "white";
    private boolean filled;

    protected GeometricObject() {
    }

    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public int compareTo(GeometricObject other) {
        return Double.compare(this.getArea(), other.getArea());
    }

    public static GeometricObject max(GeometricObject o1, GeometricObject o2) {
        if (o1 == null) return o2;
        if (o2 == null) return o1;
        return (o1.compareTo(o2) >= 0) ? o1 : o2;
    }
}

class Circle extends GeometricObject {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }
}

class Rectangle extends GeometricObject {
    private double width;
    private double height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}