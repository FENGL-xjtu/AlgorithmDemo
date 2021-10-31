package chapter4;

/**
 * @Author: Fengl
 * @Date: 2021/10/31-10-31-下午9:29
 * @Description: chapter4
 * @version: 1.0
 */
public class Demo26 {
    /**
     * 给定一个链表,调整其顺序:  1->2->3->4->5->6   调整为    1->6->2->5->3->4
     * 思路:
     * (1)找到中间节点3(快慢指针)
     * (2)把3以后的节点反转
     * (3)依次插入两个子链表的节点 (注意使用temp暂存node1.next)
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode node = dummy;
        ListNode n1 = head;
        ListNode n2 = reverse(slow.next);
        slow.next = null;
        ListNode temp;
        while (n2 != null) {
            temp = n1.next;
            node.next = n1;
            n1.next = n2;
            node = n2;
            n2 = n2.next;
            n1 = temp;
        }
        if (n1 != null) {
            node.next = n1;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode nxt;
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
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        new Demo26().reorderList(n1);
        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }
}
