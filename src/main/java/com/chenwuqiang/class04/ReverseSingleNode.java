package com.chenwuqiang.class04;

public class ReverseSingleNode {
    private static Node<String> head;
    static {
        head = new Node<>("1");
        Node second = new Node("2");
        Node third = new Node("3");
        Node four = new Node("4");
        Node five = new Node("5");

        head.setNext(second);
        second.setNext(third);
        third.setNext(four);
        four.setNext(five);

        five.setLast(four);
        four.setLast(third);
        third.setLast(second);
        second.setLast(head);

    }

    public static void main(String[] args) {
        Node reverseDouble = reverseSingle(head);
        NodeUtils.printNodes(reverseDouble);
    }

    public static Node reverseSingle(Node head) {
        Node n1 = null;
        Node n2 = head;
        Node n3 = null;
        while (n2 != null) {
            n3 = n2.getNext();
            n2.setNext(n1);
            n1 = n2;
            n2 = n3;
        }
        head = n1;
        return head;
    }

    public static Node reverseDouble(Node node) {
        Node head = node;
        while (node != null) {
            head = node;
            Node temp = node.getNext();
            node.setNext(node.getLast());
            node.setLast(temp);
            node = temp;
        }
        return head;
    }
}
