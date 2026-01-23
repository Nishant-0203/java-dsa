// https://leetcode.com/problems/sort-characters-by-frequency/

import java.util.*;

public class SortCharactersByFrequency {

    public static String frequencySort(String s) {

        TreeMap<Character, Integer> mp = new TreeMap<>();
        char[] arr = s.toCharArray();

        // Count frequency
        for (char ch : arr) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        String result = "";

        // Keep picking max frequency character
        while (result.length() != arr.length) {

            char maxChar = 0;
            int maxFreq = 0;

            for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
                if (entry.getValue() > maxFreq) {
                    maxFreq = entry.getValue();
                    maxChar = entry.getKey();
                }
            }

            result += String.valueOf(maxChar).repeat(maxFreq);
            mp.remove(maxChar);
        }

        return result;
    }

    // -----------------------
    // MAIN METHOD FOR TESTING
    // -----------------------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        System.out.println(frequencySort(s));

        sc.close();
    }
}
