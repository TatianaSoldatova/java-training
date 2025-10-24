package beginner;
import utils.UserInputUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class VariousMethods {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        calculateBirthYear();
        calculateBMI();
        fondue();

        sumOfDegrees();

        input.close();
    }

    /**
     * Calculates a person's BMI (body mass index).
     * BMI is calculated from weight and height using the formula:
     * weight (in kg) divided by the square of height (in meters).
     */
    public static void calculateBMI(){
        final String MSG_WEIGHT = "Enter your weight (in kg): ";
        final String MSG_HEIGHT = "Enter your height (in m): ";
        final String MSG_ERR    = "Invalid input!";

        double weight = 74.5;
        double height = 1.75;

        weight = UserInputUtils.readDouble(input, MSG_WEIGHT, MSG_ERR);
        height = UserInputUtils.readDouble(input, MSG_HEIGHT, MSG_ERR);

        double bmi = weight / (height * height);
        System.out.println("For " + weight + " kg and " + height + " m, IBM is " + bmi);
        System.out.println();
    }

    /**
     * Calculates the year the user was born in
     */
    public static void calculateBirthYear(){
        final String MSG_AGE        = "How old are you? ";
        final String MSG_BIRTHYEAR  = "You were born in ";
        final String MSG_ERR        = "Invalid input!";
        final int CURRENT_YEAR      = 2025;

        int age;

        age = UserInputUtils.readInt(input, MSG_AGE, MSG_ERR);
        System.out.println(MSG_BIRTHYEAR + (CURRENT_YEAR - age));
        System.out.println();
    }

    /**
     * Calculates ingredients to prepare a swiss fondue.
     * Automatically adapts, based on the number of guests,
     * the quantities of ingredients needed to make the recipe
     */
    public static void fondue(){
        final String MSG_GUESTS  = "How many guests were invited for the fondue: ";
        final String MSG_ERR     = "Invalid input!";
        final int BASE_NB_GUESTS = 4;

        // ingredients for BASE_NB_GUESTS
        double baseCheese = 800.0; // gr
        double baseWater = 2.0;    // dL (decilitre)
        double baseGarlic = 2.0;   // piece
        double baseBread = 400.0;  // gr

        int nbGuests = UserInputUtils.readInt(input, MSG_GUESTS, MSG_ERR);
        double ratio = nbGuests;
        ratio /= BASE_NB_GUESTS;

        baseCheese *= ratio;
        baseWater  *= ratio;
        baseGarlic *= ratio;
        baseBread  *= ratio;

        System.out.println("To prepare the swiss fondue for " + nbGuests + " guests, you will need: ");
        System.out.println("- " + baseCheese + " gr of cheese");
        System.out.println("- " + baseWater + " dl of water");
        System.out.println("- " + baseGarlic + " piece(s) of garlic");
        System.out.println("- " + baseBread + " gr of bread");
        System.out.println("- " + "pepper, as much as you want");
        System.out.println();
    }

    /**
     * Reads a sequence of integer degree values from a text file and calculates the resulting
     * final turn in degrees after applying all rotations sequentially.
     * Each integer in the file represents a rotation angle in degrees, separated by commas.
     * Negative values indicate counterclockwise rotations, and positive values indicate clockwise rotations.
     * The function normalizes each rotation so that the cumulative sum always remains within 0–359 degrees.
     */
    public static void sumOfDegrees(){
        String sequence = " ";
        int sum = 0;

        try{
            sequence = Files.readString(Path.of("src/beginner/b_text_files/degrees.txt"));
            //System.out.println("File content: " + sequence);
        } catch (IOException e){
            e.printStackTrace();
        }
        sequence = sequence.trim();

        String[] parts = sequence.split(",");
        int[] degrees = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            degrees[i] = Integer.parseInt(parts[i]);
        }

        //Print the array
        //System.out.println(Arrays.toString(degrees));

        for(int i = 0; i < degrees.length; i++){
            if(degrees[i] < 0){
                sum += (360 + degrees[i]);
            }else{
                sum += degrees[i];
            }

            if(sum >= 360){
                sum -= 360;
            }
            //System.out.println(sum);
        }
        System.out.println("The final turn is equal to " + sum + " degrees");
    }
}
