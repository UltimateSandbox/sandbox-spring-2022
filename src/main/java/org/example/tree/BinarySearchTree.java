package org.example.tree;

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable> implements Tree<T> {

    private BinaryTreeNode<T> root;
    private int count;

    public BinarySearchTree() {
        this.root = null;
        this.count = 0;
    }

    @Override
    public T insert(T element) {

        T insertedElement = null;
        if (this.root == null) {
            this.root = new BinaryTreeNode(element);
            insertedElement = root.element;
        } else {
            insertedElement = insertInto(element, root);
        }
        
        return insertedElement;

    }

    private T insertInto(T element, BinaryTreeNode<T> root) {

        T insertedElement = null;
        if (element.compareTo(root.element) < 0) {

            if (root.left.element != null) {
                insertInto(element, root.left);
            } else {
                root.left.element = element;
                root.left.left = new BinaryTreeNode<>();
                root.left.right = new BinaryTreeNode<>();
                insertedElement = root.left.element;
            }
        } else {

            if(root.right.element != null) {
                insertInto(element, root.right);
            } else {
                root.right.element = element;
                root.right.left = new BinaryTreeNode<>();
                root.right.right = new BinaryTreeNode<>();
                insertedElement = root.right.element;
            }

        }
        return insertedElement;
    }

    @Override
    public boolean create() {
        return false;
    }

    @Override
    public T search(T targetElement) throws ElementNotFoundException {
        return null;
    }

    @Override
    public boolean delete(T element) {
        return false;
    }

    @Override
    public boolean contains(T targetElement) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        return null;
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        return null;
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        return null;
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
        return null;
    }

    private class BinaryTreeNode<S> {

        BinaryTreeNode<S> left;
        BinaryTreeNode<S> right;
        S element;

        public BinaryTreeNode() {
            this.element = null;
            this.left = null;
            this.right = null;
        }

        public BinaryTreeNode(S element) {
            this.element = element;
            this.left = new BinaryTreeNode<>();
            this.right = new BinaryTreeNode<>();
        }

        public BinaryTreeNode<S> getLeft() {
            return left;
        }

        public BinaryTreeNode<S> getRight() {
            return right;
        }

        public S getElement() {
            return element;
        }
    }
}
