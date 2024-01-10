class Solution {
    public List<List<String>> partition(String s) {
        ArrayList<String> ds = new ArrayList<>();
        List<List<String>> ar = new ArrayList<>();
        helper(0,s,ds,ar);
        return ar;
    }
    public void helper(int idx, String s, ArrayList<String> ds, List<List<String>> ar){
        if(idx == s.length()){
            ar.add(new ArrayList<String>(ds));
        }
        
        for(int i = idx; i< s.length(); i++){
            System.out.println("idx"+idx);
            System.out.println("i"+i);
            
            if(ispal(s,idx,i)){
                ds.add(s.substring(idx,i+1));
                helper(i+1, s, ds, ar);
                ds.remove(ds.size()-1);
                System.out.println(ds);
            }
        }
    }
    public boolean ispal(String s, int st, int e){
        while(st <= e){
            if(s.charAt(st) != s.charAt(e)){
                return false;
            }
            st++;
            e--;
        }
        return true;
    }
}


    