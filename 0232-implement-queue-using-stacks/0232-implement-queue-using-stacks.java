class MyQueue {
    Stack<Integer> s;
    Stack<Integer> p;

    public MyQueue() {
        this.s = new Stack<Integer>();
        this.p = new Stack<Integer>();
        
        
    }
    
    public void push(int x) {
        System.out.println("before s"+s);
        while(!s.empty()){
            int ele = s.pop();
            p.add(ele);
        }
        
        s.add(x);
        while(!p.empty()){
            int ele = p.pop();
            s.add(ele);
        }
        System.out.println("after s"+s);
 
        
        
    }
    
    public int pop() {
        // inte pop = s.pop();
        return s.pop();
    }
    
    public int peek() {
        return s.peek();
        
    }
    
    public boolean empty() {
        if(s.size() < 1){
            return true;
        }else{
            return false;
        }
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */