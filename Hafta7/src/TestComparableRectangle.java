public class TestComparableRectangle {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4, 6);
        Rectangle r2 = new Rectangle(3, 8); // Alanı 24 (r1 ile aynı)
        Rectangle r3 = new Rectangle(5, 5); // Alanı 25

        System.out.println("r1 area: " + r1.getArea());
        System.out.println("r2 area: " + r2.getArea());
        System.out.println("r3 area: " + r3.getArea());

        System.out.println("r1.equals(r2): " + r1.equals(r2)); // true
        System.out.println("r1.equals(r3): " + r1.equals(r3)); // false
        System.out.println("r1.compareTo(r2): " + r1.compareTo(r2)); // 0
        System.out.println("r1.compareTo(r3): " + r1.compareTo(r3)); // -1
    }
}

class Rectanglea extends GeometricObject implements Comparable<Rectangle> {
    private double width;
    private double height;

    public Rectanglea() {
    }

    public Rectanglea(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectanglea(double width, double height, String color, boolean filled) {
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

    @Override
    public int compareTo(Rectangle other) {
        return Double.compare(this.getArea(), other.getArea());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rectangle)) {
            return false;
        }
        Rectangle other = (Rectangle) obj;
        return Double.compare(this.getArea(), other.getArea()) == 0;
    }
}