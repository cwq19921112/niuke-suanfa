package com.chenwuqiang.class04;

public class Code07_FindFirstIntersectNode {
    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, head2, loop1, loop2);
        }

        return null;
    }

    private static Node bothLoop(Node head1, Node head2, Node loop1, Node loop2) {
        if (loop1 == loop2) {
            Node n1 = head1;
            Node n2 = head2;
            int n = 0;
            while (n1 != loop1) {
                n ++;
                n1 = n1.getNext();
            }
            while (n2 != loop2) {
                n --;
                n2 = n2.getNext();
            }
            n1 = n > 0 ? head1 : head2;
            n2 = n1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n > 0) {
                n--;
                n1 = n1.getNext();
            }
            while (n1 != n2) {
                n1 = n1.getNext();
                n2 = n2.getNext();
            }
            return n1;
        } else {
            Node n1 = loop1.getNext();
            while (n1 != loop1) {
                if (n1 == loop2) {
                    return n1;
                }
                n1 = n1.getNext();
            }
            return null;
        }
    }

    private static Node noLoop(Node head1, Node head2) {
        Node n1 = head1;
        Node n2 = head2;
        int n = 0;
        while (n1 != null) {
            n++;
            n1 = n1.getNext();
        }
        while (n2 != null) {
            n--;
            n2 = n2.getNext();
        }
        n1 = n > 0 ? head1 : head2; // n1 long list
        n2 = n1 == head1 ? head2 : head1; // n2 short list
        n = Math.abs(n);
        while (n > 0) {
            n --;
            n1 = n1.getNext();
        }
        while (n1 != null) {
            if (n1 == n2) {
                return n1;
            }
            n1 = n1.getNext();
            n2 = n2.getNext();
        }

        return null;
    }

    public static Node getLoopNode(Node head) {
        if (head == null || head.getNext() == null || head.getNext().getNext() == null) {
            return null;
        }
        Node n1 = head.getNext();
        Node n2 = head.getNext().getNext();
        while (n2 != null && n2.getNext() != null) {
            if (n1 == n2) {
                n1 = head;
                while (n1 != n2) {
                    n1 = n1.getNext();
                    n2 = n2.getNext();
                }
                return n1;
            }
            n1 = n1.getNext();
            n2 = n2.getNext().getNext();
        }
        return null;
    }

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        // 1->2->3->4->5->6->7->4...
        Node head1;
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->6->4->5->6..
        Node head2;
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6

        Node node = getIntersectNode(head1, head2);
        System.out.println(node == null ? node : node.getValue());
    }

    public static void testGetLoopNode() {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        Node loopNode = getLoopNode(head1);
        System.out.println(loopNode == null ? loopNode : loopNode.getValue());
    }
}
