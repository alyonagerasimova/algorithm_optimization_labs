package lab_2.tasks;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Stack;

public class StackMethods {

    public class MyStack<T> {
        private class StackNode<T> {
            private T data;
            private StackNode<T> next;

            public StackNode(T data) {
                this.data = data;
            }
        }

        private StackNode<T> top;

        public T pop() {    //извлечь элемент с вершины стека
            if (top == null) throw new EmptyStackException();
            T item = top.data;
            top = top.next;
            return item;
        }

        public void push(T item) { //добавить элемент на вершину стека
            StackNode<T> t = new StackNode<>(item);
            t.next = top;
            top = t;
        }

        public T peek() {
            if (top == null) throw new EmptyStackException();
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    public class Queue<T> {
        private class QueueNode<T> {
            private T data;
            private QueueNode<T> next;

            public QueueNode(T data) {
                this.data = data;
            }

            private QueueNode<T> first;
            private QueueNode<T> last;

            public void add(T item) {    // Добавление элемента в начало списка
                QueueNode<T> t = new QueueNode<>(item);
                if (last != null) {
                    last.next = t;
                }
                last = t;
                if (first == null) {
                    first = last;
                }
            }

            public T remove() {      // удаление первого элемента из списка
                if (first == null) throw new NoSuchElementException();
                T data = first.data;
                first = first.next;
                if (first == null) {
                    last = null;
                }
                return data;
            }

            public T peek() {      // вернуть элемент в начало очереди
                if (first == null) throw new EmptyStackException();
                return first.data;
            }

            public boolean isEmpty() {
                return first == null;
            }
        }
    }


    //    4. Напишите класс MyQueue, который реализует очередь с использованием двух стеков.
    public class MyQueue<T> {
        Stack stackNewest, stackOldest;

        public MyQueue() {
            stackNewest = new Stack();
            stackOldest = new Stack();
        }

        public int size() {
            return stackNewest.size() + stackOldest.size();
        }

        public void add(T value) {
            /* Все новейшие элементы находятся на вершине stackNewest */
            stackNewest.push(value);
        }

        /* Перемещение элементов из stackNewest в stackOldest . Обычно это
         * делается для выполнения операций с stackOldest . */
        private void shiftStacks() {
            if (stackOldest.isEmpty()) {
                while (!stackNewest.isEmpty()) {
                    stackOldest.push(stackNewest.pop());
                }
            }
        }

        public T peek() {
            shiftStacks(); // Перенести текущие элементы в stackOldest
            return (T) stackOldest.peek(); // Получить самый старый элемент .
        }

        public T remove() {
            shiftStacks(); // Перенести текущие элементы в stackOldest
            return (T) stackOldest.pop(); // Извлечь самый старый элемент .
        }
    }


    //3. Как известно, слишком высокая стопка тарелок может развалиться. Следовательно, в реальной жизни, когда высота
//    стопки превысила бы некоторое пороговое значение, мы начали бы складывать тарелки в новую стопку. Реализуйте структуру
//    данных SetOfStacks, имитирующую реальную ситуацию. Структура SetOfStack должна состоять из нескольких стеков,
//    новый стек создается, как только предыдущий достигнет порогового значения. Методы SetOfStacks.push() и SetOfStacks.рор()
//    должны вести себя так же, как при работе с одним стеком (то есть метод рор() должен возвращать те же значения, которые
//    бы он возвращал при использовании одного большого стека). Реализуйте функцию popAt(int index), которая осуществляет
//    операцию рор с заданным внутренним стеком.
//    class SetOfStacks {
//        ArrayList stacks = new ArrayList();
//        public int capacity;
//
//        public SetOfStacks(int capacity) {
//            this.capacity = capacity;
//        }
//
//        public Stack getLastStack() {
//            if (stacks.size() == 0) {
//                return null;
//            }
//            return stacks.get(stacks.size() - 1);
//        }
//
//        public void push(int v) {
//            Stack last = getLastStack();
//            if (last != null && !last.isFull()) { // add to last
//                last.push(v);
//            } else { // нужно создать новый стек
//                Stack stack = new Stack(capacity);
//                stack.push(v);
//                stacks.add(stack);
//            }
//        }
//
//        public int pop() {
//            Stack last = getLastStack();
//            if (last == null) throw new EmptyStackException();
//            int v = last.pop();
//            if (last.size == 0) {
//                stacks.remove(stacks.size() - 1);
//            }
//            return v;
//        }
//
//        public int popAt(int index) {
//            return leftShift(index, true);
//        }
//
//        public int leftShift(int index, boolean removeTop) {
//            Stack stack = stacks.get(index);
//            int removed_item;
//            if (removeTop) removed_item = stack.pop();
//            else removed_item = stack.removeBottom();
//            if (stack.isEmpty()) {
//                stacks.remove(index);
//            } else if (stacks.size() > index + 1) {
//                int v = leftShift(index + 1, false);
//                stack.push(v);
//            }
//            return removed_item;
//    }

}
