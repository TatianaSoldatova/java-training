package beginner;
import  java.util.Scanner;

public class QuadraticEquation {
    static Scanner input = new Scanner(System.in);

    //----------
    // CONSTANTS
    //----------
    static final String MSG_ERR_INPUT = "Invalid input! Please enter an integer.";
    static final String MSG_COEFFICIENT_ZERO = "Coefficient a cannot be zero for a quadratic equation.";

    public static void main() {
        int a = UserInputUtils.readInt(input, "Enter a (non-zero): ", MSG_ERR_INPUT);
        while(a == 0){
            System.out.println(MSG_COEFFICIENT_ZERO);
            a = UserInputUtils.readInt(input, "Enter a (non-zero): ", MSG_ERR_INPUT);
        }
        int b = UserInputUtils.readInt(input, "Enter b: ", MSG_ERR_INPUT);
        int c = UserInputUtils.readInt(input, "Enter c: ", MSG_ERR_INPUT);

        double discriminant = calculateDiscriminant(a, b, c);

        if (discriminant < 0) {
            System.out.println("No real roots!");
        } else {
            calculateRoots(a, b, c, discriminant);
        }
        input.close();
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
