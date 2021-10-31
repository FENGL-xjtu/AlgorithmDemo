package chapter4;

/**
 * @Author: Fengl
 * @Date: 2021/10/31-10-31-下午8:00
 * @Description: chapter4
 * @version: 1.0
 */
public class Demo22 {
    /**
     * 找出一个有环链表中的环的起始节点
     * 思路: 快慢指针,fast,slow
     * fast每次走两步,slow每次走一步
     * 当fast和slow相遇时,假设slow走了k步,那么fast就走了2k步,
     * 假设始发点到环的起始点距离是m,那么slow在环上走了k-m,fast在环上走了2k-m
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        do {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        } while (fast.next != null);
        if (fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
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
        n6.next = n3;
        Demo22 d = new Demo22();
        System.out.println(d.detectCycle(n1).val);
    }
}
