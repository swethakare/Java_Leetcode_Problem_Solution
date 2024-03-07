class RandomizedSet {
    ArrayList<Integer> ar = new ArrayList<Integer>();
    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {    
        boolean ret = false;
        if(!ar.contains(val)){
            ar.add(val);
            ret = true;
        }
        
        return ret;
    }
    
    public boolean remove(int val) {
        boolean ret = false;
        if(ar.contains(val)){
            ar.remove(Integer.valueOf(val));
            ret = true;
        }
        return ret;
        
    }
    
    public int getRandom() {
        if(ar.size() == 0){
            return -1;
        }else{
            int randomIndex = new Random().nextInt(ar.size());
            return ar.get(randomIndex);
        }
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */