package offer;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class MajorityElement {

    /**
     * 解法：
     * 哈希表统计法 遍历数组 nums，用哈希表统计各个数字的
     * 数量，最终超过数组长度的一半则为众数
     * <p>
     * 数组排序法 将数组 nums 排序，由于众数的数量超过数组的
     * 长度一半，因此数组中点的元素一定为众数
     * <p>
     * 摩尔投票法：核心理念为“正负抵消”；时间和空间复杂分别为 O(n)和 O(1)
     * 由于众数出现的次数超过数组长度的一半；若计众数的票为 +1,非众数的票数为 -1
     * 那么所有的票数和一定大于 0
     */
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
