package beginner;
import java.util.Scanner;

public class FizzBuzz {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        fizzBuzz();
    }

    /**
     * Prints numbers from start value to end value.
     * For each number, you print "Fizz" if it's divisible by 3,
     * "Buzz" if it's divisible by 5,
     * and "FizzBuzz" if it's divisible by both 3 and 5;
     * otherwise, you print the number itself
     */
    public static void fizzBuzz() {
        System.out.println("Enter the start value: ");
        int begin = input.nextInt();

        System.out.println("Enter the end value: ");
        int end = input.nextInt();

        for(int i = begin; i <= end; i++){
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0){
                System.out.println("Fizz");
            } else if (i % 5 == 0){
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
