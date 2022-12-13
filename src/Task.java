public class Task {
    //    public static void main(String[] args) {
//        long n = 412;
//        int k = 2;
//
//        int[] digits = new int[19];
//        int idx = 0;
//        while (n > 0) {
//            digits[idx++] = (int) (n % 10);
//            n /= 10;
//        }
//
//        long count = calc(digits, k, idx);
//        count--;
//        System.out.println(count);
//    }
//
//    private static long calc(int[] digits, int k, int idx) {
//        long count = (digits[idx - 1] - 1) / k + 1;
//        for (int j = idx - 2; j >= 0; j--) {
//            count *= 9 / k + 1;
//        }
//        if (digits[idx - 1] % k == 0) {
//            if (idx > 1) {
//                count += calc(digits, k, idx - 1);
//            } else {
//                count++;
//            }
//        }
//        return count;
//    }

    //----------------------------------------8------------------------------------------------------------//
    public static void printPar(int l, int r, char[] str, int count) {
        if (l < 0 || r < l) return; // invalid state
        if (l == 0 && r == 0) {
            System.out.println(str); // found one, so print it
        } else {
            if (l > 0) { // try a left paren, if there are some available
                str[count] = '(';
                printPar(l - 1, r, str, count + 1);
            }
            if (r > l) { // try a right paren, if there’s a matching left
                str[count] = ')';
                printPar(l, r - 1, str, count + 1);
            }
        }
    }

    //---------------------------------------9------------------------------------------------------------//
    public static void printPar(int count) {
        char[] str = new char[count * 2];
        printPar(count, count, str, 0);
    }

    enum Color {
        Black, White, Red, Yellow, Green
    }

    static boolean paintFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor) {
        if (x < 0 || x >= screen[0].length ||
                y < 0 || y >= screen.length) {
            return false;
        }
        if (screen[y][x] == ocolor) {
            screen[y][x] = ncolor;
            paintFill(screen, x - 1, y, ocolor, ncolor); // left
            paintFill(screen, x + 1, y, ocolor, ncolor); // right
            paintFill(screen, x, y - 1, ocolor, ncolor); // top
            paintFill(screen, x, y + 1, ocolor, ncolor); // bottom
        }
        return true;
    }

    static boolean paintFill(Color[][] screen, int x, int y, Color ncolor) {
        return paintFill(screen, x, y, screen[y][x], ncolor);
    }

    //-------------------------------------------10------------------------------------------------------------//
    public static int makeChange(int n, int denom) {
        int next_denom = 0;
        switch (denom) {
            case 25:
                next_denom = 10;
                break;
            case 10:
                next_denom = 5;
                break;
            case 5:
                next_denom = 1;
                break;
            case 1:
                return 1;
        }
        int ways = 0;
        for (int i = 0; i * denom <= n; i++) {
            ways += makeChange(n - i * denom, next_denom);
        }
        return ways;
    }

    //-------------------------------------------11------------------------------------------------------------//
    static int[] columnForRow = new int[8];

    protected static void printBoard() {
        for (int i = 0; i < 8; i++) {
            System.out.print(columnForRow[i] + ", ");
        }
        System.out.println("");
    }

    static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            int diff = Math.abs(columnForRow[i] - columnForRow[row]);
            if (diff == 0 || diff == row - i)
                return false;
        }
        return true;
    }

    static void PlaceQueen(int row) {
        if (row == 8) {
            printBoard();
            return;
        }
        for (int i = 0; i < 8; i++) {
            columnForRow[row] = i;
            if (check(row)) {
                PlaceQueen(row + 1);
            }
        }
    }


    public static void main(String[] args) {
        Color[][] screen = new Color[2][2];
        int x = 0;
        int y = 1;
        Color ncolor = Color.Green;
        paintFill(screen, x, y, ncolor);

        printPar(3);

        int n = 20;
        System.out.println(makeChange(n, 25));

        PlaceQueen(8);
    }
}

