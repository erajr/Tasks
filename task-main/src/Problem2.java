import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        // Problem 2: Language basics

        // Create a new program that has the following features. Download source (JAVA).
        // a) Uses labeled continue instead of break.
        // b) Does not require the isPrime variable.
        // c) When testing whether an integer is prime, it is sufficient to try and divide by integers up to the square root of the number being tested.

        // Part a)
        int nValues = 50;
        boolean isPrime = true;
        for (int i = 2; i <= nValues; i++) {
            isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    continue;
                }
            }
            if (isPrime)
                System.out.println(i);
        }

        // Part b)
        int count = 0;
        for (int i = 2; i <= nValues; i++) {
            for (int j = 2; j < i; j++) {
                count = 0;
                if (i % j == 0) {
                    count++;
                    break;
                }
            }
            if(count == 0)
                System.out.println(i);
        }

        // Part c)
        System.out.print("Enter number to check prime: ");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        input.close();
        int sqroot = (int)Math.sqrt(number);
        boolean flag = false;
        for(int i = sqroot; i < number; i++) {
            if(number % i == 0) {
                flag = true;
                break;
            }
        }

        if(!flag)
            System.out.println(number + " is prime number");
        else
            System.out.println(number + " is not prime number");
    }
}
