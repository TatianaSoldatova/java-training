package coursera_epfl;
import java.util.Scanner;

/**
 * Program that allows to calculate the parameters of the fall of a skydiver
 * Models the evolution of the parachutist’s motion during free fall and after the
 * parachute opens, taking into account air resistance and gravity.
 * Asks the user for the parachutist’s mass (in kilograms, ≥ 40 kg).
 * Asks for the initial jump height (in meters, ≥ 250 m).
 * Simulates the descent by updating the parachutist’s speed, height, and acceleration over time.
 * Displays key physical events such as:
 *  - When the parachutist exceeds the speed of sound (343 m/s).
 *  - When the maximum speed (terminal velocity) is reached.
 *  - When the parachute opens (at 2500 m or at the next second if the jump starts below 2500 m).
 *  @author epfl & TS
 *  @version 1.0
 */
public class ParachutingJump {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);

        final double g = 9.81;
        final double speedOfSound = 343.0; // m/s

        double masse = 80.0;
        do {
            System.out.print("masse du parachutiste (>= 40) ? ");
            masse = clavier.nextDouble();
        } while (masse < 40.0);

        double h0 = 39000.0;
        do {
            System.out.print("hauteur de depart du parachutiste (>= 250) ? ");
            h0 = clavier.nextDouble();
        } while (h0 < 250.0);

        double v0 = 0;
        double t0 = 0;  // initial time of the fall
        double t;       // current time
        double vitesse;
        double hauteur;
        double accel;
        double surface; // squared meters

        hauteur = h0;
        vitesse = v0;
        accel   = g;
        t       = t0;
        surface = 2.0;

        double s = surface/masse;
        double q;
        boolean gotMaxAcceleration   = true;
        boolean wentBeyondSoundSpeed = true;
        boolean openTheParachute     = true;

        //The evolution of the athlete in free fall is expressed as follows:
        while(hauteur > 0){
            if(accel < 0.5 && gotMaxAcceleration){
                System.out.println("## Felix a atteint sa vitesse maximale");
                gotMaxAcceleration = false;
            }
            if(h0 >= 2500) {
                if(hauteur < 2500.0 && openTheParachute){
                    System.out.println("## Felix ouvre son parachute");
                    surface = 25.0;
                    t0 = t;
                    v0 = vitesse;
                    h0 = hauteur;
                    s = surface/masse;
                    openTheParachute = false;
                }
            }else{
                if(t > 0 && openTheParachute){
                    System.out.println("## Felix ouvre son parachute");
                    surface = 25.0;
                    t0 = t;
                    v0 = vitesse;
                    h0 = hauteur;
                    s = surface/masse;
                    openTheParachute = false;
                }
            }
            System.out.printf("%.0f, %.4f, %.4f, %.5f\n", t, hauteur, vitesse, accel);
            t++;
            q = Math.exp(-s * (t - t0));
            vitesse = (g/s) * (1 - q) + v0 * q;
            hauteur = h0 - (g/s) * (t - t0) - ((v0 - (g/s))/s) * (1 - q);
            accel = g - s * vitesse;
            if(vitesse >= speedOfSound && wentBeyondSoundSpeed){
                System.out.println("## Felix depasse la vitesse du son");
                wentBeyondSoundSpeed = false;
            }

            if(hauteur <= 0 && accel < 0.5 && gotMaxAcceleration){
                System.out.println("## Felix a atteint sa vitesse maximale");
                gotMaxAcceleration = false;
            }
        }
        clavier.close();
    }
}

/*
 * Test with the following values
 * 80   39000
 * 40   250
 * 102  345
 */
