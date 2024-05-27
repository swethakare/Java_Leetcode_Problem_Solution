class item{
    String it;
    int cost;
    item(String it, int cost){
        this.it = it;
        this.cost = cost;
    }
}
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<item> q = new LinkedList<>();
        q.add(new item(startGene,0));
        HashSet<String> bnk = new HashSet<>();
        for(int i = 0; i < bank.length; i++){
            bnk.add(bank[i]);
        }
        int[] dis = new int[bank.length];
        for(int i = 0; i < bank.length; i++){
            if(bank[i] == startGene){
                dis[i] = 0;
                break;
            }
        }
        char[] ds = {'A','C','G','T'};
        while(!q.isEmpty()){
            item cur = q.poll();
            String curnode = cur.it;
            int curcost = cur.cost;
            char[] newstr = curnode.toCharArray();
            for(int i = 0; i < newstr.length; i++){
                char oldchar = newstr[i];
               
                for(int j = 0; j < ds.length; j++){
                    if(newstr[i] != ds[j]){
                        newstr[i] = ds[j];
                        if(bnk.contains(String.valueOf(newstr))){
                            String ite = new String(newstr);
                            if(ite.equals(endGene)){ 
                                curcost = curcost+1;
                                return curcost;
                            }
                            q.add(new item(String.valueOf(newstr),curcost+1));
                            bnk.remove(curnode);
                        }
                        newstr[i] = oldchar;  
                    }
                }  
            }
        }
        return -1;
    }
}