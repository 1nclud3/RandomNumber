public class Properties {
    private int number;
    private boolean positive;
    private boolean negative;
    private boolean zero;
    private int beforeNumber;
    private int nextNumber;
    private int[] divisors;
    private int numberOfDivisors;
    private int sumOfDivisors;
    private boolean primeNumber;
    private long factorial;
    private long fibo;
    private boolean perfect;
    private String binary;
    private double sqrt;
    private long square;
    private long cube;

    public Properties(int number) {
        this.number = number;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }

    public boolean isNegative() {
        return negative;
    }

    public void setNegative(boolean negative) {
        this.negative = negative;
    }

    public boolean isZero() {
        return zero;
    }

    public void setZero(boolean zero) {
        this.zero = zero;
    }

    public int getBeforeNumber() {
        return beforeNumber;
    }

    public void setBeforeNumber(int beforeNumber) {
        this.beforeNumber = beforeNumber;
    }

    public int getNextNumber() {
        return nextNumber;
    }

    public void setNextNumber(int nextNumber) {
        this.nextNumber = nextNumber;
    }

    public int[] getDivisors() {
        return divisors;
    }

    public void setDivisors(int[] divisors) {
        this.divisors = divisors;
    }

    public int getNumberOfDivisors() {
        return numberOfDivisors;
    }

    public void setNumberOfDivisors(int numberOfDivisors) {
        this.numberOfDivisors = numberOfDivisors;
    }

    public int getSumOfDivisors() {
        return sumOfDivisors;
    }

    public void setSumOfDivisors(int sumOfDivisors) {
        this.sumOfDivisors = sumOfDivisors;
    }

    public boolean isPrimeNumber() {
        return primeNumber;
    }

    public void setPrimeNumber(boolean primeNumber) {
        this.primeNumber = primeNumber;
    }

    public long getFactorial() {
        return factorial;
    }

    public void setFactorial(long factorial) {
        this.factorial = factorial;
    }

    public long getFibo() {
        return fibo;
    }

    public void setFibo(long fibo) {
        this.fibo = fibo;
    }

    public boolean isPerfect() {
        return perfect;
    }

    public void setPerfect(boolean perfect) {
        this.perfect = perfect;
    }

    public String getBinary() {
        return binary;
    }

    public void setBinary(String binary) {
        this.binary = binary;
    }

    public double getSqrt() {
        return sqrt;
    }

    public void setSqrt(double sqrt) {
        this.sqrt = sqrt;
    }

    public long getSquare() {
        return square;
    }

    public void setSquare(long square) {
        this.square = square;
    }

    public long getCube() {
        return cube;
    }

    public void setCube(long cube) {
        this.cube = cube;
    }

    public void setProperties() {
        if (this.number > 0) {
            this.positive = true;
            this.negative = false;
            this.zero = false;
        }
        if (this.number < 0) {
            this.positive = false;
            this.negative = true;
            this.zero = false;
        }
        if (this.number == 0) {
            this.positive = false;
            this.negative = false;
            this.zero=true;
        }
        this.beforeNumber = this.number-1;
        this.nextNumber=this.number+1;
        this.square = (long) this.number*this.number;
        this.cube = (long) this.number*this.number*this.number;
        if (this.positive) {
            this.divisors = divisorsSearch(this.number);
            this.numberOfDivisors = this.divisors.length;
            for (int divider : divisors) sumOfDivisors += divider;
            this.primeNumber= this.divisors.length == 2;
            this.factorial=factorial(this.number);
            if(this.number < 41)
                this.fibo=fibonacci(this.number);
            this.perfect= this.sumOfDivisors - this.number == this.number;
            this.sqrt=Math.sqrt(this.number);
        }
    }

    public int[] divisorsSearch(int n) {
        int j = 0;
        for(int i = 1; i <= n; i++)
            if(n%i == 0)
                j++;
        int[] dividers = new int[j];
        j = 0;
        for(int i = 1; i <= n; i++)
            if(n%i == 0){
                dividers[j] = i;
                j++;
            }
        return dividers;
    }

    public long factorial(int n){
        long f = 1;
        for(int i = 1; i <= n; i++)
            f = f*i;
        return f;
    }

    public long fibonacci(int n){
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return fibonacci(n-1) + fibonacci(n-2);
    }

    public void printProperties() {
        System.out.println("Before number?   " + this.beforeNumber);
        System.out.println("Next number?   " + this.nextNumber);
        System.out.println("Square?   " + this.square);
        System.out.println("Cube?   " + this.cube);
        if (this.positive) {
            System.out.println(this.number+" is a positive number");
            System.out.println("Divisors:");
            printArray(this.divisors);
            System.out.println();
            System.out.println("Number of divisors?   " + this.numberOfDivisors);
            System.out.println("Sum of divisors?   " + this.sumOfDivisors);
            System.out.println("Prime number?   " + this.primeNumber);
            System.out.println("Factorial?   " + this.factorial);
            System.out.println(this.number + "th number of Fibonacci sequence:   " + this.fibo);
            System.out.println("Perfect number?   " + this.perfect);
            System.out.println("Square root?   " + this.sqrt);
        }
        else
            System.out.println("Not a positive number, properties as dividers, factorial and many others are unavailable.");
    }

    void printArray(int[] arr){
        for (int j : arr) System.out.print(j + "   ");
    }
}
