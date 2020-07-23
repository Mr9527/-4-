package Leetcode;

public class MinArray {


    public int minArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        int i = 0;
        int j = numbers.length - 1;
        int mid = 0;
        while (i < j) {
            mid = i + (j - i) / 2;
            if (numbers[mid] > numbers[j]) {
                i = mid + 1;
            } else if (numbers[mid] < numbers[j]) {
                j = mid - 1;
            } else if (numbers[mid] > numbers[mid + 1] || numbers[mid] > numbers[mid - 1]) {
                break;
            }
        }
        return Math.min(numbers[mid + 1], numbers[mid - 1]);
    }

    public static void main(String[] args) {
        MinArray array = new MinArray();
        System.out.println(array.minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(array.minArray(new int[]{2, 2, 2, 0, 2}));
    }
}
