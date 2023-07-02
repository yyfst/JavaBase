package program.datastructure.tree.binarytree;

import program.datastructure.tree.model.TreeNode;

import java.util.*;

public class LeetCode_102 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(1, node1, node2);

        LeetCode_102 main = new LeetCode_102();
        List<List<Integer>> lists = main.levelOrder1(node3);
        System.out.println(lists);


    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<TreeNode, Integer> levelMap = new HashMap<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        levelMap.put(root, 1);
        int curLevel = 1;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            int level = levelMap.get(poll);
            if (level != curLevel) {
                curLevel++;
                result.add(list);
                list = new ArrayList<>();
            }

            list.add(poll.val);
            if (poll.left != null) {
                queue.offer(poll.left);
                levelMap.put(poll.left, level + 1);
            }

            if (poll.right != null) {
                queue.offer(poll.right);
                levelMap.put(poll.right, level + 1);
            }
        }
        if (list.size() > 0) {
            result.add(list);
        }
        return result;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }

        if (level >= result.size()) {
            result.add(new LinkedList<>());
        }

        result.get(level).add(root.val);
        dfs(root.left, result, level + 1);
        dfs(root.right, result, level + 1);
    }
}
