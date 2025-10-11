package beginner;
import  java.util.Scanner;

public class QuadraticEquation {
    static Scanner input = new Scanner(System.in);

    public static void main() {
        int a = readInt(input, "Enter a (non-zero): ");
        while(a == 0){
            System.out.println("Coefficient a cannot be zero for a quadratic equation. ");
            a = readInt(input, "Enter a (non-zero): ");
        }
        int b = readInt(input, "Enter b: ");
        int c = readInt(input, "Enter c: ");

        double discriminant = calculateDiscriminant(a, b, c);

        if (discriminant < 0) {
            System.out.println("No real roots!");
        } else {
            calculateRoots(a, b, c, discriminant);
        }
        input.close();
    }

    /**
     * Validates integer input
     */
    public static int readInt(Scanner input, String message) {
        while (true) {
            System.out.print(message);
            if(input.hasNextInt()) {
                return input.nextInt();
            }else{
                System.out.println("Invalid input! Please enter an integer.");
                input.next(); // discard invalid input
            }
        }
    }

    /**
     * The part of the quadratic formula under the square root, b^2-4ac
     * is called the discriminant.
     * If the discriminant is positive, there are two distinct real solutions.
     * If the discriminant is zero, there is exactly one real solution.
     * If the discriminant is negative, there are two complex solutions.
     */
    public static double calculateDiscriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    /**
     * Calculates and prints the real roots of a quadratic equation of the form
     * ax^2 + bx + c = 0, using the given discriminant value.
     * x₁ = (-b + sqrt(discriminant)) / 2a
     * x₂ = (-b - sqrt(discriminant)) / 2a
     */
    public static void calculateRoots(double a, double b, double c, double discriminant) {
        double x1 = (-b + Math.pow(discriminant, 0.5)) / (2 * a);
        double x2 = (-b - Math.pow(discriminant, 0.5)) / (2 * a);
        if (x1 == x2) {
            System.out.println("x = " + x1);
        } else {
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
    }
}
