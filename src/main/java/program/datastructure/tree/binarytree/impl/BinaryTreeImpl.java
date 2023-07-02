package program.datastructure.tree.binarytree.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import program.datastructure.tree.binarytree.BinaryTree;
import program.datastructure.tree.model.BinaryTreeNode;

import java.util.*;

@Slf4j
public class BinaryTreeImpl implements BinaryTree {
    @Override
    public BinaryTreeNode createBinaryTree(List<Character> nodes, int index) {
        if (CollectionUtils.isEmpty(nodes) || index >= nodes.size()) {
            return null;
        }

        BinaryTreeNode node = new BinaryTreeNode(nodes.get(index));
        node.leftNode = createBinaryTree(nodes, 2 * index + 1);
        node.rightNode = createBinaryTree(nodes, 2 * index + 2);
        return node;
    }

    @Override
    public void preOrder(BinaryTreeNode binaryTree) {
        log.info("pre order by recursion...");
        // 递归实现
//        preOrderByRecursion(binaryTree);

        log.info("pre order by stack...");
        // 非递归实现
        preOrderByNonRecursion(binaryTree);
    }

    private void preOrderByRecursion(BinaryTreeNode binaryTree) {
        if (binaryTree == null) {
            return;
        }

        log.info("binary tree node: {}", binaryTree.node);
        preOrderByRecursion(binaryTree.leftNode);
        preOrderByRecursion(binaryTree.leftNode);
    }

    private void preOrderByNonRecursion(BinaryTreeNode binaryTree) {
        if (binaryTree == null) {
            return;
        }

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(binaryTree);
        while (!stack.isEmpty()) {
            BinaryTreeNode pop = stack.pop();
            log.info("preOrder by non-recursion node: {}", pop.node);

            if (pop.leftNode != null) {
                stack.push(pop.leftNode);
            }

            if (pop.leftNode != null) {
                stack.push(pop.leftNode);
            }
        }
    }

    @Override
    public void inOrder(BinaryTreeNode binaryTree) {
        log.info("in order by recursion...");
        inOrderByRecursion(binaryTree);

        log.info("in order by stack...");
        inOrderByNonRecursion(binaryTree);
    }

    private void inOrderByRecursion(BinaryTreeNode binaryTree) {
        if (binaryTree == null) {
            return;
        }

        inOrderByRecursion(binaryTree.leftNode);
        log.info("binary tree node: {}", binaryTree.node);
        inOrderByRecursion(binaryTree.leftNode);
    }


    private void inOrderByNonRecursion(BinaryTreeNode binaryTree) {
        if (binaryTree == null) {
            log.error("empty binary tree!");
            return;
        }

        Stack<BinaryTreeNode> treeNodeStack = new Stack<>();
        BinaryTreeNode curNode = binaryTree;
        while (!treeNodeStack.isEmpty() || curNode != null) {
            if (curNode != null) {
                treeNodeStack.push(curNode);
                curNode = curNode.leftNode;
                continue;
            }

            curNode = treeNodeStack.pop();
            log.info("inOrder by non-recursion node: {}", curNode.node);
            curNode = curNode.leftNode;
        }
    }

    @Override
    public void postOrder(BinaryTreeNode binaryTree) {
        log.info("post order by recursion...");
        postOrderByRecursion(binaryTree);

        log.info("post order by non-recursion...");
        postOrderByNonRecursion(binaryTree);
    }

    private void postOrderByRecursion(BinaryTreeNode binaryTree) {
        if (binaryTree == null) {
            return;
        }

        postOrderByRecursion(binaryTree.leftNode);
        postOrderByRecursion(binaryTree.leftNode);
        log.info("binary tree node: {}", binaryTree.node);
    }

    private void postOrderByNonRecursion(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return;
        }

        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        stack1.push(binaryTreeNode);
        while (!stack1.isEmpty()) {
            BinaryTreeNode pop = stack1.pop();
            if (pop.leftNode != null) {
                stack1.push(pop.leftNode);
            }

            if (pop.leftNode != null) {
                stack1.push(pop.leftNode);
            }
            stack2.push(pop);
        }
        while (!stack2.isEmpty()) {
            log.info("post order by non-recursion node: {}", stack2.pop().node);
        }
    }

    @Override
    public void levelOrder(BinaryTreeNode binaryTree) {
        log.info("level order by recursion...");
        levelOrderByRecursion(binaryTree);
    }

    private void levelOrderByRecursion(BinaryTreeNode binaryTree) {
        if (binaryTree == null) {
            return;
        }

        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.offer(binaryTree);
        while (!queue.isEmpty()) {
            BinaryTreeNode poll = queue.poll();
            log.info("level order by recursion node: {}", poll.node);
            if (poll.leftNode != null) {
                queue.offer(poll.leftNode);
            }
            if (poll.rightNode != null) {
                queue.offer(poll.rightNode);
            }
        }
    }

    @Override
    public int maxBinaryTreeBreadth(BinaryTreeNode binaryTree) {
        if (binaryTree == null) {
            log.error("empty binary tree, maxLevel breadth is 0.");
            return 0;
        }

        Map<BinaryTreeNode, Integer> levelMap = new HashMap<>();
        Map<Integer, Integer> breadthMap = new HashMap<>();
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.offer(binaryTree);
        levelMap.put(binaryTree, 1);
        int maxLevel = 0;
        while (!queue.isEmpty()) {
            BinaryTreeNode poll = queue.poll();
            int level = levelMap.get(poll);
            int breadth = breadthMap.getOrDefault(level, 0) + 1;
            breadthMap.put(level, breadth);
            maxLevel = Math.max(maxLevel, breadth);
            if (poll.leftNode != null) {
                queue.offer(poll.leftNode);
                levelMap.put(poll.leftNode, level + 1);
            }
            if (poll.rightNode != null) {
                queue.offer(poll.rightNode);
                levelMap.put(poll.rightNode, level + 1);
            }
        }

        log.info("maxLevel binary tree breadth is: {}", maxLevel);
        return maxLevel;
    }

    @Override
    public boolean isSameTree(BinaryTreeNode tree1, BinaryTreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }

        if (tree1 == null || tree2 == null) {
            return false;
        }

        if (tree1.node != tree2.node) {
            return false;
        }
        return isSameTree(tree1.leftNode, tree2.leftNode) && isSameTree(tree1.rightNode, tree2.rightNode);
    }

    @Override
    public boolean isSymmetric(BinaryTreeNode binaryTree) {
        if (binaryTree == null) {
            return true;
        }
        return checkSymmetric(binaryTree.leftNode, binaryTree.rightNode);
    }

    boolean checkSymmetric(BinaryTreeNode tree1, BinaryTreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }

        if (tree1 == null || tree2 == null) {
            return false;
        }

        if (tree1.node != tree2.node) {
            return false;
        }
        return checkSymmetric(tree1.leftNode, tree2.rightNode) && isSameTree(tree1.rightNode, tree2.leftNode);
    }

    @Override
    public int maxDepth(BinaryTreeNode binaryTreeNode) {
        return 0;
    }

    @Override
    public BinaryTreeNode buildTreeByPreAndInOrder(List<Character> preOrder, List<Character> inOrder) {
        return null;
    }

    @Override
    public BinaryTreeNode buildTreeByInAndPostOrder(List<Character> inOrder, List<Character> postOrder) {
        return null;
    }
}