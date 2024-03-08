class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remain = 0; 
        int start = 0;
        int totalgas = 0;
        int requiredgas = 0;
        for(int i = 0 ;i < gas.length; i++){
            totalgas = totalgas + gas[i];
            requiredgas = requiredgas + cost[i];
        }
        if(totalgas < requiredgas){
            return -1;
        }
        for(int i = 0; i< gas.length; i++){
            remain = remain + gas[i] - cost[i];
            if(remain < 0){
                start = i+1;
                remain = 0;
            }
        }
        return start;
    }
}