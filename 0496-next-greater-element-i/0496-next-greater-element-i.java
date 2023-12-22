class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ele = 0;
        int[] ans = new int[nums1.length];
        
        for(int i = 0; i < nums1.length;i++){
            for(int j = 0; j< nums2.length;j++){
                if(nums1[i] == nums2[j]){
                    ele = nums2[j];
                    ans[i] = nextgreater(ele,nums2);
                }
            } 
        }
        return ans;
    }
    public int nextgreater(int ele, int[] nums2){
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[nums2.length];
        int pos = -1;
        for(int i = nums2.length-1; i>= 0; i--){
           
            while(!s.empty() && s.peek() < nums2[i]){
                s.pop();
            }
            if(!s.empty() && s.peek() > nums2[i]){
                ans[i] = s.peek();
            }else{
                ans[i] = -1;
            }
            s.add(nums2[i]);
            if(nums2[i] == ele){
                pos = i;
            }
        }
        System.out.println(ans[pos]);
    
        return ans[pos];
        
    }
}