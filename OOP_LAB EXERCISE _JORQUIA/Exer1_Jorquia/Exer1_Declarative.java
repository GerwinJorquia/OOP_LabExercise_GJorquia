import java.util.Scanner;
import java.util.stream.Stream;

public class Exer1_Declarative {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = s.nextInt();

        Stream.of(number)
              .map(n -> n % 2 == 0 ? "Even" : "Odd")
              .forEach(result -> System.out.println("The number is " + result));

        s.close(); 
    }
}