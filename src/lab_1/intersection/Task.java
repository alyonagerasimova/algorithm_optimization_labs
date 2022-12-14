package lab_1.intersection;

import java.awt.*;
import java.util.ArrayList;

public class Task {
        public static void main(String[] args) {
        long n = 412;
        int k = 2;

        int[] digits = new int[19];
        int idx = 0;
        while (n > 0) {
            digits[idx++] = (int) (n % 10);
            n /= 10;
        }

        long count = calc(digits, k, idx);
        count--;
        System.out.println(count);
    }

    private static long calc(int[] digits, int k, int idx) {
        long count = (digits[idx - 1] - 1) / k + 1;
        for (int j = idx - 2; j >= 0; j--) {
            count *= 9 / k + 1;
        }
        if (digits[idx - 1] % k == 0) {
            if (idx > 1) {
                count += calc(digits, k, idx - 1);
            } else {
                count++;
            }
        }
        return count;
    }

//    //----------------------------------------2------------------------------------------------------------//
//    static ArrayList<Point> current_path = new ArrayList<Point>();
//
////    public static boolean getPaths(int x, int y) {
////        Point p = new Point(x, y);
////        current_path.add(p);
////        if (0 == x && 0 == y) return true; // current_path
////        boolean success = false;
////        if (x >= 1 && is_free(x - 1, y)) { // Try right
////            success = getPaths(x - 1, y); // Free! Go right
////        }
////        if (!success && y >= 1 && is_free(x, y - 1)) { // Try down
////            success = getPaths(x, y - 1); // Free! Go down
////        }
////        if (!success) {
////            current_path.remove(p); // Wrong way!
////        }
////        return success;
////    }
//
//    //----------------------------------------4------------------------------------------------------------//
//    ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
//        ArrayList<ArrayList<Integer>> allsubsets;
//        if (set.size() == index) {
//            allsubsets = new ArrayList<ArrayList<Integer>>();
//            allsubsets.add(new ArrayList<Integer>()); // Empty set
//        } else {
//            allsubsets = getSubsets(set, index + 1);
//            int item = set.get(index);
//            ArrayList<ArrayList<Integer>> moresubsets =
//                    new ArrayList<ArrayList<Integer>>();
//            for (ArrayList<Integer> subset : allsubsets) {
//                ArrayList<Integer> newsubset = new ArrayList<Integer>();
//                newsubset.addAll(subset); //
//                newsubset.add(item);
//                moresubsets.add(newsubset);
//            }
//            allsubsets.addAll(moresubsets);
//        }
//        return allsubsets;
//    }
//
//    ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
//        ArrayList<ArrayList<Integer>> allsubsets =
//                new ArrayList<ArrayList<Integer>>();
//        int max = 1 << set.size();
//        for (int i = 0; i < max; i++) {
//            ArrayList<Integer> subset = new ArrayList<Integer>();
//            int k = i;
//            int index = 0;
//            while (k > 0) {
//                if ((k & 1) > 0) {
//                    subset.add(set.get(index));
//                }
//                k >>= 1;
//                index++;
//            }
//            allsubsets.add(subset);
//        }
//        return allsubsets;
//    }
//
//    //----------------------------------------5------------------------------------------------------------//
//    static int multiplication(int a, int b) {
////        if (b == 1 || b == 0)
////            return a;
////        else
////            return a + multiplication(a, --b);
//
//        if (b == 0){
//            return 0;
//        }
//        int z = 0;
//        if ((b&1) != 0){
//            z = a;
//        }
//        return z + (multiplication(a,b>>1) << 1);
//    }
//
//    //----------------------------------------6------------------------------------------------------------//
//    public static ArrayList<String> getPerms(String s) {
//        ArrayList<String> permutations = new ArrayList<>();
//        if (s == null) {
//            return null;
//        } else if (s.length() == 0) {
//            permutations.add("");
//            return permutations;
//        }
//        char first = s.charAt(0);
//        String remainder = s.substring(1);
//        ArrayList<String> words = getPerms(remainder);
//        for (String word : words) {
//            for (int j = 0; j <= word.length(); j++) {
//                permutations.add(insertCharAt(word, first, j));
//            }
//        }
//        return permutations;
//    }
//
//    public static String insertCharAt(String word, char c, int i) {
//        String start = word.substring(0, i);
//        String end = word.substring(i);
//        return start + c + end;
//    }
//
//
//    //----------------------------------------8------------------------------------------------------------//
//    public static void printPar(int l, int r, char[] str, int count) {
//        if (l < 0 || r < l) return;
//        if (l == 0 && r == 0) {
//            System.out.println(str);
//        } else {
//            if (l > 0) {
//                str[count] = '(';
//                printPar(l - 1, r, str, count + 1);
//            }
//            if (r > l) {
//                str[count] = ')';
//                printPar(l, r - 1, str, count + 1);
//            }
//        }
//    }
//
//    public static void printPar(int count) {
//        char[] str = new char[count * 2];
//        printPar(count, count, str, 0);
//    }
//
//    //---------------------------------------9------------------------------------------------------------//
//
//    enum Color {
//        Black, White, Red, Yellow, Green
//    }
//
//    static boolean paintFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor) {
//        if (x < 0 || x >= screen[0].length ||
//                y < 0 || y >= screen.length) {
//            return false;
//        }
//        if (screen[y][x] == ocolor) {
//            screen[y][x] = ncolor;
//            paintFill(screen, x - 1, y, ocolor, ncolor); // left
//            paintFill(screen, x + 1, y, ocolor, ncolor); // right
//            paintFill(screen, x, y - 1, ocolor, ncolor); // top
//            paintFill(screen, x, y + 1, ocolor, ncolor); // bottom
//        }
//        return true;
//    }
//
//    static boolean paintFill(Color[][] screen, int x, int y, Color ncolor) {
//        return paintFill(screen, x, y, screen[y][x], ncolor);
//    }
//
//    //-------------------------------------------10------------------------------------------------------------//
//    public static int makeChange(int n, int denom) {
//        int next_denom = 0;
//        switch (denom) {
//            case 25:
//                next_denom = 10;
//                break;
//            case 10:
//                next_denom = 5;
//                break;
//            case 5:
//                next_denom = 1;
//                break;
//            case 1:
//                return 1;
//        }
//        int ways = 0;
//        for (int i = 0; i * denom <= n; i++) {
//            ways += makeChange(n - i * denom, next_denom);
//        }
//        return ways;
//    }
//
//    //-------------------------------------------11------------------------------------------------------------//
//    static int[] columnForRow = new int[8];
//
//    protected static void printBoard() {
//        for (int i = 0; i < 8; i++) {
//            System.out.print(columnForRow[i] + ", ");
//        }
//        System.out.println("");
//    }
//
//    static boolean check(int row) {
//        for (int i = 0; i < row; i++) {
//            int diff = Math.abs(columnForRow[i] - columnForRow[row]);
//            if (diff == 0 || diff == row - i)
//                return false;
//        }
//        return true;
//    }
//
//    static void PlaceQueen(int row) {
//        if (row == 8) {
//            printBoard();
//            return;
//        }
//        for (int i = 0; i < 8; i++) {
//            columnForRow[row] = i;
//            if (check(row)) {
//                PlaceQueen(row + 1);
//            }
//        }
//    }
//
//
//    public static void main(String[] args) {
//        Color[][] screen = new Color[2][2];
//        int x = 0;
//        int y = 1;
//        Color ncolor = Color.Green;
//        paintFill(screen, x, y, ncolor);
//
//        printPar(3);
//
//        int n = 20;
//        System.out.println(makeChange(n, 25));
//
////        PlaceQueen(8);
//
//        System.out.println("\nTask 6: ");
//        getPerms("abc").forEach(System.out::println);
//
//        System.out.println("\nTask 5: ");
//        System.out.println(multiplication(87,100));
//    }
}

