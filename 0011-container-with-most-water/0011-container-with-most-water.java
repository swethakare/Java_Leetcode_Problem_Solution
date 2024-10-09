class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int ht = 0;
        int max = 0;
        int wi = 0;
        int area = 0;
        while(start < end){
            ht = Math.min(height[start],height[end]);
            wi = end - start;
            area = ht * wi;
            max = Math.max(max,area);
            if(height[start] <= height[end]){
                start++;
            }else{
                end--;
            }
        }
        return max;
    }
}

// walkthrough an example:
//        =  0,1,2,3,4,5,6,7,8
// height = [1,8,6,2,5,4,8,3,7]
// maintaining a min of the start and end heights to ensure no overflow occurs
// width is the distance between start and end height 
// area of the rect is ht * wt;
// max area is needed;
// whichever height is lesser either start or end move that pointer alone to ensure that if any other greater height is found posibbly it could increase the area..
// i = 0;
// start = 0, end = 8, wt = 8, ht = 1-->(min(ht[start],ht[end])){taking min height to ensure no overflow occurs beyond the boundries}; area = 8; max = 8;start++

// i = 1;
// start = 1, end = 8, wt = 7, ht = 7 ; area = 49; max = 49; end--
    
// i = 2;
// start = 1, end = 7, wt = 6, ht = 3; area = 18; max = 49; end--

// i = 3;
// start = 1, end = 6, wt = 5, ht = 8; area = 40 max = 49; start++;

// i = 4;
// start = 2, end = 6, wt = 4, ht = 6, area = 24 ; max = 49; start++;

// i = 5;
// start = 3, end = 6; wt = 3, ht = 2, area = 6; max = 49; start++;

// i = 6;
// start = 4, end = 6; wt = 2; ht = 5, area = 10; max = 49; start++;

// i = 7;
// start = 5, end = 6; wt = 1; ht = 4, area = 4; max = 49; start++;

// loop is broken return max = 49;

// iterating through the length of the array so TC = O(N);
//space is O(1);