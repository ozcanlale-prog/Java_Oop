public class TestSumArea {
    public static void main(String[] args) {
        // 2 Circle ve 2 Rectangle'dan oluşan 4 elemanlı dizi
        GeometricObject[] objects = {
                new Circle(5),
                new Circle(3),
                new Rectanglea(4, 6),
                new Rectanglea(2.5, 8)
        };

        double totalArea = sumArea(objects);
        System.out.printf("Total area: %.2f%n", totalArea);
    }

    // Dizideki tüm geometrik nesnelerin alanlarını toplayan metot
    public static double sumArea(GeometricObject[] a) {
        double sum = 0;
        for (GeometricObject obj : a) {
            if (obj != null) {
                sum += obj.getArea();
            }
        }
        return sum;
    }
}

// Temel geometrik nesne sınıfı
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

// Çember sınıfı
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

// Dikdörtgen sınıfı
class Rectanglea extends GeometricObject {
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
}