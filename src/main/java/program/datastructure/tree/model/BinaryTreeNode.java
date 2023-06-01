package program.datastructure.tree.model;

/**
 * 二叉树数据结构
 */
public class BinaryTreeNode {
    private char node;

    private BinaryTreeNode leftNode;

    private BinaryTreeNode rightNode;

    public BinaryTreeNode(char node) {
        this.node = node;
    }

    public BinaryTreeNode(char node, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
        this.node = node;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public char getNode() {
        return node;
    }

    public void setNode(char node) {
        this.node = node;
    }

    public BinaryTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
