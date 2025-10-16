package beginner;
import java.util.Scanner;

public class MathMethods {
    static Scanner input = new Scanner(System.in);

    public static void main() {
        thirdDegreePolynomial();
        formulas();
        input.close();
    }

    /**
     * Evaluates the third degree polynomials of the form:
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

    /**
     * Determines if X is defined for each of the formulas and calculates the result
     * Logarithm is defined for positive real numbers > 0
     * Square root is defined for real numbers >= 0
     * 1/x is defined for real numbers != 0
     */
   public static void formulas(){
       final String MSG_REAL_NUMBER = "Enter a real number: ";
       final String MSG_UNDEFINED   = "undefined";
       final String MSG_FORMULA     = "Formula %d: %s %n";
       final String MSG_ERR         = "Invalid input!";

       double x = UserInputUtils.readDouble(input, MSG_REAL_NUMBER, MSG_ERR);

       // formula 1: x / (1 - exp(x))
       double result = 1 - Math.exp(x);
       if(result == 0){
           System.out.printf(MSG_FORMULA, 1, MSG_UNDEFINED);
       }else{
           result = x / result;
           System.out.printf(MSG_FORMULA, 1, result);
       }

       // formula 2: x * log(x) * exp(2/(x-1))
       if((x - 1) == 0 || x <= 0){
           System.out.printf(MSG_FORMULA, 2, MSG_UNDEFINED);
       }else{
           result = x * Math.log(x) * Math.exp(2/(x - 1));
           System.out.printf(MSG_FORMULA, 2, result);
       }

       // formula 3: (-x - sqrt(x^2 - 8 * x)) / (2 - x)
       double underRoot = x * x - 8 * x;
       if(underRoot < 0 || (2 - x) == 0){
           System.out.printf(MSG_FORMULA, 3, MSG_UNDEFINED);
       }else{
           result = (-x - Math.sqrt(underRoot)) / (2 - x);
           System.out.printf(MSG_FORMULA, 3, result);
       }

       // formula 4: sqrt((sin(x) - x/20) * log(sqrt(x^2 - (1/x)))
       double underRoot1 = x * x - (1/x);
       double underRoot2 = Math.sin(x) - (x/20);
       double rootResult = Math.sqrt(underRoot1);
       if(x == 0 || underRoot1 < 0 || underRoot2 < 0 || Math.log(rootResult) <= 0){
           System.out.printf(MSG_FORMULA, 4, MSG_UNDEFINED);
       }else{
           result = Math.sqrt((Math.sin(x) - x/20) * Math.log(rootResult));
           System.out.printf(MSG_FORMULA, 4, result);
       }
       System.out.println();
   }
}
