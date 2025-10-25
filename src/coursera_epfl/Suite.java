package coursera_epfl;
import java.util.Scanner;

/**
 * This program generates and analyzes a numerical sequence within a user-defined interval.
 * The program asks the user to enter two integers: a start value (debut) and an end value (fin),
 * ensuring that both are positive and that fin is greater than or equal to debut.
 * For each integer in this interval, the program repeatedly applies the following rules until the value reaches 0:
 * - If the number is divisible by 3, add 4 to it.
 * - If it is not divisible by 3 but divisible by 4, divide it by 2.
 * - If it is divisible by neither 3 nor 4, subtract 1 from it.
 * The program counts how many operations are required for each number to reach 0 and displays the result in the form:
 * n -> number_of_steps
 * @author epfl & TS
 * @version 1.0
 */
public class Suite {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);

        int debut;
        do {
            System.out.print("de (>= 1) ? ");
            debut = clavier.nextInt();
        } while (debut < 1);

        int fin;
        do {
            System.out.print("a (>= " + debut + ") ? ");
            fin = clavier.nextInt();
        } while (fin < debut);

        for (int i = debut; i <= fin; i++) {
            int temp =  i;
            int count = 0;
            while(temp != 0){
                if(temp % 3 == 0){
                    temp += 4;
                }else if(temp % 4 ==0){
                    temp /= 2;
                }else{
                    temp -= 1;
                }
                count++;
            }
            System.out.println(i + " -> " + count);
        }
        clavier.close();
    }
}
