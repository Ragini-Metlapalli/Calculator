package calculator;

import java.util.Scanner;

public class Calculator {


    // Square root
    public double sqrt(double x) {
        if (x < 0) throw new IllegalArgumentException("Cannot take sqrt of negative number");
        return Math.sqrt(x);
    }

    // Factorial
    public long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Factorial not defined for negative numbers");
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    // Natural logarithm
    public double ln(double x) {
        if (x <= 0) throw new IllegalArgumentException("ln(x) not defined for x <= 0");
        return Math.log(x);
    }

    // Power function
    public double power(double x, double y) {
        return Math.pow(x, y);
    }

    // CLI Menu
    public void run() {
        System.out.print("########################## Calculator ################################ ");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n---------------Menu--------------");
            System.out.println("1. Square Root ");
            System.out.println("2. Factorial ");
            System.out.println("3. Natural Log ");
            System.out.println("4. Power ");
            System.out.println("5. Exit");
            System.out.println("---------------------------------\n");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number 1-5.");
                sc.nextLine(); // clear invalid input
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter number: ");
                        System.out.flush();
                        double num = sc.nextDouble();
                        System.out.println("sqrt(" + num + ") = " + sqrt(num));
                        break;
                    case 2:
                        System.out.print("Enter integer: ");
                        System.out.flush();
                        int n = sc.nextInt();
                        System.out.println(n + "! = " + factorial(n));
                        break;
                    case 3:
                        System.out.print("Enter number: ");
                        System.out.flush();
                        double x = sc.nextDouble();
                        System.out.println("ln(" + x + ") = " + ln(x));
                        break;
                    case 4:
                        System.out.print("Enter base: ");
                        System.out.flush();
                        double base = sc.nextDouble();
                        System.out.print("Enter exponent: ");
                        System.out.flush();
                        double exp = sc.nextDouble();
                        System.out.println(base + "^" + exp + " = " + power(base, exp));
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Enter a valid option between 1 to 5.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // Main
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.run();
    }
}
