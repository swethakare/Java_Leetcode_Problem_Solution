class Pair{
    int val;
    int min;
   
    public Pair(int val, int min){
        this.val = val;
        this.min = min;
    }
    public int getMinimum(){
        return this.min;
    }

}
class MinStack{
    Stack<Pair> st = new Stack<>();
    int min;
    public MinStack(){
        this.st = new Stack<Pair>();
        this.min = Integer.MAX_VALUE;
    }
    public void push(int val){
        if(st.empty()){
            min = val;
            
        }else{
            min = Math.min(val,st.peek().min);
        }
        st.add(new Pair(val,min));
        
    }
    public void pop(){
        int ele = st.peek().val;
        st.pop();   
    }
    public int top(){
       return st.peek().val;
    }
    public int getMin(){
        return st.peek().min;  
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */