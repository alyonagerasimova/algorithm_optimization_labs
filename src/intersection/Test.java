package intersection;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test {

    public static int[] getIntersection(int[] arr1, int[] arr2, Set<Integer> uniq) {
        for (int el : arr2) {
            uniq.add(el);
        }
        int[] res = new int[arr2.length];
        int i = 0;
        for (int el : arr1) {
            if (uniq.contains(el)) {
                res[i++] = el;
            }
        }
        return Arrays.copyOf(res, i);
    }

    public static void testSet(int[] arr1, int[] arr2) {
        int count = 36;
        Instant start = Instant.now();
        if (arr2.length > arr1.length) {
            for (int i = 0; i < count; i++) {
                int[] intersectArray = getIntersection(arr2, arr1, new HashSet<>(arr1.length));
//                System.out.println(Arrays.toString(intersectArray));
            }
        } else {
            for (int i = 0; i < count; i++) {
                int[] intersectArray = getIntersection(arr1, arr2, new HashSet<>(arr2.length));
//                System.out.println(Arrays.toString(intersectArray));
            }
        }
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toNanos();
        System.out.println("Временя выполнения, мс: " + elapsed / (1000000 * count));
    }

    public static void testMySet(int[] arr1, int[] arr2) {
        int count = 36;
        Instant start = Instant.now();
        if (arr2.length > arr1.length) {
            for (int i = 0; i < count; i++) {
                int[] intersectArray = getIntersection(arr2, arr1, new MySet<>(arr1.length));
//                System.out.println(Arrays.toString(intersectArray));
            }
        } else {
            for (int i = 0; i < count; i++) {
                int[] intersectArray = getIntersection(arr1, arr2, new MySet<>(arr2.length));
//                System.out.println(Arrays.toString(intersectArray));
            }
        }
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toNanos();
        System.out.println("Временя выполнения, мс: " + elapsed / (1000000 * count));
    }

    private static void fillArray(int[] array, int start) {
        for (int i = 0; i < array.length; i++) {
            array[i] = start + i;
        }
    }

    public static void main(String[] args) {
        int size = 1000000;
        int[] arr1 = new int[size];
        int[] arr2 = new int[size];
        fillArray(arr1, (int) (Math.random() * 100000));
        fillArray(arr2, (int) (Math.random() * 100000));
        System.out.println("HashSet");
        testSet(arr1, arr2);

        System.out.println("MySet");
        testMySet(arr1, arr2);
    }

}
