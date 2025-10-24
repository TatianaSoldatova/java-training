package beginner;
import utils.UserInputUtils;

import java.util.Scanner;

public class FizzBuzz {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        fizzBuzzCount();
        fizzBuzzNumCheck();

        input.close();
    }

    /**
     * Prints numbers from start value to end value.
     * For each number, you print "Fizz" if it's divisible by 3,
     * "Buzz" if it's divisible by 5,
     * and "FizzBuzz" if it's divisible by both 3 and 5;
     * otherwise, you print the number itself
     */
    public static void fizzBuzzCount() {
        final String MSG_ERR_INPUT = "Invalid input! Please enter an integer.";

        int begin = UserInputUtils.readInt(input, "Enter the start value: ", MSG_ERR_INPUT);
        int end = UserInputUtils.readInt(input,  "Enter the end value: ", MSG_ERR_INPUT);

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

    /**
     * Checks the number divisibility
     * If the number is divisible by 3, prints 'Fizz'
     * If it's divisible by 5, prints 'Buzz'
     * If it's divisible by both 3 and 5, prints 'FizzBuzz'
     */
    public static void fizzBuzzNumCheck() {
        final String MSG_ERR_INPUT = "Invalid input! Please enter an integer.";
        int num = UserInputUtils.readInt(input, "\nEnter some integer: ", MSG_ERR_INPUT);

        if(isDivByThreeAndFive(num)){
            System.out.println("FizzBuzz");
        } else if(isDivByThree(num)){
            System.out.println("Fizz");
        } else if(isDivByFive(num)){
            System.out.println("Buzz");
        } else{
            System.out.println("None");
        }
    }

    /**
     * Checks if the input number is divisible by 3
     * @param number (input number)
     * @return true or false
     */
    public static boolean isDivByThree(int number){
        return (number % 3) == 0;
    }

    /**
     * Checks if the input number is divisible by 5
     * @param number (input number)
     * @return true or false
     */
    public static boolean isDivByFive(int number){
        return (number % 5) == 0;
    }

    /**
     * Checks if the input number is divisible by 3 and 5
     * @param number (input number)
     * @return true or false
     */
    public static boolean isDivByThreeAndFive(int number){
        return ((number % 3) == 0) && ((number % 5) == 0);
    }
}
