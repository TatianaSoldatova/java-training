package beginner;
import java.util.Scanner;

public class SwitchPractice {
    static Scanner input = new Scanner(System.in);

    //-----------
    // CONSTANTS
    //-----------
    final static String ANSI_RED        = "\u001B[31m";
    final static String ANSI_BLUE       = "\u001B[34m";
    final static String ANSI_YELLOW     = "\u001B[33m";
    final static String ANSI_GREEN      = "\u001B[32m";
    final static String ANSI_RESET      = "\u001B[0m";

    public static void main(String[] args) {
        calculateFloorArea();
        harryPotterSwitchExercise();

        input.close();
    }

    /**
     * Calculates its floor area depending on its shape (triangle, rectangle or circle)
     * by calling the appropriate method.
     * Prints the calculated area to the console.
     */
    public static void calculateFloorArea(){
        String shape;

        // Validate user's input
        shape = validateShapeInput();

        // Handle area calculations depending on the floor shape
        switch (shape) {
            case ("triangle"):
                handleTriangle(input);
                break;
            case "rectangle":
                handleRectangle(input);
                break;
            case "circle":
                handleCircle(input);
                break;
        }
    }

    /**
     * Prompts the user to enter the shape of a room and validates the input.
     * Repeats the input prompt until a valid shape is entered.
     * @return shape
     */
    public static String validateShapeInput(){
        final String MSG_SHAPE = "\nEnter the room shape (triangle, rectangle or circle): ";
        final String MSG_ERR_SHAPE_INPUT = "Error! Invalid input! Try again...";
        String shape;
        do{
            System.out.print(MSG_SHAPE);
            shape = input.next().toLowerCase();

            if(!shape.equals("triangle") && !shape.equals("rectangle") && !shape.equals("circle")){
                System.out.println(ANSI_RED + MSG_ERR_SHAPE_INPUT + ANSI_RESET);
            }
        }while(!shape.equals("triangle") && !shape.equals("rectangle") && !shape.equals("circle"));

        return shape;
    }

    /**
     * Takes user's input and displays triangle floor area
     * @param input (user's input for 3 sides of a triangle)
     */
    public static void handleTriangle(Scanner input){
        final String MSG_ERR = "Invalid triangle sides. Try again...";

        double a, b, c;

        //Validate triangle sides
        do{
            System.out.print("Enter the 'a' side length: ");
            a = input.nextDouble();
            System.out.print("Enter the 'b' side length: ");
            b = input.nextDouble();
            System.out.print("Enter the 'c' side length: ");
            c = input.nextDouble();

            // The triangle inequality states that for any triangle,
            // the sum of the lengths of any two sides must be greater than or equal to
            // the length of the remaining side.
            if (!(a + b >= c) || !(a + c >= b) || !(b + c >= a)) {
                System.out.println(ANSI_RED + MSG_ERR + ANSI_RESET);
            }
        }while(!(a + b >= c) || !(a + c >= b) || !(b + c >= a));

        displayArea(triangleAreaHeronFormula(a, b, c));
    }

    /**
     * Takes user's input and displays rectangle floor area
     * @param input (user's input for 2 sides of a rectangle)
     */
    public static void handleRectangle(Scanner input){
        System.out.print("Enter the 'a' side length: ");
        double a = input.nextDouble();
        System.out.print("Enter the 'b' side length: ");
        double b = input.nextDouble();

        displayArea(rectangleArea(a, b));
    }

    /**
     * Takes user's input and displays circle floor area
     * @param input (user's input for the radius of a circle)
     */
    public static void handleCircle(Scanner input){
        System.out.print("Enter the radius length: ");
        double r = input.nextDouble();

        displayArea(circleArea(r));
    }

    /**
     * Prints on screen the formatted floor area
     * @param area (value of the calculated floor area)
     */
    public static void displayArea(double area) {
        final String MSG = "Floor area = %.2f%n";
        System.out.printf(ANSI_BLUE + MSG + ANSI_RESET, area);
    }

    /**
     * Calculates the area of a triangle with sides a, b, c:
     * The Heron formula:
     * 1. compute the semiperimeter: s = (a+b+c)/2
     * 2. compute the area : area = sqrt(s * (s-a) * (s-b) * (s-c))
     * @return area
     */
    public static double triangleAreaHeronFormula(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    /**
     * Calculates the area of a rectangle with sides a and b:
     * The formula: area = side a * side b
     * @return area
     */
    public static double rectangleArea(double a, double b) {
        return parallelogramArea(a, b);
    }

    /**
     * Calculates the area of a parallelogram:
     * The formula: area = height h * base b
     * @return area
     */
    public static double parallelogramArea(double h, double b) {
        return h * b;
    }

    /**
     * Calculates the area of a circle:
     * The formula : area = PI * (radius * radius)
     * @return area
     */
    public static double circleArea(double r) {
        return Math.PI * (r * r);
    }

    //----------------------------------------------------------------
    /**
     * switch selection exercise with input validation loop
     */
    public static void harryPotterSwitchExercise(){
        final String MSG_HOUSE_INPUT = "\nEnter one Hogwarts house: ";

        System.out.print(MSG_HOUSE_INPUT);
        String house = input.next().toLowerCase();
        boolean isValid = false;

        while(!isValid){
            switch (house) {
                case "gryffindor":
                    System.out.println("bravery");
                    isValid = true;
                    break;
                case "hufflepuff":
                    System.out.println("loyalty");
                    isValid = true;
                    break;
                case "slytherin":
                    System.out.println("cunning");
                    isValid = true;
                    break;
                case "ravenclaw":
                    System.out.println("intellect");
                    isValid = true;
                    break;
                default:
                    System.out.println("not a valid house");
                    System.out.print(MSG_HOUSE_INPUT);
                    house = input.next().toLowerCase();
            }
        }
    }
}
