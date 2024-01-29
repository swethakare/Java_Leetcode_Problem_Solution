class Solution {
    public double myPow(double x, int n) {
        long nn = (long) n;
        double ans = 1.0;
        boolean negflag = false;
        if(nn < 0){
            nn = -1 * nn;
            negflag = true;
        }
        while(nn > 0){
            if(nn % 2 == 1){
                ans = ans * x;
                nn = nn - 1;
            }else{
                x = x * x;
                nn = nn/2;
            }
        }
        if(negflag){
           return 1.0/ans;
        }
        return ans;
    }
        
}