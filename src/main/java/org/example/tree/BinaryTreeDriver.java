package org.example.tree;

import java.util.Iterator;

public class BinaryTreeDriver {

    public static void main(String[] args) {

        Tree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.insert(8);
        binaryTree.insert(10);
        binaryTree.insert(11);
        binaryTree.insert(3);
        binaryTree.insert(6);
        binaryTree.insert(7);
        binaryTree.insert(1);
        binaryTree.insert(4);
        binaryTree.insert(12);
        binaryTree.insert(2);
        binaryTree.insert(9);
        binaryTree.insert(5);

/*        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(4);
        binaryTree.insert(5);
        binaryTree.insert(6);
        binaryTree.insert(7);
        binaryTree.insert(8);
        binaryTree.insert(9);
        binaryTree.insert(10);
        binaryTree.insert(11);
        binaryTree.insert(12);*/

        System.out.println("In Order traversal of binary tree will be:");
        printTraversal(binaryTree.iteratorInOrder());

        System.out.println("\nPost Order traversal of binary tree will be:");
        printTraversal(binaryTree.iteratorPostOrder());

        System.out.println("\nPre Order traversal of binary tree will be:");
        printTraversal(binaryTree.iteratorPreOrder());

        System.out.println("\nLevel Order traversal of binary tree will be:");
        printTraversal(binaryTree.iteratorLevelOrder());
        
        System.out.println();
        ((BinaryTree<Integer>) binaryTree).printTopDownTree();

        // binaryTree.delete(6);

        // System.out.println();
        // ((BinaryTree<Integer>) binaryTree).printTopDownTree();
    }

    private static void printTraversal(Iterator iterator) {

        while(iterator.hasNext()) {
            Object obj = iterator.next();
            if (obj != null) {
                System.out.print(obj + " ");
            }
        }
    }
}
