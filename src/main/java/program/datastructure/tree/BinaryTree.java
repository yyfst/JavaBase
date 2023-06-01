package program.datastructure.tree;

import program.datastructure.tree.model.BinaryTreeNode;

import java.util.List;

public interface BinaryTree {
    BinaryTreeNode createBinaryTree(List<Character> nodes, int index);

    void preOrder(BinaryTreeNode binaryTree);

    void inOrder(BinaryTreeNode binaryTree);

    void postOrder(BinaryTreeNode binaryTree);

    void levelOrder(BinaryTreeNode binaryTree);
}
