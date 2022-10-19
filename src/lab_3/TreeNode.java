package lab_3;

public class TreeNode {
    private Node root;

    public TreeNode(){
        root = null;
    }

    public Node findNodeByValue(int value) {
        Node currentNode = root;
        while (currentNode.getValue() != value) {
            if (value < currentNode.getValue()) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }

    public static Node findMinNode(Node node){
        if(node.left == null){
            return node;
        }else {
            return findMinNode(node.left);
        }
    }

//    6. Напишите алгоритм поиска «следующего» узла для заданного узла в бинарном дереве поиска. Считайте, что у каждого узла
//    есть ссылка на его родителя.
    public static Node findNextNode(Node node){
        if(node.right != null){
            return findMinNode(node.right);
        }
        Node parent = node.parent;
        while (parent != null && node == parent.right){
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;
        private Node parent;

        Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public void printNode(){
            System.out.println("Узел имеет значение: " + value);
        }

        @Override
        public String toString() {
            return "Node: " + "value=" + value + ", leftChild=" + left + ", rightChild=" + right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(10);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(7);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        Node next = findNextNode(root.right);
        if(next != null){
            next.printNode();
        }else {
            System.out.print("Следующего узела не существует");
        }
    }
}
