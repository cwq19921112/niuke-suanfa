package com.chenwuqiang.class04;

public class NodeUtils {
    public static void printNodes(Node head) {
        while (head != null) {
            System.out.println(head.getValue());
            head = head.getNext();
        }
    }

    public static void printNodesDouble(Node head) {
        while (head != null) {
            System.out.println((head.getLast() == null ? "null" : head.getLast().getValue()) +" " + head.getValue() + " " + (head.getNext() == null ? "null" : head.getNext().getValue()));
            head = head.getNext();
        }
    }
}
