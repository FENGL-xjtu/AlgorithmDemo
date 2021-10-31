package chapter4;

/**
 * @Author: Fengl
 * @Date: 2021/10/31-10-31-下午6:03
 * @Description: chapter4
 * @version: 1.0
 */
public class Demo21 {
    /**
     * 在链表尾部添加新节点,并返回链表头结点
     */
    public ListNode append(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {    // 需判断原链表是不是空,如果是空,就直接将新节点作为表头返回
            return newNode;
        }
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        return head;
    }

    /**
     * 使用哨兵节点简化链表的插入操作
     * 在链表尾部添加新节点,并返回链表头结点
     */
    public ListNode append2(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        ListNode dummy = new ListNode(0);    // 哨兵节点,置于head之前
        dummy.next = head;
        ListNode node = dummy;                  // 无需判断原链表是不是空,即无需判断head是不是null
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        return dummy.next;                      // 直接返回哨兵节点的下一个元素
    }

    /**
     * 无哨兵节点的删除,分三种情况处理:
     * (1)原链表为空,直接返回
     * (2)要删除头节点,返回第二个节点
     * (3)其他情况
     */
    public ListNode delete(ListNode head, int value) {
        if (head == null) {
            return head;
        }
        if (head.val == value) {
            return head.next;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == value) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return head;
    }

    /**
     * 有哨兵节点的删除
     * 无需判断原链表是否为空,或者待删除的节点是头节点的情况
     */
    public ListNode delete2(ListNode head, int value) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (node.next != null) {
            if (node.next.val == value) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return dummy.next;
    }

    /**
     * 删除链表倒数第n个元素
     * 思路:
     * (1)删除元素,需维护一个哨兵节点
     * (2)双指针,一个指针先走n步,然后两个指针再同时走
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode front = head, back = dummy;   // 让back指针指向哨兵节点, 当front指向null时,back正好指向目标节点的前一个节点
        for (int i = 0; i < n; i++) {
            front = front.next;
        }
        while (front != null) {     // front要到null
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return dummy.next;
    }
}
