public class TestComparableCircle {
    public static void main(String[] args) {
        // 1. İki ComparableCircle nesnesinden büyük olanı bulma
        ComparableCircle circle1 = new ComparableCircle(5);
        ComparableCircle circle2 = new ComparableCircle(8);

        ComparableCircle largerCircle = (circle1.compareTo(circle2) >= 0) ? circle1 : circle2;
        System.out.printf("Larger of two circles area: %.2f%n", largerCircle.getArea());

        // 2. Bir çember (ComparableCircle) ile bir dikdörtgen (Rectangle) arasından büyük olanı bulma
        ComparableCircle circle = new ComparableCircle(4); // Alan: ~50.27
        Rectangle rectangle = new Rectangle(6, 10);      // Alan: 60.0

        if (Double.compare(circle.getArea(), rectangle.getArea()) >= 0) {
            System.out.printf("The circle is larger (Area: %.2f)%n", circle.getArea());
        } else {
            System.out.printf("The rectangle is larger (Area: %.2f)%n", rectangle.getArea());
        }
    }
}

class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compareTo(ComparableCircle other) {
        return Double.compare(this.getArea(), other.getArea());
    }
}

abstract class GeometricObject {
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

    public double getDiameter() {
        return 2 * radius;
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