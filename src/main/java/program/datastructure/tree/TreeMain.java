package program.datastructure.tree;

import program.datastructure.tree.model.BinaryTreeNode;

import java.util.Arrays;
import java.util.List;

public class TreeMain {
    public static void main(String[] args) {
        List<Character> characters = Arrays.asList(
                'A', 'B', 'C', 'D', 'E', 'F', 'G');

        BinaryTree binaryTreeImpl = new BinaryTreeImpl();
        BinaryTreeNode root = binaryTreeImpl.createBinaryTree(characters, 0);
//        binaryTreeImpl.preOrder(root);
        binaryTreeImpl.inOrder(root);
//        binaryTreeImpl.postOrder(root);
    }
}
