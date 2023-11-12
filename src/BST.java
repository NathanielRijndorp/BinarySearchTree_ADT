public class BST extends BinaryTree {
    public static void main(String[] args) {

    }

    public BST() {
        super(); //super is a keyword used to call a parent
    } //end of constructor

    /**
     * Method wrapper for inserting a node
     *
     * @param data
     */
    public void add(int data) {
        setRoot(insert(getRoot(), data));
    } //end of method

    /**
     * Recursive method (helper) to insert a node into the BST
     *
     * @param node
     * @param data
     * @return
     */
    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.getData()) {
            node.setLeft(insert(node.getLeft(), data));
        } else if (data > node.getData()) {
            node.setRight(insert(node.getRight(), data));
        }
        return node;
    } //end of method

    /**
     * Method to search for a value in the BST=/
     * public boolean search (int data) { return searchNode(getRoot(), data);
     * }
     * /**Recursive method to search for a value in the BST
     *
     * @param node
     * @param data
     * @return
     */
    private boolean searchNode(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (data == node.getData()) {
            return true;
        } else if (data < node.getData()) {
            return searchNode(node.getLeft(), data);
        } else {
            return searchNode(node.getRight(), data);
        } //end of if
    } //end of method

    public int min() {
        Node minNode = findMin(getRoot());
        return (minNode != null) ? minNode.getData() : -1;
    } //end of method

    private Node findMin(Node node) {
        if (node == null || node.getLeft() == null) {
            return node;
        }
        return findMin(node.getLeft());
    }//end of method

    public int max() {
        Node maxNode = findMax(getRoot());
        return (maxNode != null) ? maxNode.getData() : -1;
    }//end of method

    private Node findMax(Node node) {
        if (node == null || node.getRight() == null) {
            return node;
        }
        return findMax(node.getRight());
    } //end of method

    public int successor(int data) {
        int value = -1;
//findNode from BinaryTree ADT
        Node node = findNode(getRoot(), data);
        if (isEmpty()) {
            System.out.println("Node is empty!");
        } else if (!search(data)) {
            System.out.println(data + " is NOT found!");
        } else if (node != null && node.getRight() != null) {
            value = findMin(node.getRight()).getData();
        } else {
            Node successor = findSuccessor(getRoot(), data);
            value = (successor != null) ? successor.getData() : -1;
        } //end of if return value;
        return value;
    } //end of method

    private Node findSuccessor(Node root, int data) {
        Node current = findNode(root, data); //Find the node with the given key
        Node successor = null;
        Node ancestor = root;

        while (ancestor != current) {

            if (current.getData() < ancestor.getData()) {
                successor = ancestor;
                ancestor = ancestor.getLeft();
            } else {
                ancestor = ancestor.getRight();
            }
        }
        return successor;
    }

    public int predecessor(int data) {
        int value = -1;
        Node node = findNode(getRoot(), data);
        if (isEmpty()) {
            System.out.println("Node is empty!");
        } else if (!search(data)) {
            System.out.println(data + " is NOT found!");
        } else if (node != null && node.getLeft() != null) {
            value = findMax(node.getLeft()).getData();
        } else {
            Node predecessor = findPredecessor(getRoot(), data);
            value = (predecessor != null) ? predecessor.getData() : -1;
        } //end of if
        return value;
    } //end of method

    private Node findPredecessor(Node root, int data) {
        Node current = findNode(root, data); // Find the node with the given key
        Node predecessor = null;
        Node ancestor = root;
// Traverse the tree to find the predecessor
        while (ancestor != current) {
// If the current node is less than the key,
// update the predecessor and move to the right subtree
            if (current.getData() > ancestor.getData()) {
                predecessor = ancestor;
                ancestor = ancestor.getRight();
            } else {
                ancestor = ancestor.getLeft();
            }
        } //end of if
        return predecessor;
    } //end of while return predecessor;

    public void delete(int data) {
        if (isEmpty()) {
            System.out.println("Tree is empty!");
        } else if (!search(data)) {
            System.out.println(data + " is NOT found");
        } else {
            setRoot(deleteNode(getRoot(), data));
        } //end of if
    } //end of method

    private Node deleteNode(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data < node.getData()) {
            node.setLeft(deleteNode(node.getLeft(), data));
        } else if (data > node.getData()) {
            node.setRight(deleteNode(node.getRight(), data));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }
            Node minNode = findMin(node.getRight());
            node.setData(minNode.getData());
            node.setRight(deleteNode(node.getRight(), minNode.getData()));
        }
        return node;
    }

}
