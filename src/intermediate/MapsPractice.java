package intermediate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapsPractice {

    static void main() {
        countCharactersInFile();
        shortestSequence();
    }

    /**
     * Reads the content of the specified text file and counts the
     * occurrences of each character in the file.
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static void countCharactersInFile(){
        String sequence = " ";

        try{
            sequence = Files.readString(Path.of("src/intermediate/i_text_files/unique-letters.txt"));
            //System.out.println("File content: " + sequence);
        } catch (IOException e){
            e.printStackTrace();
        }
        sequence = sequence.trim();

        Map<Character, Integer> numbers = new HashMap<>();

        for (char c : sequence.toCharArray()) {
            // If map already contains the character, increment its count
            if (numbers.containsKey(c)) {
                numbers.put(c, numbers.get(c) + 1);
            } else {
                numbers.put(c, 1);
            }
        }

        // Print the map
        System.out.println("\nNumber of each character in the text file: ");
        for (Map.Entry<Character, Integer> entry : numbers.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
        System.out.println();
    }

    /**
     * Finds and prints the shortest contiguous substring of a sequence of musical notes
     * that contains all seven distinct notes A, B, C, D, E, F, and G at least once.
     * Uses a sliding window algorithm
     */
    public static void shortestSequence(){
        String sequence = " ";
        try{
            sequence = Files.readString(Path.of("src/intermediate/i_text_files/notes.txt"));
            //System.out.println("File content: " + sequence);
        } catch (IOException e){
            e.printStackTrace();
        }
        sequence = sequence.trim();

        // Set of the 7 distinct notes we need to find in the substring
        Set<Character> notes = Set.of('A', 'B', 'C', 'D', 'E', 'F', 'G');
        // Map that counts how many of each note are in the current substring we’re currently examining
        Map<Character, Integer> notesCount = new HashMap<>();

        int start = 0; // left index of the current substring
        int minStart = 0; // left index of the shortest valid substring found so far.
        int minLength = sequence.length(); // length of the shortest valid substring found so far.
        int uniqueCount = 0; // number of distinct notes currently in a substring

        // main loop: we move the right end of the substring from left to right, over the string.
        for (int end = 0; end < sequence.length(); end++) {
            char c = sequence.charAt(end);

            // Only care about characters that are one of the 7 notes.
            // notesCounts.put(...) increments the count for this note.
            // If this is the first time this note appears in the window (notesCounts.get(c) == 1),
            // increment uniqueCount.
            if (notes.contains(c)) {
                notesCount.put(c, notesCount.getOrDefault(c, 0) + 1);
                if (notesCount.get(c) == 1){
                    uniqueCount++;
                }
            }

            //Now that our substring contains all 7 notes, we try to make it smaller from the left.
            while (uniqueCount == 7 && start <= end) {
                // Compute current substring length
                // If this substring is smaller than the smallest found so far, update minLength and minStart.
                int substringLength = end - start + 1;
                if (substringLength < minLength) {
                    minLength = substringLength;
                    minStart = start;
                }

                char leftChar = sequence.charAt(start);
                if (notes.contains(leftChar)) {
                    notesCount.put(leftChar, notesCount.get(leftChar) - 1);
                    if (notesCount.get(leftChar) == 0) uniqueCount--;
                }
                start++;
            }
        }

        String result = (minLength == Integer.MAX_VALUE)
                ? "No complete sequence found"
                : sequence.substring(minStart, minStart + minLength);

        System.out.println("Shortest sequence: " + result); // EDGCFAB
        System.out.println();
    }
}
