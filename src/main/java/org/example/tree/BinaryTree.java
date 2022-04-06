package org.example.tree;

import java.util.*;

public class BinaryTree<T> implements Tree<T> {

    private BinaryTreeNode<T> root;
    private int count;

    public BinaryTree() {
        this.root = null;
        this.count = 0;
    }

    @Override
    public boolean create() {
        this.root = null;
        this.count = 0;
        return true;
    }

    @Override
    public T insert(T element) {

        T insertedElement = null;
        if (this.root == null) {
            this.root = new BinaryTreeNode<>(element);
        } else {
            Iterator<BinaryTreeNode<T>> iterator = insertionIterator();
            while (iterator.hasNext()) {
                BinaryTreeNode<T> node = iterator.next();
                if (node.element == null) {
                    node.element = element;
                    insertedElement = node.element;
                    node.left = new BinaryTreeNode<>();
                    node.right = new BinaryTreeNode<>();
                    count++;
                    break;
                }

            }
        }
        return insertedElement;
    }

    @Override
    public T search(T targetElement) throws ElementNotFoundException {
        BinaryTreeNode<T> current = findNode(targetElement, root);

        if (current == null) throw new ElementNotFoundException(this.getClass()
                                                                    .getCanonicalName());

        return (current.getElement());
    }

    private BinaryTreeNode<T> findNode(T targetElement, BinaryTreeNode<T> next) {
        if (next == null) {
            return null;
        }

        if (next.getElement()
                .equals(targetElement)) return next;

        BinaryTreeNode<T> temp = findNode(targetElement, next.getLeft());

        if (temp == null) temp = findNode(targetElement, next.getRight());

        return temp;
    }

    @Override
    public boolean delete(T element) {

        return delete(this.root, element);
    }

    private boolean delete(BinaryTreeNode<T> root, T targetValue) {

        if (root == null) {
            return false;
        }

        if (root.left.element == null && root.right.element == null) {

            if (root.element == targetValue) {
                root.element = null;
                return true;
            } else {
                return false;
            }
        }

        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        BinaryTreeNode<T> deepestNode = null;
        BinaryTreeNode<T> targetNode = null;

        // Do level order traversal until
        // we find target node and last node.
        while (!queue.isEmpty()) {

            deepestNode = queue.peek();
            queue.remove();

            if (deepestNode.element == targetValue) {
                targetNode = deepestNode;
            }

            if (deepestNode.left.element != null) {
                queue.add(deepestNode.left);
            }

            if (deepestNode.right.element != null) {
                queue.add(deepestNode.right);
            }
        }

        if (targetNode != null) {

            boolean deleteLast = deepestNode == targetNode;
            T x = deepestNode.element;
            deleteDeepest(this.root, deepestNode);
            if (!deleteLast) {
                // move last element to target node
                targetNode.element = x;
            }
        }

        return true;
    }

    private void deleteDeepest(BinaryTreeNode<T> root, BinaryTreeNode<T> deleteNode) {

        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        BinaryTreeNode<T> temp = null;

        // Do level order traversal until last node
        while (!queue.isEmpty()) {

            temp = queue.peek();
            queue.remove();

            if (temp == deleteNode) {
                temp.element = null;
                temp.left = null;
                temp.right = null;
                return;
            }

            if (temp.right != null) {
                if (temp.right == deleteNode) {
                    temp.right.element = null;
                    temp.right.right = null;
                    temp.right.left = null;
                    return;
                } else {
                    queue.add(temp.right);
                }
            }

            if (temp.left != null) {
                if (temp.left == deleteNode) {
                    temp.left.element = null;
                    temp.left.right = null;
                    temp.left.left = null;
                    return;
                } else {
                    queue.add(temp.left);
                }
            }
        }
    }

