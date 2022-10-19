package lab_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task1 {
//    Часть 1. 1. Реализуйте алгоритм, определяющий, все ли символы в строке встречаются только один раз. А если при этом
//    запрещено использование дополнительных структур данных?

    public static boolean isRepeatSymbol(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j) && i != j) {
                    System.out.println("repeat");
                    return true;
                }
            }
        }
        System.out.println("no repeat");
        return false;
    }

    public static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static boolean isRepeatSymbolWithSort(String str) {
        str = sortString(str);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                System.out.println("repeat");
                return true;
            }
        }
        return false;
    }

    public static boolean isRepeatSymbolWithSet(String str) {
        Set<Character> set = new HashSet<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        return str.length() != set.size();
    }

    public static void main(String[] args) {
        String str = "aaaabbmkc";
        System.out.println("Исходная строка: " + str);
        System.out.println("Double cycle: ");
        System.out.println(isRepeatSymbol(str));
        System.out.println("With sort: ");
        System.out.println(isRepeatSymbolWithSort(str));
        System.out.println("With Set: ");
        System.out.println(isRepeatSymbolWithSet(str));
    }
}
