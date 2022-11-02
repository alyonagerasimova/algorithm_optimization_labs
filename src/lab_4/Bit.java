package lab_4;

public class Bit {

//    1. Даны два 32-разрядных числа N и М и две позиции битов i и j. Напишите метод для вставки M в N так, чтобы число М
//    занимало позицию с бита j по бит i. Предполагается, что j и i имеют такие значения, что число М гарантированно
//    поместится в этот промежуток. Скажем, для М = 10011 можно считать, что j и i разделены как минимум 5 битами.
//    Комбинация вида j = 3 и i = 2 невозможна, так как число М не поместится между битом 3 и битом 2. Пример:
//    Ввод: N = 10000000000, М = 10011, i = 2, j = 6 Вывод: N = 10001001100.

    public static int insertion(String N, String M, int i, int j) {
        if ((j - i) + 1 >= M.length()) {
            int N_dec = toDec(N);
            int M_dec = toDec(M);

            int mask = ~(1 << i);
            for (int p = i; p<= j; p++){
                 mask = mask & ~(1 << p);
            }

            return (N_dec & mask) | (M_dec << i);
        }
        return 0;
    }

    public static int toDec(String bin) {
        char[] chars = bin.toCharArray();
        int result = 0;
        int mult = 1;
        for (int i = bin.length() - 1; i >= 0; i--) {
            if (chars[i] == '1') {
                result += mult;
            }
            mult *= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        String N = "10000000000";
//        int N = 1024;
        String M = "10011";
//        int M = 19;
        int i = 2;
        int j = 6;
        int result = insertion(N, M, i, j);
//        System.out.println("Dec: " + result);
        if(result != 0){
            System.out.println("Binary: " + Integer.toBinaryString(result));
        }
    }
}
