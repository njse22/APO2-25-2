package Main;

import structures.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("A1");
        list.add("A2");
        list.add("A3");
        list.add("A4");
        list.add("A5");

        System.out.println(list.printList());


    }
}
