package intermediate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Reads a text file containing 4-dimensional vectors,
 * parses them into integer arrays, and computes the total Euclidean distance
 * between each consecutive pair of vectors.
 */
public class Distance {
    static void main() {
        String sequence = " ";

        try{
            sequence = Files.readString(Path.of("src/intermediate/i_text_files/vectors4d.txt"));
            //System.out.println("File content: " + sequence);
        } catch (IOException e){
            e.printStackTrace();
        }

        String[] parts = sequence.split("\n");
        List<int[]> vectorList = new ArrayList<>();

        //Create a list of 4d vectors
        for (int i = 0; i < parts.length; i++){
            parts[i] = parts[i].trim();
            if (parts[i].isEmpty()) continue;

            String[] numbers =  parts[i].split(",");
            int[] vector = new int[numbers.length];
            for (int j = 0; j < numbers.length; j++){
                vector[j] = Integer.parseInt(numbers[j]);
            }
            vectorList.add(vector);
        }

        //Display all vectors
        //showAllVectors(vectorList);

        //Calculate the distances
        //d(A,B) = sqrt((a1 - b1)^2 + (a2 - b2)^2 + (a3 - b3)^2 + (a4 - b4)^2)
        int globalDistance = 0;
        for (int i = 0; i < vectorList.size() - 1; i++) {
            double distance = computeDistance(vectorList.get(i), vectorList.get(i + 1));
            int roundedDistance = (int) Math.ceil(distance);
            //System.out.printf("Dist from vec %d to vec %d: %.2f%n", i, i + 1, distance);
            globalDistance += roundedDistance;
        }
        System.out.println("Global distance: " + globalDistance);

    }

    /**
     * Displays all integer vectors contained in the specified list.
     * @param list list of integer arrays to display; each array represents a vector
     */
    public static void showAllVectors(List<int[]> list) {
        for (int[] vector : list) {
            System.out.println(Arrays.toString(vector));
        }
    }

    /**
     * Computes the Euclidean distance between two integer vectors.
     * The distance is defined as the square root of the sum of the squared differences
     * between corresponding components of the two vectors:
     * distance = sqrt((v1[0] - v2[0])^2 + (v1[1] - v2[1])^2 + ... + (v1[n-1] - v2[n-1])^2)
     * @param v1 the first integer vector
     * @param v2 the second integer vector
     * @return the Euclidean distance between v1 and v2
     */
    public static double computeDistance(int[] v1, int[] v2) {
        double sum = 0;
        for (int i = 0; i < v1.length; i++) {
            sum += Math.pow(v1[i] - v2[i], 2);
        }
        return Math.sqrt(sum);
    }
}
