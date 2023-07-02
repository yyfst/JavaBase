package program.datastructure.tree.binarytree;

import program.datastructure.tree.model.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LeetCode_104 {
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Map<TreeNode, Integer> levelMap = new HashMap<>();
        levelMap.put(root, 1);
        int cur = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            int level = levelMap.get(poll);
            if (level != cur) {
                cur++;
            }
            if (poll.left != null) {
                queue.offer(poll.left);
                levelMap.put(poll.left, level + 1);
            }

            if (poll.right != null) {
                queue.offer(poll.right);
                levelMap.put(poll.right, level + 1);
            }
        }
        return cur;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left, right);
    }


}
