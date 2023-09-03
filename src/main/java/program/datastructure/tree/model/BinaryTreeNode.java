package program.datastructure.tree.model;

/**
 * 二叉树数据结构
 */
public class BinaryTreeNode {
    public int node;

    public BinaryTreeNode leftNode;

    public BinaryTreeNode rightNode;

    public BinaryTreeNode(int node) {
        this.node = node;
    }



    public BinaryTreeNode(int node, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
        this.node = node;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}

