package beginner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class LoopPractice {
    static void main() {
        heightAfterNRebounds();
        decodeTheMessage();
    }

    /**
     * Calculates and displays the height of a ball after a fixed number of rebounds.
     * The method simulates the motion of a ball dropped from an initial height under the influence
     * of gravity. Each time the ball bounces, it loses some energy depending on the rebound
     * coefficient. The height after each rebound is printed, as well as the final height after
     * the specified number of rebounds.
     */
    public static void heightAfterNRebounds(){
        final int NBR_REBOUNDS           = 10;
        final double GRAVITY             = 9.81;
        final double INITIAL_HEIGHT      = 25;
        final double REBOUND_COEFFICIENT = 0.9;

        double speedBeforeRebound;
        double speedAfterRebound;
        double heightAtStartOfFall;
        double heightAtEndOfRise;

        heightAtStartOfFall = INITIAL_HEIGHT;

        for (int i = 0; i < NBR_REBOUNDS; ++i) {
            speedBeforeRebound = Math.sqrt(2.0 * GRAVITY * heightAtStartOfFall);
            speedAfterRebound = REBOUND_COEFFICIENT * speedBeforeRebound;

            heightAtEndOfRise = (speedAfterRebound * speedAfterRebound)/(2.0 * GRAVITY);
            heightAtStartOfFall = heightAtEndOfRise;
            System.out.println("rebond " + (i+1) + " : " + heightAtStartOfFall);
        }
        System.out.printf("\nHeight of the ball after " + NBR_REBOUNDS + " rebounds: " + heightAtStartOfFall);
        System.out.println();
    }

    /**
     * Reads a sequence of movement instructions from a text file and decodes it into a hidden message
     * based on a 4×4 virtual keyboard layout.
     *  The virtual keyboard layout is as follows:
     *    A B C D
     *    E F G H
     *    I J K L
     *    M N O P
     *  Each line of the input file represents a separate letter in the message.
     *  A line contains a list of comma-separated directions (e.g., UP, LEFT, DOWN, RIGHT) that
     *  describe how to move from the starting position (top-left key 'A') across the keyboard.
     *  The algorithm processes each sequence of directions to determine the final key position.
     *  That key’s character is then appended to the decoded message.
     *  For example, given a line:
     *  RIGHT, DOWN, DOWN
     *  The decoder moves from 'A' → 'B' → 'F' → 'J', so 'J' is added to the message.
     */
    public static void decodeTheMessage() {
        //Directions
        String sequence = " ";
        try{
            sequence = Files.readString(Path.of("src/beginner/b_text_files/movements.txt"));
        } catch (IOException e){
            e.printStackTrace();
            return;
        }
        //sequence = sequence.trim();
        String[] parts = sequence.split("\n");

        final String KEYBOARD = "ABCDEFGHIJKLMNOP";
        System.out.println("\nparts length: " + parts.length);
        System.out.println("keyboard length:" + KEYBOARD.length());

        String message = "";
        char currentChar = ' ';
        int currentIndex;

        // UP, DOWN, LEFT, RIGHT
        for (int i = 0; i < parts.length; i++) {
            String[] directions = parts[i].split(",");
            currentIndex = 0;
            for (int j = 0; j < directions.length; j++) { // UP DOWN LEFT RIGHT
                directions[j] = directions[j].trim();
                switch (directions[j]) {
                    case "UP":
                        if(currentIndex <= 3) {
                            currentChar = KEYBOARD.charAt(currentIndex);
                        }else{
                            currentChar = KEYBOARD.charAt(currentIndex - (KEYBOARD.length()/4));
                            currentIndex = currentIndex - (KEYBOARD.length()/4);
                        }
                        break;
                    case "DOWN":
                        if(currentIndex >= 12) {
                            currentChar = KEYBOARD.charAt(currentIndex);
                        }else{
                            currentChar = KEYBOARD.charAt(currentIndex + (KEYBOARD.length()/4));
                            currentIndex = currentIndex + (KEYBOARD.length()/4);
                        }
                        break;
                    case "LEFT":
                        if(currentIndex % 4 == 0) {
                            currentChar = KEYBOARD.charAt(currentIndex);
                        }else{
                            currentChar = KEYBOARD.charAt(currentIndex - 1);
                            currentIndex = currentIndex - 1;
                        }
                        break;
                    case "RIGHT":
                        int index = ((KEYBOARD.length()/4) * (currentIndex / 4 + 1) - 1);
                        if(currentIndex == 3 || currentIndex == index) {
                            currentChar = KEYBOARD.charAt(currentIndex);
                        }else{
                            currentChar = KEYBOARD.charAt(currentIndex + 1);
                            currentIndex = currentIndex + 1;
                        }
                        break;
                }
            }
            message += currentChar;
        }

        for(int i = 0; i < message.length(); i++){
            System.out.print(message.charAt(i));
        }
        System.out.println("\nlength: " + message.length());
        System.out.println();
        // answer: LECDJGAPPIFCCIOOBOEFANLFFAFLMBOKLFJPMIHEKJEIOLLMPFOCLBIBLLOCEGOA
    }
}