    @Override
    public boolean contains(T targetElement) {
        boolean containsElement = false;

        try {
            containsElement = search(targetElement) != null;
        } catch (ElementNotFoundException e) {
            System.err.println("Element not found");
        }
        return containsElement;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public Iterator<T> iterator() {
        return iteratorLevelOrder();
    }

    @Override
    public Iterator<T> iteratorPreOrder() {

        Queue<T> tempList = new LinkedList<>();
        preOrder(root, tempList);
        return tempList.iterator();
    }

    private void preOrder(BinaryTreeNode<T> node, Queue<T> tempList) {

        // NLR
        if (node != null) {
            tempList.add(node.getElement());
            preOrder(node.getLeft(), tempList);
            preOrder(node.getRight(), tempList);
        }
    }

    @Override
    public Iterator<T> iteratorInOrder() {

        Queue<T> tempList = new LinkedList<>();
        inOrder(root, tempList);
        return tempList.iterator();
    }

    private void inOrder(BinaryTreeNode<T> node, Queue<T> tempList) {

        // LNR
        if (node != null) {
            inOrder(node.getLeft(), tempList);
            tempList.add(node.getElement());
            inOrder(node.getRight(), tempList);
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {

        Queue<T> tempList = new LinkedList<>();
        postOrder(root, tempList);
        return tempList.iterator();
    }

    private void postOrder(BinaryTreeNode<T> node, Queue<T> tempList) {

        // LRN
        if (node != null) {
            postOrder(node.getLeft(), tempList);
            postOrder(node.getRight(), tempList);
            tempList.add(node.getElement());
        }
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {

        Queue<T> tempList = new LinkedList<>();
        levelOrder(root, tempList);
        return tempList.iterator();
    }

    public void levelOrder(BinaryTreeNode<T> node, Queue<T> tempList) {

        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {

            BinaryTreeNode<T> tempNode = queue.poll();
            tempList.add(tempNode.element);

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }

        }
    }

    private Iterator<BinaryTreeNode<T>> insertionIterator() {

        Queue<BinaryTreeNode<T>> tempList = new LinkedList<>();
        levelOrderInsertionIterator(root, tempList);

        return tempList.iterator();
    }

    private void levelOrderInsertionIterator(BinaryTreeNode<T> node, Queue<BinaryTreeNode<T>> tempList) {

        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {

            BinaryTreeNode<T> tempNode = queue.poll();
            tempList.add(tempNode);

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }

        }
    }

    public void printTopDownTree() {

        List<List<String>> lines = new ArrayList<>();
        List<BinaryTreeNode<T>> level = new ArrayList<>();
        List<BinaryTreeNode<T>> next = new ArrayList<>();

        level.add(this.root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {

            List<String> line = new ArrayList<>();

            nn = 0;

            for (BinaryTreeNode<T> n : level) {

                if (n == null) {
                    line.add(null);
                    next.add(null);
                    next.add(null);
                } else {
                    String aa;
                    if (n.getElement() != null) {
                        aa = n.getElement()
                              .toString();
                    } else {
                        aa = "null";
                    }
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.getLeft());
                    next.add(n.getRight());

                    if (n.getLeft() != null) nn++;
                    if (n.getRight() != null) nn++;

                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<BinaryTreeNode<T>> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perPiece = lines.get(lines.size() - 1)
                            .size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perPiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '|' : '|';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '|';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perPiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "-");
                        }
                        System.out.print(j % 2 == 0 ? "|" : "|");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "-" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perPiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perPiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perPiece /= 2;
        }
    }

    private static class BinaryTreeNode<S> {

        BinaryTreeNode<S> left;
        BinaryTreeNode<S> right;
        S element;

        BinaryTreeNode() {
            this.element = null;
            this.left = null;
            this.right = null;
        }

        BinaryTreeNode(S element) {
            this.element = element;
            this.left = new BinaryTreeNode<>();
            this.right = new BinaryTreeNode<>();
        }

        S getElement() {
            return element;
        }

        BinaryTreeNode<S> getLeft() {
            return left;
        }

        BinaryTreeNode<S> getRight() {
            return right;
        }

    }
}
