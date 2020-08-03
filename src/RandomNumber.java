import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) {
        Random r = new Random();
        int n = r.nextInt(201)-100;
        System.out.println("This program draws random integer number between -100 and 100.");
        System.out.println("Yor number is: " + n);
        if(n > 0)
            System.out.println("Positive number.");
        else if(n < 0)
            System.out.println("Negative number.");
        else
            System.out.println("Zero");
        System.out.println("The number before is: " + (n - 1));
        System.out.println("The next number is: " + (n + 1));
        if(n > 0)
        {
            RandomNumber a = new RandomNumber();
            int[] dividers = a.LookingForDivisors(n);
            System.out.print("Dividers:   ");
            a.PrintArray(dividers);
            System.out.println();
            System.out.println("Number of divisors: " + dividers.length);
            int sum_of_divisors = 0;
            for (int divider : dividers) sum_of_divisors += divider;
            System.out.println("Sum of divisors: " + sum_of_divisors);
            if(dividers.length == 2)
                System.out.println("Prime number.");
            else
                System.out.println("Not a prime number.");
            System.out.println("Factorial: " + a.Factorial(n));
            if(n < 41)
                System.out.println(n + "th number of Fibonacci sequence: " + a.Fibonacci(n));
            sum_of_divisors-=n;
            if(sum_of_divisors == n)
                System.out.println("Perfect number.");
            else
                System.out.println("Not a perfect number.");
            System.out.print("Binary form: ");
            DecToBin(n);
            System.out.println();
            System.out.println("Square root of " + n + " = " + Math.sqrt(n));
        }
        else
            System.out.println("Not a positive number, properties as dividers, factorial and many others are unavailable.");
        System.out.println(n + "^2 = " + n*n);
        System.out.println(n + "^3 = " + n*n*n);
    }
    void PrintArray(int[] arr){
        for (int j : arr) System.out.print(j + "   ");
    }
    int[] LookingForDivisors(int n){
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
    long Factorial(int n){
        long f = 1;
        for(int i = 1; i <= n; i++)
            f = f*i;
        return f;
    }
    long Fibonacci(int n){
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return Fibonacci(n-1) + Fibonacci(n-2);
    }
    private static void DecToBin(int n){
        int rest;
        if (n <= 1) {
            System.out.print(n);
            return;
        }
        rest = n % 2;
        DecToBin(n >> 1);
        System.out.print(rest);
    }
}