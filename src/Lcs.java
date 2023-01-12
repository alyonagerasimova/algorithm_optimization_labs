import java.util.Arrays;

class Lcs {
    //Напишите функцию lcs, которая принимает две строки и возвращает их самую длинную общую подпоследовательность в виде строки.
    static String lcs(String a, String b) {
        int m = a.length();
        int n = b.length();
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int[][] subseq = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    subseq[i][j] = 0;
                } else if (aChars[i - 1] == bChars[j - 1]) {
                    subseq[i][j] = subseq[i - 1][j - 1] + 1;
                } else {
                    subseq[i][j] = Math.max(subseq[i - 1][j], subseq[i][j - 1]);
                }
            }
        }
        int index = subseq[m][n];
        var sb = new StringBuilder(index);
        int i = m;
        int j = n;
        while (i > 0 && j > 0){
            if(aChars[i-1] == bChars[j-1]){
                sb.append(aChars[i-1]);
                i--;
                j--;
            }
            else if(subseq[i-1][j] > subseq[i][j-1]){
                i--;
            }
            else {
                j--;
            }
        }
        return sb.reverse().toString();
}

    public static void main(String[] args) {
        System.out.println(lcs("abcdef", "acf"));
        System.out.println(lcs("anothertest", "notatest"));
        System.out.println(lcs("132535365", "123456789"));
        System.out.println(lcs("nothardlythefinaltest", "zzzfinallyzzz"));
    }
}