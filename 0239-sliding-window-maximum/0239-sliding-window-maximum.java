class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> dq = new ArrayDeque<>();
    int[] ri = new int[nums.length-k+1];
    int j = 0;
    // whenever out of boundry remove from first
    // peek the first element and ceck when ever it is lesser than the inserting element just remove it 
    // by doing this higher element is always maintained in the front of the queue
    // adding element from the back of the queue.
    // all the elements actually get added to the queu despite it being bigger or smaller
        for(int i =0;i < nums.length;i++){
            if(!dq.isEmpty() && dq.peekFirst() == i- k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){ // no use of having it in our que so remove it
                dq.pollLast();
                
            }
            dq.offer(i);
            if(i>=k-1){
                ri[j] = nums[dq.peekFirst()];// since we are adding to the que in decfreasing order always the first element will be the greatest element 
                j++;   
            }

            
            
            
        }
        return ri; 
    }
}