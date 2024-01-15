import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
    
        int pos = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                // breakpoint found
                pos = i - 1;
                break;
            }
        }

        int pos1 = -1;
        if(pos != -1){
            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i] > nums[pos]) {
                    pos1 = i;
                    break;
                }
            }
            swap(pos, pos1, nums);
            sort(nums, pos + 1, nums.length - 1);   
        }else{
            Arrays.sort(nums);
        }
    }

    public void swap(int pos, int pos1, int[] nums) {
        int temp = nums[pos];
        nums[pos] = nums[pos1];
        nums[pos1] = temp;
    }

    public void sort(int[] nums, int start, int end) {
        // Sort the subarray
        Arrays.sort(nums, start, end + 1);
    }
}
