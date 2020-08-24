package offer;


import java.util.List;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class GetIntersectionNode {

    /**
     * 两个链表设定的是无环，所以可以采用双指针法
     * 同时循环步进两个链表，如果 A 的链表到头就从 B 开头，当 B 的链表到头就从 A 再开始循环
     * 当两个链表节点相交的时候就是他们的第一个公共点
     */
    public ListNode getIntersectionNode(ListNode nodeA, ListNode nodeB) {
        ListNode node1 = nodeA;
        ListNode node2 = nodeB;
        while (node1 != node2) {
            node1 = node1 == null ? nodeB : node1.next;
            node2 = node2 == null ? nodeA : node2.next;
        }
        return node1;
    }
}
