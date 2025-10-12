package beginner;
import java.util.Scanner;

public class TrafficLightController {
    static Scanner input = new Scanner(System.in);

    //----------
    // CONSTANTS
    //----------
    final static String MSG_INPUT     = """
                                        \nEnter the state of the current traffic light
                                        0 for red, 1 for yellow and 2 for green:\s""";
    final static String MSG_ERR_INPUT = "Invalid input! Please enter an integer.";

    public static void main() {
        int currentState = UserInputUtils.readInt(input, MSG_INPUT, MSG_ERR_INPUT);
        input.close();

        String nextState = getNextState(currentState);
        String action = getAction(currentState);

        System.out.println(nextState);
        System.out.println(action);
    }

    /**
     * Handles different light states (red, yellow, green) and cycles through them.
     * 0 for red, 1 for yellow, 2 for green
     * @param currentState (current light)
     * @return the next state
     */
    public static String getNextState(int currentState) {
        return switch (currentState) {
            case 0 -> "1";
            case 1 -> "2";
            case 2 -> "0";
            default -> "Invalid state";
        };
    }

    /**
     * Handles different light actions
     * @param currentState (current light)
     * @return the next action
     */
    public static String getAction(int currentState) {
        return switch (currentState){
            case 0 -> "Change to Yellow";
            case 1 -> "Change to Green";
            case 2 -> "Change to Red";
            default -> "Invalid action";
        };
    }
}
