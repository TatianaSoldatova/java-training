package beginner;
import java.util.Scanner;

public class MathMethods {
    static Scanner input = new Scanner(System.in);

    public static void main() {
        thirdDegreePolynomial();
        input.close();
    }

    /**
     * Evaluates the third degree polynomials of this form:
     * ((a+b)/2) * x^3 + (a+b)^2 * x^2 + a + b + c
     */
    public static void thirdDegreePolynomial(){
        final String MSG_A      = "Enter a coefficient (int): ";
        final String MSG_B      = "Enter b coefficient (int): ";
        final String MSG_C      = "Enter c coefficient (int): ";
        final String MSG_X      = "Enter x variable (double): ";
        final String MSG_RESULT = "The value of the polynomial is: ";
        final String MSG_ERR    = "Invalid input!";

        int a;
        int b;
        int c;
        double x;

        a = UserInputUtils.readInt(input, MSG_A, MSG_ERR);
        b = UserInputUtils.readInt(input, MSG_B, MSG_ERR);
        c = UserInputUtils.readInt(input, MSG_C, MSG_ERR);
        x = UserInputUtils.readDouble(input, MSG_X, MSG_ERR);

        double abSum = a + b;
        double abSumPow2 = abSum * abSum;
        double xPow2 = x * x;
        double xPow3 = xPow2 * x;

        double polynomialValue = ((abSum / 2) * xPow3) + (abSumPow2 * xPow2) + a + b + c;
        System.out.println(MSG_RESULT + polynomialValue);
        System.out.println();
   }
}
