package program.datastructure.tree;

import lombok.extern.slf4j.Slf4j;
import program.datastructure.tree.binarysearchtree.BinarySearchTree;
import program.datastructure.tree.binarysearchtree.impl.BinarySearchTreeImpl;
import program.datastructure.tree.binarytree.BinaryTree;
import program.datastructure.tree.binarytree.impl.BinaryTreeImpl;
import program.datastructure.tree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Slf4j
public class TreeMain {
    private static final BinaryTree binaryTreeImpl = new BinaryTreeImpl();

    private static final BinarySearchTree binarySearchTree = new BinarySearchTreeImpl();

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        BinaryTreeNode insert = null;
        int[] array = {20, 61, 7, 109, 30, 9, 41, 55};
        for (int i = 0; i < array.length; i++) {
            insert = binarySearchTree.insert(insert, array[i]);
        }
        binaryTreeImpl.inOrder(insert);

        BinaryTreeNode remove = binarySearchTree.remove(insert, array[1]);
        binaryTreeImpl.inOrder(remove);

    }
}
