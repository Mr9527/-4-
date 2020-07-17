package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 */
public class Candy {

    /**
     * 暴力破解法
     */
    public static int candy(int[] ratings) {
        int candy = 0;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < ratings.length; i++) {
                if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    flag = true;
                }
                if (i < ratings.length - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                }
            }
        }
        for (int i : candies) {
            candy += i;
        }

        return candy;
    }

    /**
     * 左右遍历
     */
    public static int candyRevert(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length - 1; i++) {
            if (candies[i] > candies[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int candy = candies[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (candies[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            candy += candies[i];
        }
        return candy;
    }

    public static void main(String[] args) {

    }
}
