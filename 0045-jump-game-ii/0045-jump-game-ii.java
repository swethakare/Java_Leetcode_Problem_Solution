class Solution {
    public int jump(int[] nums) {
        int curend = 0, curfar = 0, jump=0;
        for(int i = 0; i < nums.length-1; i++){
            curfar = Math.max(curfar,i + nums[i]);
            if(i == curend){
                jump++;
                curend = curfar;
            }
        
        }
        return jump;

    }

}
