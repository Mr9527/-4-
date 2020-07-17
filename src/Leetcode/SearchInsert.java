package Leetcode;

/*给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。你可以假设数组中无重复元素。
*
*/
public class SearchInsert {

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = -1;
        int mid = 0;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            }
            if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        if (index == -1 && hi == nums.length - 1) {
            index = nums.length;
        } else if (index == -1 && lo == 0) {
            index = 0;
        } else if (nums[mid] < target) {
            index = mid + 1;
        } else if (nums[mid] > target) {
            index = mid;
        }
        return index;
    }

    public static void main(String[] args) {
        int insert = searchInsert(new int[]{1, 3}, 2);
        System.out.println(insert);
    }
}
