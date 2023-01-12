package sorts;

import org.w3c.dom.Node;

import java.util.*;

public class Main {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static boolean personIsSeller(String name) {
        return name.charAt(name.length() - 1) == 'm';
    }

//    public static boolean search(String name) {
//        ArrayDeque<String> searchQueue = new ArrayDeque<>();
//        HashMap<Node, LinkedList<Node>> graph = new HashMap<>();
////        graph["you"].add["alice","bob", "claire"] ;
////        graph("bob"]=("anuj","peggy"];
////        graph["alice"]=["peggy"];
////        graph["claire"]=["thom","jonny"];
////        graph["anuj"]=[];
////        graph["peggy"]=[];
////        graph["thom"]=[];
////        graph("jonny"]=[];
//        searchQueue.add(graph[name]);
//        ArrayList<String> searched = new ArrayList<>();
//        while (searchQueue.peek() != null) {
//            String person = searchQueue.poll();
//            if (!searched.contains(person)) {
//                if (personIsSeller(person)) {
//                    System.out.println(person + "is a mango seller");
//                    return true;
//                } else {
//                    searchQueue.add(graph[person]);
//                    searched.add(person);
//                }
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 4, 5, 1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
