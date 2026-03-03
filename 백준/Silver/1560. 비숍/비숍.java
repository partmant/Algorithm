import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger n = sc.nextBigInteger();

        if (n.equals(BigInteger.ONE)) {
            System.out.println(1);
        } else {
            BigInteger result = n.add(n).subtract(BigInteger.valueOf(2));
            System.out.println(result);
        }
    }
}