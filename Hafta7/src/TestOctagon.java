public class TestOctagon {
    public static void main(String[] args) throws CloneNotSupportedException {
        Octagon octagon1 = new Octagon(5);

        System.out.printf("Area: %.2f%n", octagon1.getArea());
        System.out.println("Perimeter: " + octagon1.getPerimeter());

        Octagon octagon2 = (Octagon) octagon1.clone();

        int result = octagon1.compareTo(octagon2);
        if (result == 0) {
            System.out.println("octagon1 is equal to octagon2.");
        } else if (result > 0) {
            System.out.println("octagon1 is greater than octagon2.");
        } else {
            System.out.println("octagon1 is less than octagon2.");
        }
    }
}

class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
    private double side;

    public Octagon() {
        this.side = 0;
    }

    public Octagon(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return (2 + 4 / Math.sqrt(2)) * side * side;
    }

    @Override
    public double getPerimeter() {
        return 8 * side;
    }

    @Override
    public int compareTo(Octagon other) {
        return Double.compare(this.getArea(), other.getArea());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}