class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> row = new ArrayList<>();
        for(int i  = 0 ; i < numRows; i++){
            List<Integer> ar = new ArrayList<Integer>();
            for(int j  = 0; j<=i; j++){
                if(j==0 || j == i){
                    ar.add(1);
                }else{
                    ar.add(row.get(i-1).get(j-1) + row.get(i-1).get(j));
                }
            }
            row.add(ar);
        }
        return row;
        
    }
}