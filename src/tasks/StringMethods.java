package tasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringMethods {

//  1. Реализуйте алгоритм, определяющий, все ли символы в строке встречаются только один раз.
//  А если при этом запрещено использование дополнительных структур данных?
    public static boolean isRepeat(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j) && i != j) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isRepeat2(String str) {
        Set<Character> set = new HashSet<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        return set.size() != str.length();
    }

    public static boolean isRepeat3(String str) {
        str = sortString(str);
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    public static String sortString(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        string = new String(chars);
        return string;
    }

//    2. Для двух строк напишите метод, определяющий, является ли одна строка перестановкой другой.
    public static boolean isTransposition(String str1, String str2){
        if (str1.length() != str2.length()) {
            return false;
        }
        return sortString(str1).equals(sortString(str2));
    }

//    3. Напишите метод, заменяющий все пробелы в строке символами '%20'. Можете считать, что длина строки позволяет
//    сохранить дополнительные символы, а фактическая длина строки известна заранее.
//    (Примечание: при реализации метода на Java для выполнения операции «на месте» используйте символьный массив.)
//    Пример:
//    Ввод: "Mr John Smith "
//    Вывод: "Mr%20John%20Smith"
    public static String replaceSpace(String str){
        String[] words= str.split(" ");
        return String.join("%20", words);
    }

    public static String replace(String s) {
        char chars[] = s.trim().toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char aChar : chars) {
            if (aChar == 32)
                sb.append("%20");
            else
                sb.append(aChar);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String str = "avbygkloppp";
        String subStr = "pppoavbygkl";
        String text = "Mr John Smith ";

//        #1
//        System.out.println(isRepeat3(str));

//        #2
//        System.out.println(isTransposition(str,subStr));

//        #3
//        System.out.println(replace(text));
    }
}
