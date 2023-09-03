package program.datastructure.tree.binarysearchtree.impl;

import lombok.extern.slf4j.Slf4j;
import program.datastructure.tree.binarysearchtree.BinarySearchTree;
import program.datastructure.tree.binarytree.BinaryTree;
import program.datastructure.tree.binarytree.impl.BinaryTreeImpl;
import program.datastructure.tree.model.BinaryTreeNode;

@Slf4j
public class BinarySearchTreeImpl implements BinarySearchTree {
    @Override
    public BinaryTreeNode insert(BinaryTreeNode root, int key) {
        if (root == null) {
            return new BinaryTreeNode(key);
        }
        if (key == root.node) {
            log.error("data conflict, key: {}", key);
        }

        if (key > root.node) {
            root.rightNode = insert(root.rightNode, key);
        }

        if (key < root.node) {
            root.leftNode = insert(root.leftNode, key);
        }


        return root;
    }

    @Override
    public BinaryTreeNode remove(BinaryTreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // 找到对于的节点
        if (key > root.node) {
            root.rightNode = remove(root.rightNode, key);
        } else if (key < root.node) {
            root.leftNode = remove(root.leftNode, key);
        } else {
            // 删除叶子节点
            if (root.leftNode == null && root.rightNode == null) {
                return null;
            }

            // 删除度为1的节点，当前节点的子节点上移
            if (root.leftNode == null) {
                return root.rightNode;
            }

            if (root.rightNode == null) {
                return root.leftNode;
            }

            // 删除度为2的节点
            BinaryTreeNode min = findMin(root.rightNode);
            root.node = min.node;
            root.rightNode = remove(root.rightNode, min.node);
            return root;
        }
        return root;
    }

    @Override
    public void clear(BinaryTreeNode root, int key) {

    }

    @Override
    public BinaryTreeNode findMin(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }

        BinaryTreeNode tmp = root;
        while (tmp.leftNode != null) {
            tmp = tmp.leftNode;
        }
        return tmp;
    }
}
