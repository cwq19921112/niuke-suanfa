package com.chenwuqiang.class04;

import java.util.HashMap;
import java.util.Map;

public class Code06_CopyListWithRandom {
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getRand() {
            return rand;
        }

        public void setRand(Node rand) {
            this.rand = rand;
        }
    }

    public static Node copyListWithRand(Node head) {
        Map<Node, Node> nodeNodeMap = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            nodeNodeMap.put(cur, new Node(cur.getValue()));
            cur = cur.getNext();
        }
        cur = head;
        while (cur != null) {
            nodeNodeMap.get(cur).setNext(nodeNodeMap.get(cur.getNext()));
            nodeNodeMap.get(cur).setRand(nodeNodeMap.get(cur.getRand()));
            cur = cur.getNext();
        }
        return nodeNodeMap.get(head);
    }

    public static void main(String[] args) {
        Node head = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printNodes(head);
        System.out.println("===============");
        Node copyHead = copyListWithRand(head);
        printNodes(copyHead);
    }

    public static void printNodes(Node head) {
        while (head != null) {
            System.out.println(head.getValue());
            System.out.println(head.getValue() + "=====>" + (head.getRand()==null ? "" : head.getRand().getValue()));
            head = head.getNext();
        }
    }
}
