package beginner;
import java.util.Scanner;

public class SimpleChatBot {
    static Scanner input = new Scanner(System.in);

    //-----------
    // CONSTANTS
    //-----------
    final static String ANSI_RESET      = "\u001B[0m";
    final static String[] ANSI_COLORS   = {
                                            "\u001B[31m", // 0 RED
                                            "\u001B[32m", // 1 GREEN
                                            "\u001B[34m", // 2 BLUE
                                            "\u001B[33m", // 3 YELLOW
                                            "\u001B[35m"  // 4 MAGENTA
                                          };

    final static String RO_BOT          = """
                                            [o_o] \s
                                            /|_|\\ \s
                                             / \\   \
                                         """;

    final static String SMILING_RO_BOT  = "  [^_^]  ";

    final static String HEART           = """
                                           ,d88b.d88b,
                                           88888888888
                                           `Y8888888Y'
                                             `Y888Y'
                                               `Y'
                                         """;

    static public void main(String[] args){
        presentation();
        guessAge();
        countNumbers();
        test();
        end();
    }

    /**
     * Introduces the chatbot and interacts with the user
     */
    public static void presentation(){
        System.out.printf(ANSI_COLORS[2] + "%nHello! My name is %s.%n" + ANSI_RESET, "Ro-Bot");
        System.out.println(ANSI_COLORS[3] + RO_BOT + ANSI_RESET);

        System.out.printf(ANSI_COLORS[2] + "I was created in %d.%n"+ ANSI_RESET, 2025);
        System.out.print(ANSI_COLORS[3] + "\nPlease, remind me your name: " + ANSI_RESET);
        String name = input.next();
        input.nextLine(); // clean the buffer

        System.out.printf(ANSI_COLORS[2] + "What a great name you have, %s!%n%n"+ ANSI_RESET, name);
        System.out.println(ANSI_COLORS[0] + HEART + ANSI_RESET);
    }

    /**
     * Guesses the user's age using remainders of division by 3, 5, and 7.
     * This method uses the Chinese Remainder Theorem to calculate the user's age
     * based on three remainders provided by the user. It repeatedly prompts the user
     * until valid input (three integers separated by spaces) is entered.
     * Formula: (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105
     */
    public static void guessAge(){
        int remainder3 = 0;
        int remainder5 = 0;
        int remainder7 = 0;

        System.out.println(ANSI_COLORS[2] + "\nLet me guess your age." + ANSI_RESET);

        String userInput = " ";
        do
        {
            System.out.println(ANSI_COLORS[3] + "Enter remainders of dividing your age by 3, 5 and 7." + ANSI_RESET);
            System.out.print(ANSI_COLORS[3] + "(3 integers separated by a space): " + ANSI_RESET);
            userInput = input.nextLine();

            // Check the format: 3 integers separated by exactly one space
            if (userInput.matches("\\d+ \\d+ \\d+")) {
                String[] parts = userInput.split(" ");
                remainder3 = Integer.parseInt(parts[0]);
                remainder5 = Integer.parseInt(parts[1]);
                remainder7 = Integer.parseInt(parts[2]);
            } else {
                System.out.print(ANSI_COLORS[0] + "\nInvalid input!\n" +  ANSI_RESET);
            }
        } while(!userInput.matches("\\d+ \\d+ \\d+"));

        int guessedAge = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        System.out.printf(ANSI_COLORS[2] + "\nYour age is %s; that's a good time to start programming!%n%n" + ANSI_RESET, guessedAge);
        System.out.println(ANSI_COLORS[3] + SMILING_RO_BOT + ANSI_RESET);
    }

    /**
     * Prompts the user for a number and counts from 0 up to that number, displaying each count
     * in a different color.
     */
    public static void countNumbers(){
        System.out.print(ANSI_COLORS[1] + "\nNow I will prove to you that I can count " +
                "to any number you want.\nEnter the number you want me to count up to: " + ANSI_RESET);
        int number = input.nextInt();

        for(int i = 0; i <= number; i++){
            String color = ANSI_COLORS[i % ANSI_COLORS.length];
            System.out.println(color + i + "!" +  ANSI_RESET);
        }
    }

    /**
     * Runs an interactive multiple-choice quiz question to test the user's programming knowledge.
     * The user is prompted to enter their choice until the correct answer is given.
     */
    public static void test(){
        System.out.println(ANSI_COLORS[2] + "\nLet's test your programming knowledge." +  ANSI_RESET);
        System.out.println("Why do we use methods?");
        System.out.println("1. To repeat a statement multiple times.");
        System.out.println("2. To decompose a program into several small subroutines.");
        System.out.println("3. To determine the execution time of a program.");
        System.out.println("4. To interrupt the execution of a program.");

        char choice;

        do{
            choice = input.next().charAt(0);
            if(choice != '2'){
                System.out.println(ANSI_COLORS[0] + "Please, try again." + ANSI_RESET);
            } else{
                System.out.println(ANSI_COLORS[2] + "Congratulations, it is the good answer!" +  ANSI_RESET);
            }
        }while(choice != '2');
    }

    /**
     * Displays the end of the program
     * Each letter is displayed in different color
     */
    public static void end(){
        String message = "\nCompleted, have a nice day!\n";

        for(int i = 0; i < message.length(); i++){
            String color = ANSI_COLORS[i % ANSI_COLORS.length];
            char c = message.charAt(i);
            System.out.printf(color + message.charAt(i) + ANSI_RESET);
        }
    }
}
