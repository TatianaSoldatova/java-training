package beginner;
import java.util.Scanner;

public class BusBridgesHeight {
    static Scanner input = new Scanner(System.in);

    static void main() {
        CompareBusAndBridgesHeight();
        input.close();
    }

    /**
     * Compares the height of a bus to several bridges and determines
     * whether the bus will safely pass or crash.
     * The method prompts the user to enter the bus height, the number
     * of bridges, and each bridge's height. It then checks each bridge
     * sequentially to determine if the bus can pass under it. If the bus
     * is too tall for a bridge, the program reports the first bridge on
     * which the bus would crash.
     */
    public static void CompareBusAndBridgesHeight(){
        final String MSG_BUS_PROMPT = "\nEnter the bus height and the bridges quantity: ";
        final String MSG_BRIDGES_PROMPT = "\nEnter the bridges heights: ";
        int busHeight       = 0;
        int bridgeQty       = 0;
        int bridgeHeight    = 0;

        System.out.print(MSG_BUS_PROMPT);
        busHeight = input.nextInt();
        bridgeQty = input.nextInt();

        String message = "Will not crash";

        System.out.print(MSG_BRIDGES_PROMPT);
        for(int i = 1; i <= bridgeQty; i++){
            bridgeHeight = input.nextInt();
            if(busHeight >= bridgeHeight){
                message = "Will crash on bridge " + i;
                break;
            }
        }
        System.out.println(message);
    }
}
