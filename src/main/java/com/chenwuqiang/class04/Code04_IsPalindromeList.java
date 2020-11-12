package com.chenwuqiang.class04;

public class Code04_IsPalindromeList {
    public static boolean isPalindrome(Node head) {
        if (head == null || head.getNext() == null) {
            return true;
        }
        Node n1 = head.getNext();
        Node n2 = head;
        while (n2.getNext() != null && n2.getNext().getNext() != null) {
            n1 = n1.getNext();
            n2 = n2.getNext().getNext();
        }

        // reverse right
        n2 = n1;
        n1 = null;
        Node n3 = null;
        while (n2 != null) {
            n3 = n2.getNext();
            n2.setNext(n1);
            n1 = n2;
            n2 = n3;
        }
        n2 = head;
        n3 = n1; // save right last
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.getValue() != n2.getValue()) {
                res = false;
                break;
            }
            n1 = n1.getNext();
            n2 = n2.getNext();
        }

        // recover list
        n2 = n3;
        n1 = null;
        n3 = null;
        while (n2 != null) {
            n3 = n2.getNext();
            n2.setNext(n1);
            n1 = n2;
            n2 = n3;
        }

        return res;
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        head.next = new Node(3);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next.next = new Node(1);

        boolean palindrome = isPalindrome(head);
        System.out.println(palindrome);
        NodeUtils.printNodes(head);
    }
}
