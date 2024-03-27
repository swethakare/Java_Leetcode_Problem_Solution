class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0; // If k is less than or equal to 1, there can be no such subarrays
        }
        
        int count = 0;
        int product = 1;
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            // Shrink the window from the left until the product is less than k
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            // Every time the product is less than k, all subarrays from left to right are valid
            count += right - left + 1;
        }

        return count;
    }
}
