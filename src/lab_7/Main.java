package lab_7;

public class Main {

//    10. Дано неограниченное количество монет достоинством 25, 10, 5 и 1 копейка. Напишите код, определяющий
//    количество способов представления n копеек.

    public static int numOfSubmissions(int n, int denomination) {
        int nextDenomination = 0;
        switch (denomination) {
            case 25:
                nextDenomination = 10;
                break;
            case 10:
                nextDenomination = 5;
                break;
            case 5:
                nextDenomination = 1;
                break;
            case 1:
                return 1;
        }
        int num = 0;
        for (int i = 0; i * denomination <= n; i++) {
            num += numOfSubmissions(n - i * denomination, nextDenomination);
        }
        return num;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Количество способов представления " + n + " копеек: ");
        System.out.println(numOfSubmissions(n, 25));
    }
}
