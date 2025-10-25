package beginner;

public class LoopPractice {
    static void main() {
        heightAfterNRebounds();
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
    }
}
