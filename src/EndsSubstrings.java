import java.util.*;

public class EndsSubstrings {

//    на вход подаётся массив строк, надо найти количестве строк, к которых есть окончание среди других строк
    public static int findEndsSub(String[] strings) {
        int result = 0;
        int countStrings = strings.length;

        for (int i = 0; i < countStrings - 1; i++) {
            for (int j = i + 1; j < countStrings; j++) {
                if (strings[i].endsWith(strings[j]) || strings[j].endsWith(strings[i])) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    public static int countOptimal(final String[] arr) {
        return keyCount("", List.of(arr));
    }

    public static int keyCount(final String key, final List<String> arr) {
        if (arr.size() <= 1) {
            return 0;
        }
        int count = 0;
        final Map<String, List<String>> tree = new HashMap<>();
        for (final String current : arr) {
            if (current.isEmpty()) {
                continue;
            }
            if (key.length() > 0 && current.length() <= key.length()) {
                if (arr.stream().filter(s -> s.equals(current)).count() > 1) {
                    count = arr.size();
                } else {
                    count = arr.size() - 1;
                }
                break;
            }
            final String k = current.substring(current.length() - key.length() - 1);
            if (!tree.containsKey(k)) {
                tree.put(k, new ArrayList<>());
            }
            tree.get(k).add(current);
        }
        for (final String k : tree.keySet()) {
            count += keyCount(k, tree.get(k));
        }
        return count;
    }

    public static int count(final String[] arr) {

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i].endsWith(arr[j])) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String[] strings = {"abc", "bc", "c", "ab"};
        System.out.println(findEndsSub(strings));
    }
}
