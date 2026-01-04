import java.util.Scanner;

public class Exer1_Imperative {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = s.nextInt();

        if (number % 2 == 0) {
            System.out.println("The number " + number + " is even");
        } else {
            System.out.println("The number " + number + " is odd");
        }
        s.close(); 
    }
}