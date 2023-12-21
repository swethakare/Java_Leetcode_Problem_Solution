class MyStack {
    Queue<Integer> q;
    Queue<Integer> r;
    int size;
    public MyStack() {
        this.q = new LinkedList<>();
        this.r = new LinkedList<>();
        this.size = -1; 
    }
    public void push(int x){
        q.add(x);
        System.out.println("q"+q);
        for(int i = 0;i < q.size()-1;i++){
            q.add(q.remove());
            
        }
        // System.out.println("r"+r);
        // size++; 
    }
    public int pop(){
      return q.remove();
      
    }
    
    public int top(){
        return q.peek();
    }
    
    public boolean empty() {
        if(q.size() == 0){
            return true;
        }else{
            return false;
        } 
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */