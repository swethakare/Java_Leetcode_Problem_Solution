class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int[] nums1 = new int[nums.length + nums.length];
        int cont = nums.length;
        for(int i = 0;i < nums.length;i++){
            nums1[i] = nums[i];
            
        }
        for(int i = 0;i < nums.length; i++){
            nums1[cont] = nums[i];
            cont++;
        }
        // for(int i =0;i<nums1.length;i++){
        //     System.out.println(nums1[i]);  
        // }
        int[] ans = new int[nums1.length];
        Stack<Integer> s = new Stack<Integer>();
        ans = nextgreater(nums1,s,ans);
        
        for(int i =0 ;i < nums.length; i++){
            nums[i] = ans[i];
        }
        return nums;
        
        
    }
    public int[] nextgreater(int[] nums1, Stack<Integer> s, int[] ans){
        
        for(int i = nums1.length-1; i>=0 ; i--){
            while(!s.empty() && s.peek() <= nums1[i]){
                s.pop();
            }
            if(!s.empty() && s.peek() > nums1[i]){
                ans[i] = s.peek();
            }else{
                ans[i] = -1;
            }
            s.add(nums1[i]);
        }
        return ans;
    } 
}