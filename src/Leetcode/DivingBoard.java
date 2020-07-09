package Leetcode;

import java.util.PriorityQueue;

/**
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * <p>
 * 返回的长度需要从小到大排列。
 * <p>
 * <p>
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diving-board-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DivingBoard {
    public static int[] divingBoard(int shorter, int longer, int k) {
        if (k == 1) {
            return null;
        }
        int[] results = new int[k + 1];
        divingBoard(results, shorter, longer, k - 1, k);
        results[0] = shorter * k;
        return results;
    }

    private static int[] divingBoard(int[] results, int shorter, int longer, int shorterCount, int k) {
        if (shorterCount < 0) {
            return results;
        }
        int shorterSum = 0;
        for (int i = 0; i < shorterCount; i++) {
            shorterSum += shorter;
        }
        int longerSum = 0;
        for (int i = 0; i < k - shorterCount; i++) {
            longerSum += longer;
        }
        results[k - shorterCount] = longerSum + shorterSum;
        return divingBoard(results, shorter, longer, shorterCount - 1, k);
    }

    public static void main(String[] args) {

    }
}
