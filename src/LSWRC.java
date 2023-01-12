import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LSWRC {
    //    Дана строка s, найдите длину самой длинной подстрока без повторяющихся символов.
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int res = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (checkRepetition(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    static boolean checkRepetition(String s, int start, int end) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            if (set.contains(chars[i])) {
                return false;
            }
            set.add(chars[i]);
        }
        return true;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
