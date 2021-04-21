import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Properties {
    private final int number;
    private final boolean positive;
    private final int beforeNumber;
    private final int nextNumber;
    private List<Integer> divisors = new ArrayList<>();
    private int numberOfDivisors;
    private int sumOfDivisors;
    private boolean primeNumber;
    private BigInteger fibonacci;
    private boolean perfect;
    //private String binary;
    private double sqrt;
    private final long square;
    private final long cube;

    public Properties(int number) {
        this.number = number;
        this.positive = this.number > 0;
        this.beforeNumber = this.number - 1;
        this.nextNumber = this.number + 1;
        this.square = (long) this.number * this.number;
        this.cube = (long) this.number * this.number * this.number;
        if (this.positive) {
            this.divisors = divisorsSearch(this.number);
            this.numberOfDivisors = this.divisors.size();
            for (int divider : divisors) sumOfDivisors += divider;
            this.primeNumber = this.divisors.size() == 2;
            this.fibonacci = fibonacci(this.number);
            this.perfect = this.sumOfDivisors - this.number == this.number;
            this.sqrt = Math.sqrt(this.number);
        }
    }

    public List<Integer> divisorsSearch(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        return list;
    }

    public BigInteger fibonacci(int n) {
        BigInteger n0 = new BigInteger("0");
        BigInteger n1 = new BigInteger("1");
        BigInteger nn = new BigInteger("0");

        if (n == 1) {
            return n1;
        }
        for (int i = 2; i <= n; ++i) {
            nn = n0.add(n1);
            n0 = n1;
            n1 = nn;
        }
        return nn;
    }

    public static void printProperties(Properties properties) {
        System.out.println("Before number?   " + properties.beforeNumber);
        System.out.println("Next number?   " + properties.nextNumber);
        System.out.println("Square?   " + properties.square);
        System.out.println("Cube?   " + properties.cube);
        if (properties.positive) {
            System.out.println(properties.number + " is a positive number");
            System.out.println("Divisors:");
            Properties.printList(properties.divisors);
            System.out.println();
            System.out.println("Number of divisors?   " + properties.numberOfDivisors);
            System.out.println("Sum of divisors?   " + properties.sumOfDivisors);
            System.out.println("Prime number?   " + properties.primeNumber);
            System.out.println("F" + properties.number + " of Fibonacci sequence:   " + properties.fibonacci);
            System.out.println("Perfect number?   " + properties.perfect);
            System.out.println("Square root?   " + properties.sqrt);
        }
        else
            System.out.println("Not a positive number, properties as dividers, square root and many others are unavailable.");
    }

    public static void printList(List<Integer> list) {
        for (Object o : list) {
            System.out.print(o + "   ");
        }
    }
}
