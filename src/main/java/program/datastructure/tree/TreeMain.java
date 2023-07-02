package program.datastructure.tree;

import program.datastructure.tree.binarytree.BinaryTree;
import program.datastructure.tree.binarytree.impl.BinaryTreeImpl;
import program.datastructure.tree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeMain {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        System.out.println(list.get(0));
        List<Character> characters = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F');

        BinaryTree binaryTreeImpl = new BinaryTreeImpl();
        BinaryTreeNode root = binaryTreeImpl.createBinaryTree(characters, 0);
        binaryTreeImpl.preOrder(root);
        binaryTreeImpl.inOrder(root);
        binaryTreeImpl.postOrder(root);
        binaryTreeImpl.levelOrder(root);
        binaryTreeImpl.maxBinaryTreeBreadth(root);
        System.out.println(binaryTreeImpl.isSameTree(root, root));
    }
}
