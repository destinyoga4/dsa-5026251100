import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        // Write your main code here
        BinarySearchTree bst = new BinarySearchTree();
        Scanner firstLine = new Scanner(read.nextLine());
        while (firstLine.hasNextInt()){
            bst.insert(firstLine.nextInt());
        }
        firstLine.close();

        System.out.print("PreOrder : ");
        bst.preOrder();

        System.out.print("Inorder : ");
        bst.inOrder();

        System.out.print("Post Order : ");
        bst.postOrder();

        int target = read.nextInt();
        System.out.print("Search " + target + " : " + bst.search(target));
        System.out.println();

        System.out.print("Minimum : " + bst.findMin());
        System.out.println();

        System.out.print("Maximum : " + bst.findMax());
        read.close();
    }
}