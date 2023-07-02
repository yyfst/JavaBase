package program.algorithm.search.dfs;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_94 {

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }

        inorder(treeNode.left, list);
        list.add(treeNode.val);
        inorder(treeNode.right, list);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
