class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int ht = 0;
        int max = 0;
        int wi = 0;
        int ar = 0;
        while(start <= end){
            ht = Math.min(height[start],height[end]);
            wi = end - start;
            ar = ht * wi;
            max = Math.max(max,ar);
            if(height[start] <= height[end]){
                start++;
            }else{
                end--;
            }
        }
        return max;
        
    }
}