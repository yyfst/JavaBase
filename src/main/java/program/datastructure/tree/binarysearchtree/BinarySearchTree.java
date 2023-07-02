package program.datastructure.tree.binarysearchtree;

import program.datastructure.tree.model.BinaryTreeNode;

public interface BinarySearchTree {
    BinaryTreeNode insert(BinaryTreeNode root, char key);

    BinaryTreeNode remove(BinaryTreeNode root, char key);

    void clear(BinaryTreeNode root, char key);
}
