package Leetcode;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] != 0) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    break;
                }
            }
        }
    }
    public void moveZeroes2(int[] nums) {
        int j = 0;
        for(int i = 0;i< nums.length;i++){
            if(nums[i]!=0){
                nums[j]=nums[i];
                if(i!=j){
                    nums[i]=0;
                }
                j++;
            }
        }
    }
    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes.moveZeroes2(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
