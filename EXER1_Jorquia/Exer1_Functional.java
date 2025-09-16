import java.util.function.IntPredicate;
import java.util.Scanner;

public class Exer1_Functional {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            while (!s.hasNextInt()) {
                System.out.print("Invalid input. Please enter an integer: ");
                s.next();
            }

            int number = s.nextInt();

            IntPredicate isEven = n -> n % 2 == 0;
            String result = isEven.test(number) ? "Even" : "Odd";

            System.out.printf("The number %d is %s.%n", number, result);
        }
    }
}
