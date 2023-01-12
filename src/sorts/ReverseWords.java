package sorts;

import java.util.Arrays;

public class ReverseWords {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        int len = words.length;
        StringBuilder reverseWords = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            if (words[i] != "") {
                reverseWords.append(words[i]).append(" ");
            }
        }
        return reverseWords.toString().trim();
    }

    public static void main(String[] args) {
        String s = "a good    example";
        System.out.println(reverseWords(s));
    }
}
