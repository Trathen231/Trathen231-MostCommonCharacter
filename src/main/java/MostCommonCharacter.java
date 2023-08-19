import java.util.HashMap;
import java.util.Map;

public class MostCommonCharacter {
    /**
     * Find the most common character in str.
     * You could use a HashMap that maps a Character key to an Int value to represent how many times a Character has
     * been spotted.
     * @param str A String.
     * @return the most common character within str.
     */
    public char recurringChar(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty.");
        }

        Map<Character, Integer> charCountMap = new HashMap<>();
        
        // Count occurrences of each character
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        
        char mostCommonChar = ' ';
        int maxCount = 0;

        // Find the character with the highest count
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommonChar = entry.getKey();
            }
        }

        return mostCommonChar;
    }

    public static void main(String[] args) {
        MostCommonCharacter mostCommonCharFinder = new MostCommonCharacter();

        String input = "hello world";
        char mostCommonChar = mostCommonCharFinder.recurringChar(input);

        System.out.println("The most common character in \"" + input + "\" is: " + mostCommonChar);
    }
}
