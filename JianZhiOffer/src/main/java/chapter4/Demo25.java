package chapter4;

/**
 * @Author: Fengl
 * @Date: 2021/10/31-10-31-下午9:07
 * @Description: chapter4
 * @version: 1.0
 */
public class Demo25 {
    /**
     * 给定两个链表,表示两个整数, 链表中的每个元素代表数的一位,首节点表示最高位, 求这两个整数的和,依然用链表表示
     * 思路:
     * (1)反转两个链表
     * (2)按位加
     * (3)将结果反转56
     * @param head1
     * @param head2
     * @return
     */
    public ListNode add(ListNode head1, ListNode head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        int carry = 0, sum = 0;
        while (head1 != null || head2 != null) {
            int val1 = head1 == null ? 0 : head1.val;
            int val2 = head2 == null ? 0 : head2.val;
            sum = val1 + val2 + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            node.next = new ListNode(sum);
            node = node.next;

            head1 = head1 == null ? null : head1.next;
            head2 = head2 == null ? null : head2.next;
        }
        if (carry > 0) {
            node.next = new ListNode(carry);
        }
        return reverse(dummy.next);
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
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(8);
        l1.next = l2;
        Demo25 d = new Demo25();
        ListNode res = d.add(n1, l1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }


    }
}
