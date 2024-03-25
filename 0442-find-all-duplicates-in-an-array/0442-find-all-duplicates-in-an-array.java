public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int[] freq = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }
        List<Integer> freqList = new ArrayList<>();
        for(int i = 1; i < freq.length; i++){
            if(freq[i] > 1){
                freqList.add(i);
            }
        }
        return freqList;
    }
}