package intermediate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class MapsPractice {

    public static void main() {
        countCharactersInFile();
    }

    /**
     * Reads the content of the specified text file and counts the
     * occurrences of each character in the file.
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static void countCharactersInFile(){
        String sequence = " ";

        try{
            sequence = Files.readString(Path.of("src/intermediate/text_files/CodeSequence.txt"));
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
    }
}
