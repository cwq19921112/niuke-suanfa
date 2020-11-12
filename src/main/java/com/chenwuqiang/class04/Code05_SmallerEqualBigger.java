package com.chenwuqiang.class04;

public class Code05_SmallerEqualBigger {
    public static void main(String[] args) {
        Node node = new Node(7);
        node.next = new Node(9);
        node.next.next = new Node(1);
        node.next.next.next = new Node(8);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(2);
        node.next.next.next.next.next.next = new Node(5);
        NodeUtils.printNodes(node);
        System.out.println("===========");
        // node = listPartition1(node, 4);
        node = listPartition(node, 10);
        NodeUtils.printNodes(node);
    }

    public static Node<Integer> listPartition(Node<Integer> head, int pivot) {
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node mH = null;
        Node mT = null;
        while (head != null) {
            Integer value = head.getValue();
            if (value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.setNext(head);
                    sT = head;
                }
            } else if (value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.setNext(head);
                    eT = head;
                }
            } else {
                if (mH == null) {
                    mH = head;
                    mT = head;
                } else {
                    mT.setNext(head);
                    mT = head;
                }
            }
            head = head.getNext();
        }
        head = sH != null ? sH :
                eH != null ? eH :
                        mH != null ? mH : null;
        if (sT != null) {
            sT.setNext(null);
        }
        if (eT != null) {
            eT.setNext(null);
        }
        if (mT != null) {
            mT.setNext(null);
        }

        if (sT != null && eH != null) {
            sT.setNext(eH);
        }
        if (eT != null && mH != null) {
            eT.setNext(mH);
        }
        if (sT != null && eH == null && mH != null) {
            sT.setNext(mH);
        }

        return head;
    }
}
