package program.datastructure.tree.binarytree;

import program.datastructure.tree.model.BinaryTreeNode;

import java.util.List;

public interface BinaryTree {
    BinaryTreeNode createBinaryTree(List<Integer> nodes, int index);

    /**
     * 先序遍历
     *
     * @param binaryTree 二叉树
     */
    void preOrder(BinaryTreeNode  binaryTree);

    /**
     * 中序遍历(深度遍历)
     *
     * @param binaryTree 二叉树
     */
    void inOrder(BinaryTreeNode  binaryTree);

    /**
     * 后序遍历
     *
     * @param binaryTree 二叉树
     */
    void postOrder(BinaryTreeNode  binaryTree);

    /**
     * 层序遍历(宽度遍历)
     *
     * @param binaryTree 二叉树
     */
    void levelOrder(BinaryTreeNode binaryTree);

    /**
     * 二叉树最大宽度
     *
     * @param binaryTree 二叉树
     * @return 最大宽度
     */
    int maxBinaryTreeBreadth(BinaryTreeNode  binaryTree);

    /**
     * 判断二叉树是否为相同的树
     *
     * @param tree1 二叉树
     * @param tree2 二叉树
     * @return 是否为相同的树
     */
    boolean isSameTree(BinaryTreeNode  tree1, BinaryTreeNode tree2);

    /**
     * 判断二叉树是否轴对称
     *
     * @param binaryTree 二叉树
     * @return 是否轴对称
     */
    boolean isSymmetric(BinaryTreeNode  binaryTree);

    int maxDepth(BinaryTreeNode  binaryTreeNode);

    BinaryTreeNode  buildTreeByPreAndInOrder(List<Integer> preOrder, List<Integer> inOrder);

    BinaryTreeNode buildTreeByInAndPostOrder(List<Integer> inOrder, List<Integer> postOrder);
}
