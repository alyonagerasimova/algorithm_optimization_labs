package tasks;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class LinkedList {

    static LinkedListNode head;

    public static class LinkedListNode {
        public int data;
        public LinkedListNode next = null;

        public LinkedListNode(int data) {
            this.data = data;
        }
    }

    public void appendToTail(int d) {
        LinkedListNode end = new LinkedListNode(d);
        LinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = end;
    }

    public LinkedListNode deleteNode(LinkedListNode head, int d) {
        LinkedListNode n = head;
        if (n.data == d) {
            return head.next;
        }
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }

    public void deleteNode(LinkedListNode n, LinkedListNode start) {
        LinkedListNode temp = start;
        if (n == start) {
            start = null;
        } else {
            while (temp.next != n) {
                temp = temp.next;
            }
            temp.next = n.next;
        }
    }

    //    1. Напишите код для удаления дубликатов из несортированного связного списка. Как вы будете решать задачу, если
//    использовать временный буфер запрещено?
    public void deleteDuplicates(LinkedListNode head) {
        LinkedListNode ptr1, ptr2, dup = null;
        ptr1 = head;
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;
            while (ptr2.next != null) {
                if (ptr1.data == ptr2.next.data) {
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;
                } else {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }

    public void deleteDuplicatesUsingHashtable(LinkedListNode n) {
        Hashtable<Integer, Boolean> table = new Hashtable<>();
        LinkedListNode prev = null;
        while (n != null) {
            if (table.containsKey(n.data)) {
                prev.next = n.next;
            } else {
                table.put(n.data, true);
                prev = n;
            }
            n = n.next;
        }
    }

    public void deleteDuplicateUsingMap(LinkedListNode head) {
        LinkedListNode temp = head;
        Map<Integer, Boolean> hash_map = new HashMap<>();
        while (temp != null) {
            if (hash_map.get(temp.data) == null) {
                hash_map.put(temp.data, false);
            } else {
                deleteNode(temp, head);
            }
            temp = temp.next;
        }

    }

//    2. Реализуйте алгоритм для нахождения в односвязном списке k-го элемента с конца.
    public LinkedListNode findElementFromTheEnd(LinkedListNode head, int k){
        if(k <= 0) return null;

        LinkedListNode ptr1 = head;
        LinkedListNode ptr2 = head;
       for (int i =0; i < k- 1; i++){
           if(ptr2 == null) return null;
           ptr2 = ptr2.next;
       }
       if(ptr2 == null) return null;

       while (ptr2.next != null){
           ptr1 = ptr1.next;
           ptr2 = ptr2.next;
       }
       return ptr1;
    }


    void printList(LinkedListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        head = new LinkedListNode(1);
        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(3);
        list.appendToTail(3);
        list.appendToTail(4);
        list.appendToTail(4);
        list.printList(head);

//        #1
//        System.out.println("\nПосле удаления дубликатов");
//        list.deleteDuplicatesUsingHashtable(head);
//        list.deleteDuplicateUsingMap(head);
//        list.deleteDuplicates(head);
//        list.printList(head);

//        #2
        int k = 1;
        System.out.println("\n" + k + " элемент с конца: ");
        list.printList(list.findElementFromTheEnd(head, k));
    }
}
