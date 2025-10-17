package beginner;
import java.util.Scanner;

/**
 * Various methods handling String class
 */
public class StringPractice {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Create String from chars array and
        char[] chars1 = {'A', 'B', 'C', 'D', 'E', 'F'};
        String str = stringFromChars(chars1);
        System.out.println("\nString from char[]: " + str);

        // Create chars array from String
        char[] chars2 = stringToChars(str);
        System.out.print("char[] from String: ");
        for (char c : chars2) {
            System.out.print(c + " ");
        }
        System.out.println();

        // Create new String
        String theSameString = new String(chars2);
        System.out.println("new String from char[]: " + theSameString);

        // split String
        // Create String array from a String
        String hello = "Hello";
        String[] splitHello = stringArrayFromString(hello);
        System.out.print("String[] from a String with split: ");
        for (String s : splitHello) {
            System.out.print(s + ", ");
        }
        System.out.println();

        // Split String with delimiter (-)
        String number = "+1-213-345-6789";
        String[] parts = number.split("-"); // {"+1", "213", "345", "6789"}
        System.out.print("String[] from a String with split and delimiter: ");
        for (String p : parts) {
            System.out.print(p + ", ");
        }
        System.out.println();

        // Iterate through String
        String text = "I'm gonna be a programmer";
        System.out.println("Iterate through a String: ");
        iterateThroughString(text);
        System.out.println();

        // Longest word in a sentence
        longestWordInSentence();
        System.out.println();

        // Compress a sequence
        String compress = compressionAlgorithm();
        System.out.println(compress);
        System.out.println();

        input.close();
    }

    /**
     * Converts an array of characters into a single string.
     * @param chars the array of characters to convert
     * @return a string composed of the given characters
     */
    public static String stringFromChars(char[] chars) {
        return String.valueOf(chars);
    }

    /**
     * Converts a string into an array of characters.
     * @param str the string to convert
     * @return an array of characters representing the given string
     */
    public static char[] stringToChars(String str) {
        return str.toCharArray();
    }

    /**
     * Splits a string into an array of single-character strings.
     * @param str the string to split into individual string elements
     * @return an array of one-character strings
     */
    public static String[] stringArrayFromString(String str) {
        return str.split("");
    }

    /**
     * Iterates through each character of a given string and prints them separated by spaces.
     * @param str the string whose characters will be iterated and printed
     */
    public static void iterateThroughString(String str){
        for(int i = 0; i < str.length(); i++){
            System.out.print(str.charAt(i) + " ");
        }
    }

    /**
     * Reads a sentence from user input and determines the longest word in it.
     */
    public static void longestWordInSentence(){
        final String MSG_INPUT = "Enter a sentence: ";

        System.out.print(MSG_INPUT);
        String sentence = input.nextLine();
        String[] words = sentence.split(" ");
        int maxLength = 0;
        String longestWord = "";
        for(String word : words){
            if(word.length() > maxLength){
                maxLength = word.length();
                longestWord = word;
            }
        }
        System.out.println("The longest word is: " + longestWord);
    }

    /**
     * Compresses repeated characters in a string
     * Ex.: string "aaaabbсaa" is converted into "a4b2с1a2",
     */
    public static String compressionAlgorithm(){
        final String MSG_INPUT = "Enter a string like 'aaaabbсaa': ";

        System.out.print(MSG_INPUT);
        String sequence = input.nextLine();
        sequence = sequence.replace('с', 'c');
        String noSpacesSequence = sequence.replace(" ", "");
        String encodedSequence = "";

        char currentChar = ' ';
        int counter = 1;

        for(int i = 0; i < noSpacesSequence.length(); i++){
            currentChar = noSpacesSequence.charAt(i);
            if(i < noSpacesSequence.length() - 1 && currentChar == noSpacesSequence.charAt(i + 1)) {
                counter++;
            }else{
                encodedSequence = encodedSequence.concat(Character.toString(currentChar));
                encodedSequence = encodedSequence.concat(String.valueOf(counter));
                counter = 1;
            }
        }
        return encodedSequence;
    }
}