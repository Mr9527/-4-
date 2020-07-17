package Leetcode;

public class ReversePairs {
    private int count;

    public int reversePairs(int[] nums) {
        count = 0;
        mergeArray(nums, 0, nums.length - 1);
        return count;
    }

    public void mergeArray(int[] nums, int s, int e) {
        if (s >= e) return;
        int mid = (s + e) / 2;
        mergeArray(nums, s, mid);
        mergeArray(nums, mid + 1, e);
        merge(nums, s, mid, e);
    }

    public void merge(int[] nums, int s, int mid, int e) {
        int i = s;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[e - s + 1];
        while (i <= mid && j <= e) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                count += (mid - i + 1);
                temp[k++] = nums[j++];
            }
        }
        int z = s;
        int x = mid;
        if (j <= e) {
            z = mid;
            x = e;
        }
        while (z <= x) {
            temp[k++] = nums[z++];
        }
        for (int o = 0; o <= e - s; o++) {
            nums[s + o] = temp[o];
        }
    }

    public static void main(String[] args) {
        ReversePairs pairs = new ReversePairs();
        int pairs1 = pairs.reversePairs(new int[]{7, 6, 5, 4});
        System.out.println(pairs1);
    }
}
