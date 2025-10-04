package ui;

import structures.BST;

public class Main {
    public static void main(String[] args) {
        BST<Integer> binaryTreeIntegers = new BST<>();
        binaryTreeIntegers.add(50);
        binaryTreeIntegers.add(60);
        binaryTreeIntegers.add(40);
        binaryTreeIntegers.add(45);
        binaryTreeIntegers.add(41);

        System.out.println(binaryTreeIntegers.inOrder());

        System.out.println(binaryTreeIntegers.search(43));
    }
}
