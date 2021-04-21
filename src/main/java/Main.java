import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Random random = new Random();
            int number = random.nextInt(201) - 100;
            System.out.println("This program draws random integer number between -100 and 100.");
            System.out.println("Yor number is: " + number);
            Properties properties = new Properties(number);
            Properties.printProperties(properties);
            System.out.println("Draw next number? (y/n)");
            Scanner input = new Scanner(System.in);
            String userDecision = input.nextLine();
            if (userDecision.equals("n"))
                break;
        }
    }
}
