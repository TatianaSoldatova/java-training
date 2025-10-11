package beginner;
import java.util.Scanner;

public class SmartHomeApp {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        accessSmartHome();
        input.close();
    }

    //-------
    //METHODS
    //-------

    /**
     * Verifies the password and gives access to Smart home actions if the password is correct
     */
    public static void accessSmartHome() {
        final int password = 2025;
        System.out.print("Enter password: ");
        int passwordInput = input.nextInt();
        if (passwordInput == password) {
            chooseAction();
        } else {
            System.out.println("Incorrect password!");
        }
    }

    /**
     * Asks the user what they want to do
     */
    public static void chooseAction() {
        final String[] OPTIONS_MUSIC  = {"on/off?","on","The music is on","off", "The music is off"};
        final String[] OPTIONS_LIGHT  = {"on/off?","on","The light is on","off", "The light is off"};
        final String[] OPTIONS_KETTLE = {"on/off?","on","The kettle is on","off", "The kettle is off"};
        final String[] OPTIONS_DOOR   = {"open/close?","open","The door is open","close", "The door is closed"};
        final String MSG_CHOICE       = "Choose the object: \n1 – speakers\n2 – lamp\n3 – door\n4 - kettle";

        String action = " ";
        do{
            System.out.println(MSG_CHOICE);
            action = input.next();

            switch (action) {
                case "1":
                    controlOption(OPTIONS_MUSIC);
                    break;
                case "2":
                    controlOption(OPTIONS_LIGHT);
                    break;
                case "3":
                    controlOption(OPTIONS_DOOR);
                    break;
                case "4":
                    controlOption(OPTIONS_KETTLE);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }while(!action.equals("1") && !action.equals("2") && !action.equals("3") && !action.equals("4"));

    }

    /**
     * Controls the chosen option (music, light, door or kettle)
     * @param options (array of strings to fill the output for the chosen option)
     */
    public static void controlOption(String[] options) {
        String choice = " ";
        do{
            System.out.println(options[0]);
            choice = input.next();
            if (choice.equalsIgnoreCase(options[1])) {
                System.out.println(options[2]);
            } else if (choice.equalsIgnoreCase(options[3])) {
                System.out.println(options[4]);
            } else {
                System.out.println("Invalid operation");
            }
        }while(!choice.equalsIgnoreCase(options[1]) && !choice.equalsIgnoreCase(options[3]));
    }
}
