package chapter4;

/**
 * @Author: Fengl
 * @Date: 2021/10/31-10-31-下午8:31
 * @Description: chapter4
 * @version: 1.0
 */
public class Demo23 {
    /**
     * 找出两个链表的第一个重合的节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == null) {
                p1 = headB;
            }
            if (p2 == null) {
                p2 = headA;
            }
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n7.next = n8;
        n8.next = n4;

        Demo23 d = new Demo23();
        System.out.println(d.getIntersectionNode(n1,n7).val);
    }
}
