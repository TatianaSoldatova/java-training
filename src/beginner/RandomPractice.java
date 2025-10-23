package beginner;
import java.util.Random;
import java.util.Scanner;

public class RandomPractice {

    public static void main(String[] args) {
        Random random = new Random();

        random.nextInt(5); // returns a value in the range from 0 (inclusive) to 5 (exclusive);

        int lower = 2;
        int upper = 5;

        int interval = upper - lower + 1;
        int randomNumber = random.nextInt(upper - lower + 1) + lower; // returns a value between 2 and 5 (inclusive)

        smallestMaximumRandomNumber();
    }

    /**
     * Prompts the user to enter the lower and upper seed bounds (A and B),
     * the number of random numbers to generate N, and the upper bound of random values K.
     * Determines which seed between A and B produces the smallest maximum
     * random number among N generated numbers in the range [0, K).
     */
    static void smallestMaximumRandomNumber() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter A, B, N and K: ");
        int a = input.nextInt(); // lower seed
        int b = input.nextInt(); // upper seed
        int n = input.nextInt(); // numbers of random numbers to produce from 0 to k
        int k = input.nextInt();
        System.out.print("You entered: " + a + " " + b + " " + n + " " + k);

        int max;
        int min = Integer.MAX_VALUE;
        int minSeed = 0;
        int seedInterval = (b - a) + 1;
        System.out.println("\nSeed interval = " + seedInterval);

        for(int i = a; i <= b; i++){
            Random random = new Random(i);
            max = Integer.MIN_VALUE;

            System.out.println("\nRandom sequence for the seed " + i + " is: ");
            for (int j = 0; j < n; j++) {
                int current = random.nextInt(k);
                max = Math.max(max, current);
                System.out.print(current + " ");
            }
            System.out.println("\nThe max value for seed " + i + " is " + max);

            if(max < min){
                min = max;
                minSeed = i;
            }
        }

        System.out.println("\nThe seed with min of max is: " + minSeed);
        System.out.println("\nThe min value is: " + min);

        input.close();
    }
}
