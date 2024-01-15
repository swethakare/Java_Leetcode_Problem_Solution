class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> br = new ArrayList<>();
        for(int i = 0;i< rowIndex+1;i++){
            ArrayList<Integer> ar = new ArrayList<>();
            for(int j =0; j<=i; j++){
                if(j == 0 || j == i){
                    ar.add(1);
                }else{
                    ar.add(br.get(i-1).get(j-1) + br.get(i-1).get(j));
                }
            }
            br.add(ar);
        }
        System.out.println(br);
        return br.get(rowIndex);
        
    }
}