package Leetcode;

public class TwoSum {


    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum sum = new TwoSum();
        int[] ints = sum.twoSum(new int[]{5, 25, 75}, 100);
        System.out.println(ints[0]+""+ints[1]);
    }
}
