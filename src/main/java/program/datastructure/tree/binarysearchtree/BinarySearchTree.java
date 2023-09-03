package program.datastructure.tree.binarysearchtree;

import program.datastructure.tree.model.BinaryTreeNode;

public interface BinarySearchTree {
    BinaryTreeNode insert(BinaryTreeNode root, int key);

    BinaryTreeNode remove(BinaryTreeNode root, int key);

    void clear(BinaryTreeNode root, int key);

    BinaryTreeNode findMin(BinaryTreeNode root);
}
