public class main {

    static double bolme(double a, double b) {
        if (b == 0)  {
            // System.out.println("b sifir olamaz");
            // return 0;
            throw new ArithmeticException("b sifir olamaz");
        }

        return a / b;
    }

    static double bolme2(double a, double b)
            throws ArithmeticException, IllegalAccessError, NullPointerException {

        return a / b;
    }

    static void main(String[] args) {
        try {
            double sonuc  = bolme2(1, 0);
            System.out.println(sonuc);
        } catch (ArithmeticException e) {

        } catch (NullPointerException e) {

        }

    }

}


