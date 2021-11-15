
package testbst;


import java.util.*;

public class BST {

    private Node root;


    public static class Node {

        Node left;
        Node right;
        int data;

        Node(int newData) {
            left = null;
            right = null;
            data = newData;
        }
    }

    public void BST() {
        root = null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return (node); // in any case, return the new pointer to the caller
    }

    public int size() {
        return (size(root));
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return (size(node.left) + 1 + size(node.right));
        }

    }

    public boolean lookup(int data) {
        return (lookup(root, data));
    }

    private boolean lookup(Node node, int data) {
        if (node == null) {
            return (false);
        }
        if (data == node.data) {
            return (true);
        } else if (data < node.data) {
            return (lookup(node.left, data));
        } else {
            return (lookup(node.right, data));
        }
    }


    public void levelOrder() {
        levelOrder(root);
        System.out.println();
    }

    private void levelOrder(Node node) {
        if (node != null) {
            Queue<Node> q = new ArrayDeque<Node>();
            q.add(node);
            while (q.size() != 0) {
                Node currentNode = q.remove();
                System.out.print(currentNode.data + " ");
                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }
        }
    }

}
