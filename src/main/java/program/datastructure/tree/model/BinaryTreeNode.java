package program.datastructure.tree.model;

/**
 * 二叉树数据结构
 */
public class BinaryTreeNode {
    public char node;

    public BinaryTreeNode leftNode;

    public BinaryTreeNode rightNode;

    public BinaryTreeNode(char node) {
        this.node = node;
    }

    public BinaryTreeNode(char node, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
        this.node = node;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}

