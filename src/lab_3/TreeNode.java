package lab_3;

public class TreeNode {
    private Node root;

    public TreeNode() {
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

    public static Node findMinNode(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return findMinNode(node.left);
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        Node currentNode = root;
        while (currentNode != null) {
            if (newNode.value > currentNode.value) {
                if (currentNode.right != null) {
                    currentNode = currentNode.right;
                }
                else {
                    newNode.parent = currentNode;
                    currentNode.right = newNode;
                    return;
                }
            }else {
                if(currentNode.left != null){
                    currentNode = currentNode.left;
                }else {
                    newNode.parent = currentNode;
                    currentNode.left = newNode;
                    return;
                }
            }
        }
    }

    //    6. Напишите алгоритм поиска «следующего» узла для заданного узла в бинарном дереве поиска. Считайте, что у каждого узла
//    есть ссылка на его родителя.
    public static Node findNextNode(Node node) {
        if (node.right != null) {
            return findMinNode(node.right);
        }
        Node parent = node.parent;
        while (parent != null && node != parent.left) {
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

        public void printNode() {
            System.out.println(value);
        }

    }

    public static void main(String[] args) {
        Node root = new Node(8);
        TreeNode treeNode = new TreeNode();
        treeNode.root = root;
        treeNode.insert(10);
        treeNode.insert(3);
        treeNode.insert(14);
        treeNode.insert(13);
        treeNode.insert(1);
        treeNode.insert(6);
        treeNode.insert(4);
        treeNode.insert(7);

//        root.parent = null;
//        root.right = new Node(10);
//        root.left = new Node(4);
//
//        root.right.parent = root;
//        root.left.parent = root;
//
//        root.right.right = new Node(14);
//        root.left.right = new Node(6);
//        root.left.left = new Node(2);
//
//        root.right.right.parent = root.right;
//        root.left.right.parent = root.left;
//        root.left.left.parent = root.left;
//
//        root.left.left.left = new Node(1);
//        root.right.right.left = new Node(13);
//        root.left.right.right = new Node(7);
//        root.left.right.left = new Node(5);
//
//        root.left.left.left.parent = root.left.left;
//        root.right.right.left.parent = root.right.right;
//        root.left.right.right.parent = root.left.right;
//        root.left.right.left.parent = root.left.right;

        Node currentNode = treeNode.findNodeByValue(6);
        Node next = findNextNode(currentNode);
        if (next != null) {
            System.out.println("Заданный узел: " + currentNode.value);
            System.out.println("Следующий узел: " + next.value);
        } else {
            System.out.print("Следующего узела не существует");
        }
    }
}
