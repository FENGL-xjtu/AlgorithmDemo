package chapter4;

/**
 * @Author: Fengl
 * @Date: 2021/10/31-10-31-下午8:38
 * @Description: chapter4
 * @version: 1.0
 */
public class Demo24 {
    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nxt;
        ListNode pre = null;
        while (head != null) {
            nxt = head.next;
            head.next = pre;
            pre = head;
            head = nxt;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        ListNode res = new Demo24().reverse(n1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
