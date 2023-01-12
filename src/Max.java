import java.util.ArrayList;

public class Max {
    //Задача о максимальной сумме подмассива состоит в нахождении максимальной суммы непрерывной
    // подпоследовательности в массиве или списке целых чисел

    public static int sequence(int[] arr) {
        int localSum = 0;
//        int globalSum = 0;
//        for(int el : arr){
//            localSum = Math.max(el, el + localSum);
//            globalSum = Math.max(localSum, globalSum);
//        }
        int globalSum = Integer.MIN_VALUE;
        for (Integer el: arr){
            localSum +=el;
            if(globalSum < localSum){
                globalSum = localSum;
            }
            if(localSum < 0){
                localSum = 0;
            }
        }
        return globalSum;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(sequence(arr));
    }
}
