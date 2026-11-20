import java.util.Scanner;

public class VertexForm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Kullanıcıdan a, b ve c değerlerini al
        System.out.print("Enter a, b, c: ");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        // h = -b / 2a için pay ve payda
        int hNumerator = -b;
        int hDenominator = 2 * a;

        // k = (4ac - b^2) / 4a için pay ve payda
        int kNumerator = 4 * a * c - b * b;
        int kDenominator = 4 * a;

        // Sonuçları sadeleştirilmiş rasyonel sayı olarak yazdır
        System.out.println("h is " + formatRational(hNumerator, hDenominator) +
                " k is " + formatRational(kNumerator, kDenominator));

        input.close();
    }

    // Kesri sadeleştiren ve uygun formatta String döndüren metot
    public static String formatRational(int numerator, int denominator) {
        // Pay 0 ise sonuç doğrudan 0'dır
        if (numerator == 0) {
            return "0";
        }

        // EBOB (GCD) hesapla ve pay ile paydayı sadeleştir
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;

        // Payda negatifse, eksi işaretini paya aktar (örn: 3/-2 -> -3/2)
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        // Payda 1 ise kesir çizgisine gerek yok (örn: -4/1 -> -4)
        if (denominator == 1) {
            return String.valueOf(numerator);
        }

        return numerator + "/" + denominator;
    }

    // Öklid algoritması ile EBOB (GCD) bulma
    public static int gcd(int n1, int n2) {
        while (n2 != 0) {
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }
        return n1;
    }
}