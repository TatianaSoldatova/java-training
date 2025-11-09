package coursera_epfl.Exercises;
import utils.UserInputUtils;

import java.util.Scanner;

public class FixedSizeArrays {
    static Scanner input = new Scanner(System.in);

    static void main() {
        scores();
        input.close();
    }

    /**
     * Reads player scores from user input, calculates the average score, and displays
     * each player's score along with its deviation from the average.
     */
    public static void scores() {
        int n = UserInputUtils.readInt(input, "Enter the number of players: ", "Invalid input!");
        if(n > 0){
            double average = 0;
            int[] scores = new int[n];

            for (int i = 0; i < n; i++) {
                System.out.print("Score of player " + i + ": ");
                scores[i] = UserInputUtils.readInt(input, "", "Invalid input!");
                average += scores[i];
            }
            average /= n;

            System.out.println("Average score: " + average);
            average = Math.round(average);
            System.out.println("Rounded average score: " + average);

            System.out.println("\nScore " + " Average deviation");
            for(int i = 0; i < n; i++){
                System.out.print(scores[i] + "    " + (scores[i] - average) + "\n");
            }
        }
    }
}
