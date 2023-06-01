package program.datastructure.tree;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import program.datastructure.tree.model.BinaryTreeNode;

import java.util.List;
import java.util.Stack;

@Slf4j
public class BinaryTreeImpl implements BinaryTree {
    @Override
    public BinaryTreeNode createBinaryTree(List<Character> nodes, int index) {
        if (CollectionUtils.isEmpty(nodes) || index >= nodes.size()) {
            return null;
        }

        BinaryTreeNode node = new BinaryTreeNode(nodes.get(index));
        node.setLeftNode(createBinaryTree(nodes, 2 * index + 1));
        node.setRightNode(createBinaryTree(nodes, 2 * index + 2));
        return node;
    }

    @Override
    public void preOrder(BinaryTreeNode binaryTree) {
        log.info("pre order by recursion...");
        preOrderByRecursion(binaryTree);

        log.info("pre order by stack...");
        preOrderByStack(binaryTree);
    }

    private void preOrderByRecursion(BinaryTreeNode binaryTree) {
        if (binaryTree == null) {
            return;
        }

        log.info("binary tree node: {}", binaryTree.getNode());
        preOrderByRecursion(binaryTree.getLeftNode());
        preOrderByRecursion(binaryTree.getRightNode());
    }

    private void preOrderByStack(BinaryTreeNode binaryTree) {
        if (binaryTree == null) {
            return;
        }

        Stack<BinaryTreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(binaryTree);
        while (!treeNodeStack.isEmpty()) {
            BinaryTreeNode pop = treeNodeStack.pop();
            log.info("binary tree node: {}", pop.getNode());

            if (pop.getRightNode() != null) {
                treeNodeStack.push(pop.getRightNode());
            }
            if (pop.getLeftNode() != null) {
                treeNodeStack.push(pop.getLeftNode());
            }
        }
    }

    @Override
    public void inOrder(BinaryTreeNode binaryTree) {
        log.info("in order by recursion...");
        inOrderByRecursion(binaryTree);

        log.info("in order by stack...");
        inOrderByStack(binaryTree);
    }

    private void inOrderByRecursion(BinaryTreeNode binaryTree) {
        if (binaryTree == null) {
            return;
        }

        inOrderByRecursion(binaryTree.getLeftNode());
        log.info("binary tree node: {}", binaryTree.getNode());
        inOrderByRecursion(binaryTree.getRightNode());
    }

    private void inOrderByStack(BinaryTreeNode binaryTree) {
        if (binaryTree == null) {
            return;
        }

        Stack<BinaryTreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(binaryTree);
        while (!treeNodeStack.isEmpty()) {
            BinaryTreeNode pop = treeNodeStack.pop();
            if (pop.getRightNode() != null) {
                treeNodeStack.push(pop.getRightNode());
            }

            treeNodeStack.push(pop);

            if (pop.getLeftNode() != null) {
                treeNodeStack.push(pop.getLeftNode());
            } else {
                log.info("binary tree node: {}", pop.getNode());
            }
        }
    }

    @Override
    public void postOrder(BinaryTreeNode binaryTree) {
        log.info("post order by recursion...");
        postOrderByRecursion(binaryTree);
    }

    private void postOrderByRecursion(BinaryTreeNode binaryTree) {
        if (binaryTree == null) {
            return;
        }

        postOrderByRecursion(binaryTree.getLeftNode());
        postOrderByRecursion(binaryTree.getRightNode());
        log.info("binary tree node: {}", binaryTree.getNode());
    }

    @Override
    public void levelOrder(BinaryTreeNode binaryTree) {

    }

}
