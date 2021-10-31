package chapter4;

/**
 * @Author: Fengl
 * @Date: 2021/10/31-10-31-下午10:12
 * @Description: chapter4
 * @version: 1.0
 */
public class Demo28 {
    /**
     * p67页,第28题,展平多级双向链表
     * 思路: 递归将child连接的子链表插入到父链表中,返回链表尾结点
     * 返回值分两种情况:
     * (1)没有child子链表,直接返回当前节点
     * (2)有child子链表,返回子链表的尾端节点
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        flattenGetTail(head);
        return head;
    }

    public Node flattenGetTail(Node head) {
        Node node = head;
        Node tail = null;
        Node nxt = null;
        while (node != null) {
            nxt = node.next;
            if (node.child != null) {
                Node childTail = flattenGetTail(node.child);
                node.next = node.child;
                node.child.pre = node;
                node.child = null;
                childTail.next = nxt;
                if (nxt != null) {
                    nxt.pre = childTail;
                }
                node = nxt;
                tail = childTail;
            } else {
                tail = node;
            }
            node = nxt;
        }
        return tail;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        n1.next = n2;
        n2.pre = n1;
        n2.next = n3;
        n2.child = n5;
        n3.pre = n2;
        n3.next = n4;
        n4.pre = n3;
        n5.next = n6;
        n6.pre = n5;
        n6.next = n7;
        n6.child = n8;
        n7.pre = n6;
        n8.next = n9;
        n9.pre = n8;
        n1 = new Demo28().flatten(n1);
        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }
}
