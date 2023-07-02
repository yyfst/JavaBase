package program.datastructure.tree.binarytree;

import program.datastructure.tree.model.TreeNode;

public class LeetCode_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return checkSymmetric(root.left, root.right);
    }

    private boolean checkSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return checkSymmetric(p.left, q.right) && checkSymmetric(p.right, q.left);
    }
}
