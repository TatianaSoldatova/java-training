package beginner;
import utils.UserInputUtils;

import java.util.Scanner;
import java.util.Arrays;

public class ArrayPractice {
    static Scanner input = new Scanner(System.in);

    static void main() {
        sumOfMultiplesOfThree();

        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(numbers));
        swapFirstAndLastElements(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println();

        printNumberOfArguments(1);
        printNumberOfArguments(1, 2);
        printNumberOfArguments(1, 2, 3);
        printNumberOfArguments(new int[]{ });
        printNumberOfArguments(new int[]{ 1, 2 });
        System.out.println();

        addValueByIndex(numbers, 3, 15);
        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
        System.out.println("\n");

        int[] nums = {4, 5, 6};
        // The reference to nums is copied into the parameter array.
        // Both nums and array now refer to the same array
        createNewArray(nums);
        // The local variable array disappears
        // Nothing happened to the original array nums
        System.out.println(Arrays.toString(nums)); // 4 5 6

        input.close();
    }

    public static void addValueByIndex(int[] array, int index, int value) {
        for (int i = 0; i < array.length; i++) {
            if(i == index){
                array[i] += value;
            }
        }
    }

    public static void createNewArray(int[] array) {
        array = new int[] {1, 2, 3};
        // array points to a new array {1, 2, 3}
        // but nums in main still points to the old array {4, 5, 6}
    }

    /**
     * Prompts the user to enter a number of integers,
     * stores them in an array, and calculates the sum of all numbers
     * that are multiples of three.
     */
    public static void sumOfMultiplesOfThree() {
        final String MSG_INPUT          = "\nEnter the number of elements: ";
        final String MSG_INPUT_INTEGER  = "Enter an integer: ";
        final String MSG_ERR_INPUT      = "Invalid input!";
        final String MSG_RESULT         = "The sum of multiples of three: ";

        int n = UserInputUtils.readPositiveInt(input, MSG_INPUT, MSG_ERR_INPUT);
        int[] numbersArray = new int[n];

        for (int i = 0; i < n; i++) {
            numbersArray[i] = UserInputUtils.readInt(input, MSG_INPUT_INTEGER, MSG_ERR_INPUT);
        }

        int sum = 0;
        for (int i = 0; i < numbersArray.length; i++) {
            if(numbersArray[i] % 3 == 0){
                sum += numbersArray[i];
            }
        }
        System.out.println(MSG_RESULT + sum);
        System.out.println();
    }

    /**
     * Swaps the first and last elements of the given integer array.
     * If the array contains fewer than one element (i.e., it is empty),
     * the method does nothing and returns immediately
     * @param nums the array whose first and last elements are to be swapped
     */
    public static void swapFirstAndLastElements(int[] nums) {
        if(nums.length < 1){
            return;
        }
        int temp = nums[nums.length - 1]; // save the last element
        nums[nums.length - 1] = nums[0];
        nums[0] = temp;
    }

    /**
     * Pass an arbitrary number of the same type of arguments to a method
     * using varargs (variable-length arguments)
     * @param numbers a vararg parameter
     */
    public static void printNumberOfArguments(int... numbers) {
        System.out.println(numbers.length);
    }

    /**
     * If a method has more than one parameter, the vararg parameter
     * must be the last one in the declaration of the method.
     */
    public static void testMethod(int a, double...varargs){
        // do something
    }

    public static void discoverArrays(){
        int[] numbers1 = {1,2,3,4,5,6};

        // This form is useful when the number of elements is known before starting the program.
        // When we create an instance of the array object with indicated length like [n] and don't enumerate
        // its elements explicitly, the array is initialized with default values of its type.
        // default value if int is 0
        int n = 5; // n is a length of an array
        int[] numbers2 = new int[n];

        int[] numbers3;         // declaration
        numbers3 = new int[n];  // instantiation and initialization with default values

        float[] floatNumbers;
        floatNumbers = new float[] {1.02f, 2.3f, 0.5f, 10.5f};

        int size = 10;
        char[] characters = new char[size];
        Arrays.fill(characters, 0, size/2, 'a');
        Arrays.fill(characters, size/2, size, 'b');
        System.out.println(Arrays.toString(characters));

        int[] myArray = {1,2,3,4,5};
        int length = myArray.length; // number of elements of the array
        System.out.println(length);

        // Accessing
        myArray[0]++;
        myArray[0] = 10;
        myArray[1] = 20;
        myArray[2] = 30;
        myArray[3] = myArray[1] +  myArray[2];

        char[] array = new char[0];
    }
}
