import javax.swing.*;

public class TestBST {
    public static void main(String[] args) {
        String title =  "Nathaniel P. Rijndorp";
        BST bst = new BST();
        String[] list = {"Add","Delete","Search","Traversal","Exit"};
        int choice = 0;
        // Nathaniel P. Rijndorp
        do {
            choice = JOptionPane.showOptionDialog(null, "Select Action.", title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, list, list[0]);
            switch (choice) {
                case 0:
                    long start = System.nanoTime();
                    int add = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number.", title, JOptionPane.INFORMATION_MESSAGE));
                    if (!bst.search(add)) {
                        bst.add(add);
                        JOptionPane.showMessageDialog(null, "Number " + add + " has been added.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Number is already present.");
                    }
                    System.out.println(title + "\nAdd Start Time : " + start +
                            "\nEnd Time : " + System.nanoTime() +
                            "\nTotal Time : " + (start+System.nanoTime()));
                    break;
                case 1:
                    start = System.nanoTime();
                    int delete = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number", title, JOptionPane.INFORMATION_MESSAGE));
                    if (bst.search(delete)) {
                        JOptionPane.showMessageDialog(null, "Number " + delete + " has been deleted.");
                        bst.delete(delete);
                    } else {
                        JOptionPane.showMessageDialog(null, "Number does not exist.");
                    }
                    System.out.println(title + "\nDelete Start Time : " + start +
                            "\nEnd Time : " + System.nanoTime() +
                            "\nTotal Time : " + (start+System.nanoTime()));
                    break;
                case 2:
                    start = System.nanoTime();
                    int search = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number", title, JOptionPane.INFORMATION_MESSAGE));
                    if (bst.search(search)) {
                        JOptionPane.showMessageDialog(null, "Number " + search + " is present.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Number " + search + " does not exist.");
                    }
                    System.out.println(title + "\nSearch Start Time : " + start +
                            "\nEnd Time : " + System.nanoTime() +
                            "\nTotal Time : " + (start+System.nanoTime()));
                    break;
                case 3:
                    start = System.nanoTime();
                    JOptionPane.showMessageDialog(null, "Inorder traversal: " + bst.printInOrder() +
                            "\nPreorder traversal: " + bst.printPreOrder() +
                            "\nPostorder traversal: " + bst.printPostOrder(),
                            title, JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(title + "\nTraversal Start Time : " + start +
                            "\nEnd Time : " + System.nanoTime() +
                            "\nTotal Time : " + (start+System.nanoTime()));
                    break;
            }

        } while (choice != 4);



    }
}
