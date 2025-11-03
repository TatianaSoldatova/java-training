package beginner;
import utils.UserInputUtils;

import java.util.Scanner;
import java.util.Arrays;

public class ArrayPractice {
    static Scanner input = new Scanner(System.in);

    static void main() {
        rightRotationIntArray();
        rightShiftStringArray();

        neverNextToEachOther();

        discoverArrays();
        brokenArray();
        fillTheArray();
        countArrayElements();

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

    /**
     * Checks whether a predefined array of integers is sorted in ascending order.
     */
    public static void brokenArray(){
        int[] numbers = {1, 2, 3, 4, 5, 10, 6};
        boolean broken = false;

        for(int i = 1; i < numbers.length; i++){
            if(numbers[i] < numbers[i-1]){
                broken = true;
                break;
            }
        }

        if(broken){
            System.out.println(Arrays.toString(numbers));
            System.out.println("BROKEN");
        }else{
            System.out.println(Arrays.toString(numbers));
            System.out.println("OK");
        }
    }

    /**
     * Create a new array and fill it with some values from the user's input
     */
    public static void fillTheArray(){
        System.out.println("\nfillTheArray: ");
        int length = input.nextInt();
        int[] array = new int[length];

        for(int i = 0; i < length; i++){
            array[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(array));
        System.out.println();
    }

    /**
     * Counts the number of 'a' characters in an array of characters
     */
    public static void countArrayElements(){
        char[] characters = {'a', 'b', 'c', 'a', 'b', 'c', 'a'};

        int counter = 0;
        for(char ch:  characters){
            if(ch == 'a'){
                counter++;
            }
        }
        System.out.println(Arrays.toString(characters));
        System.out.println("Number of 'a' characters: " + counter);
        System.out.println();
    }

    /**
     * Shifts each element of an array to the right by a given number
     * The method reads the array elements from user input, splits them into a string array,
     * and then creates a new array where each element is shifted to the right by the given
     * number of positions. The shifted array is then displayed.
     * {1,2,3,4,5} shift by 1 : {5,1,2,3,4}
     * {1,2,3,4,5} -> {5,1,2,3,4} -> {4,5,1,2,3}
     */
    public static void rightShiftStringArray(){
        String array;
        System.out.print("\nEnter your array elements: ");
        array = input.nextLine();

        String[] nums =  array.split(" ");
        System.out.println(Arrays.toString(nums));

        System.out.print("Enter the number of shifts: ");
        int nbrShifts = input.nextInt();

        String[] shiftedNums = new String[nums.length];
        for(int i = 0; i < shiftedNums.length; i++){
            int index = (nbrShifts + i) % nums.length;
            shiftedNums[index] = nums[i];
        }
        System.out.println(Arrays.toString(shiftedNums));
        System.out.println();
    }

    /**
     * Prompts the user to input an array of integers and a number of rotation steps,
     * then performs a right rotation on the array by the specified number of steps.
     */
    public static void rightRotationIntArray(){
        System.out.print("\nEnter your array elements: ");
        int[] arr = Arrays.stream(input.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print("Enter the number of shifts: ");
        int steps = Integer.parseInt(input.nextLine());

        arr = rotate(arr, steps);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Rotates the given integer array to the right by the specified number of steps.
     * Each element in the array is moved to a new index determined by:
     * (currentIndex + steps) % arrayLength
     * @param arr the integer array to rotate
     * @param steps the number of positions to shift elements to the right
     * @return a new array containing the rotated elements
     */
    public static int[] rotate(int[] arr, int steps){
        int[] shiftedNums = new int[arr.length];
        for(int i = 0; i < shiftedNums.length; i++){
            int index = (steps + i) % arr.length;
            shiftedNums[index] = arr[i];
        }
        arr = shiftedNums;
        return arr;
    }

    /**
     * Reads an array of integers and two numbers n and m.
     * Checks that n and m never occur next to each other (in any order) in the array.
     * The first line contains the size of an array.
     * The second line contains elements of the array.
     * The third line contains two integer numbers n and m.
     * All numbers in the same line are separated by the space character.
     * The result is a single boolean value: true if n and m never occur next to each other;
     * otherwise, it is false.
     */
    public static void neverNextToEachOther(){
        boolean isNeverNext = true;
        System.out.print("Enter the array size: ");
        int size =  input.nextInt();

        System.out.print("Enter the array elements: ");
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = input.nextInt();
        }

        System.out.print("Enter n and m numbers: ");
        int[] nmNumbers =  new int[2];
        for(int i = 0; i < 2; i++){
            nmNumbers[i] = input.nextInt();
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == nmNumbers[0] && i < arr.length - 1){
                if(arr[i + 1] == nmNumbers[1]){
                    isNeverNext = false;
                }
            }else if (arr[i] == nmNumbers[1] && i < arr.length - 1){
                if(arr[i + 1] == nmNumbers[0]){
                    isNeverNext = false;
                }
            }
        }
        System.out.println(isNeverNext);
        System.out.println();
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
        System.out.println();

        int k = 10;
        int[] squares = new int[k];

        System.out.println(Arrays.toString(squares));
        System.out.println();

        //iterating over the array
        for(int i = 0; i < squares.length; i++){
            squares[i] = i * i;
        }
        System.out.println(Arrays.toString(squares));
        System.out.println();

        int[] myArray = {1,2,3,4,5};
        int length = myArray.length; // number of elements of the array
        System.out.println(length);
        System.out.println();

        // Accessing
        myArray[0]++;
        myArray[0] = 10;
        myArray[1] = 20;
        myArray[2] = 30;
        myArray[3] = myArray[1] +  myArray[2];

        char[] array = new char[0];


    }
}
