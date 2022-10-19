package lab_2;

public class LinkedList {
    static LinkedListNode head;

    public static class LinkedListNode {
        public char data;
        public LinkedListNode next = null;

        public LinkedListNode(char data) {
            this.data = data;
        }
    }

    public void appendToTail(char d) {
        LinkedListNode end = new LinkedListNode(d);
        LinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = end;
    }

//    Часть 2. 3. Реализуйте алгоритм, удаляющий узел из середины односвязного списка (то есть узла, не являющегося ни начальным,
//    ни конечным – не обязательно находящегося точно в середине). Доступ предоставляется только к этому узлу. Пример:
//    Ввод: узел с из списка a->b->c->d->e->f Вывод: ничего не возвращается, но новый список имеет вид: a->b->d->e->f

//    public void deleteNode(char d) {
//        LinkedListNode n = head;
//        if (n.data == d) {
//            return;
//        }
//        while (n.next != null) {
//            if (n.next.data == d && n.next.next != null) {
//                n.next = n.next.next;
//                return;
//            }
//            n = n.next;
//        }
//    }

    public LinkedListNode getNode(char d) {
        LinkedListNode n = head;
        if (n.data == d) {
            return n;
        }
        while (n.next != null) {
            if (n.data == d ) {
               return n;
            }
            n = n.next;
        }
        return null;
    }

    public void deleteNode(LinkedListNode n) {
        if (n == null || n.next == null || n == head) {
            return;
        }
        n.data = n.next.data;
        n.next = n.next.next;
    }

    void printList(LinkedListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        head = new LinkedListNode('a');
        list.appendToTail('b');
        list.appendToTail('c');
        list.appendToTail('d');
        list.appendToTail('e');
        list.appendToTail('f');
        LinkedListNode node = list.getNode('c');
        list.deleteNode(node);
        list.printList(head);
    }
}
