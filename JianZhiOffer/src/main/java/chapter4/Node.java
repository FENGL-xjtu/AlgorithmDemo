package chapter4;

/**
 * @Author: Fengl
 * @Date: 2021/10/31-10-31-下午10:12
 * @Description: chapter4
 * @version: 1.0
 */
public class Node {
    public int val;
    public Node pre;
    public Node next;
    public Node child;
    public Node(){}

    public Node(int val) {
        this.val = val;
    }
    public Node(int val, Node pre, Node next) {
        this.val = val;
        this.pre = pre;
        this.next = next;
    }

    public Node(int val, Node pre, Node next, Node child) {
        this.val = val;
        this.pre = pre;
        this.next = next;
        this.child = child;
    }
}
