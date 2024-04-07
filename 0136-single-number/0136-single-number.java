class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!mp.containsKey(nums[i])){
                mp.put(nums[i],1);
            }else{
                int inc = mp.get(nums[i]);
                mp.put(nums[i],inc+1);
            }
        }
     
        for(Map.Entry<Integer, Integer> al: mp.entrySet()){
            if(al.getValue()==1){
                return al.getKey();
            }
        }
        return -1;
    }
}