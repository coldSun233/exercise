package sort;

public class LinkedListMergeSort {
    public static void main(String[] args) {
        Node n1 = new Node(4);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(5);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        Node head = listMergeSort(n1);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    // 无序链表归并排序
    public static Node listMergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = getMiddleNode(head);
        Node head1 = head;
        Node head2 = mid.next;
        mid.next = null;

        head1 = listMergeSort(head1);
        head2 = listMergeSort(head2);

        return mergeTwoList(head1, head2);

    }

    // 获得链表的中间节点
    public static Node getMiddleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 合并两个有序链表
    public static Node mergeTwoList(Node list1, Node list2) {
        Node p1 = list1;
        Node p2 = list2;
        Node headpre = new Node(-1);
        Node tail = headpre;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }
        if (p1 != null) {
            tail.next = p1;
        }
        if (p2 != null) {
            tail.next = p2;
        }
        return headpre.next;
    }
}

class Node {
    int val;
    Node next;
    public Node(){}
    public Node(int value) {
        val = value;
    }
}