package com.chenwuqiang.class05;

import java.util.Stack;

public class Code01_PreInPosTraversal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void midOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        midOrderRecur(head.left);
        System.out.print(head.value + " ");
        midOrderRecur(head.right);
    }

    public static void afterOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        afterOrderRecur(head.left);
        afterOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    public static void preOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(head);
        while (!nodeStack.isEmpty()) {
            Node node = nodeStack.pop();
            System.out.print(node.value + " ");
            if (node.right != null) {
                nodeStack.push(node.right);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
            }
        }
    }

    public static void midOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> nodeStack = new Stack<>();
        while (!nodeStack.isEmpty() || head != null) {
            if (head != null) {
                nodeStack.push(head);
                head = head.left;
            } else {
                head = nodeStack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
    }

    public static void afterOrderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + " ");
        }
    }

    public static void afterOrderUnRecur2(Node head) {
        if (head == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node h = head;
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            if (node.left != null && h != node.left && h != node.right) {
                stack.push(node.left);
            } else if (node.right != null && h != node.right) {
                stack.push(node.right);
            } else {
                System.out.print(stack.pop().value + " ");
                h = node;
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        preOrderRecur(head);
        System.out.println();
        midOrderRecur(head);
        System.out.println();
        afterOrderRecur(head);
        System.out.println();
        System.out.println("====================");
        preOrderUnRecur(head);
        System.out.println();
        midOrderUnRecur(head);
        System.out.println();
        afterOrderUnRecur(head);
        System.out.println();
        afterOrderUnRecur2(head);
    }
}
