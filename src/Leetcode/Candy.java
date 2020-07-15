package Leetcode;

import java.util.Arrays;

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
