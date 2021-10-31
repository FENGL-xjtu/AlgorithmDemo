package chapter4;

/**
 * @Author: Fengl
 * @Date: 2021/10/31-10-31-下午10:37
 * @Description: chapter4
 * @version: 1.0
 */
public class Demo29 {
    /**
     * 向循环有序链表里插入值inserVal,仍然保持链表为循环有序
     * 思路:插入分两种情况:
     * (1)找到一个合适的位置,左边元素小于等于insertVal,右边元素大于等于insertVal,则直接插入
     * (2)insertVal大于链表里的所有元素,或者小于所有元素. 记录链表里最大值, 把这个新数插入到最大值后面
     * @param head
     * @param insertVal
     * @return
     */
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else if (head.next == head) {
            head.next = newNode;
            newNode.next = head;
        } else {
            insertCore(head, newNode);
        }
        return head;
    }

    public void insertCore(Node head,Node newNode) {
        Node cur = head;
        Node nxt = head.next;
        Node biggest = head;
        while (!(cur.val <= newNode.val && nxt.val >= newNode.val) && nxt!=head) {   // nxt==head时,循环完一遍
            if (biggest.val < cur.val) {
                biggest = cur;
            }
            cur = nxt;
            nxt = nxt.next;
        }
        if (cur.val <= newNode.val && nxt.val >= newNode.val) {
            cur.next = newNode;
            newNode.next = nxt;
        } else {
            newNode.next = biggest.next;
            biggest.next = newNode;
        }

    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n1.next=n2;
        n2.next=n3;
        n3.next=n5;
        n5.next=n6;
        n6.next = n7;
        n7.next = n1;
        Demo29 d = new Demo29();
        Node node = n5;
        d.insert(node, 4);
        Node index = node;

        while (index.next != node) {
            System.out.println(index.val);
            index = index.next;
        }
        System.out.println(index.val);
    }
}
