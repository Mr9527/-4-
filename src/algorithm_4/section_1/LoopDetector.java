package algorithm_4.section_1;

import java.util.HashMap;
import java.util.Map;

public class LoopDetector {

    public static void main(String[] args) {

        Node node = LinkedListUtils.createNodeBySize(10, false);
        node.next = node;
//        System.err.println(whileDetector(node));
        Map<Node, Integer> map = new HashMap<>();
        System.err.println(mapDetector(map,node));
    }


    /***
     * 通过快慢之指针同时遍历一个链表，如果链表中有环那么它们迟早会相遇，以时间换取空间
     */
    private static boolean whileDetector(Node node) {
        Node cursor1 = node;
        Node cursor2 = node.next;
        while (cursor2 != null && cursor2.next != null) {
            cursor1 = cursor1.next;
            cursor2 = cursor2.next.next;

            if (cursor2 == null) {
                return false;
            } else if (cursor1 == cursor2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 通过散列表来存储已经经过的 node 结点，如果被发现已经存在散列表中则判定有环的存在，以空间换取时间
     */
    private static boolean mapDetector(Map<Node, Integer> map, Node node) {
        if (node == null || node.next == null) {
            return false;
        }
        if (map.containsKey(node)) {
            return true;
        } else {
            map.put(node, 0);
            return mapDetector(map, node.next);
        }
    }

}
