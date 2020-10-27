package com.chenwuqiang.class04;

public class Code03_PrintCommonPart {
    static Node<Integer> node01;
    static Node<Integer> node02;
    static {
        initNode();
    }

    public static void main(String[] args) {
        NodeUtils.printNodes(node01);
        System.out.println("===========");
        NodeUtils.printNodes(node02);
        printCommonPart(node01, node02);
    }

    public static void printCommonPart(Node<Integer> head01, Node<Integer> head02) {
        System.out.println("Common Part: ");
        while (head01 != null && head02 != null) {
            Integer value01 = head01.getValue();
            Integer value02 = head02.getValue();
            if (value01 < value02) {
                head01 = head01.getNext();
            } else if (value01 > value02) {
                head02 = head02.getNext();
            } else {
                System.out.println(head01.getValue());
                head01 = head01.getNext();
                head02 = head02.getNext();
            }
        }
    }

    public static void initNode() {
        node01 = new Node<>(1);
        node01.next = new Node(3);
        node01.next.next = new Node(5);
        node01.next.next.next = new Node(7);
        node01.next.next.next.next = new Node(8);
        node01.next.next.next.next.next = new Node(9);

        node02 = new Node<>(2);
        node02.next = new Node(4);
        node02.next.next = new Node(6);
        node02.next.next.next = new Node(7);
        node02.next.next.next.next = new Node(8);
        node02.next.next.next.next.next = new Node(9);
    }
}
