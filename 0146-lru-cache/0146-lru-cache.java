class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    int capacity;
    Map<Integer,Node> mp;
    Node head;
    Node tail;
    
    

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.mp = new HashMap<Integer,Node>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        createlist(); 
    }

    public void createlist() {
        head.next = tail;
        tail.prev = head;
    }

    public void insertnode(Node s) { // insert node after teh head node.
        Node temp = head.next;
        head.next = s;
        s.prev = head;
        s.next = temp;
        temp.prev = s;
    }

    public void removenode(Node s) {// always recently used node comes after head so always removing node infront of the tail.
        Node prev = s.prev;
        Node next = s.next;
        prev.next = next;
        next.prev = prev;
  
    }
    public int get(int key) {
        if(mp.containsKey(key)){
            Node s = mp.get(key);
            int valu = s.val;
            removenode(s);
            insertnode(s);
            return valu;
        }
        return -1;
    }  

    public void put(int key, int value) {
        Node s = new Node(key,value);
        if(mp.containsKey(key)){
            Node p = mp.get(key);
            mp.put(key,s);
            removenode(p);
            insertnode(s); 
        }else{
            if(mp.size() < capacity){
                insertnode(s);
                mp.put(key,s);
            }else{
                // remove node infront of tail
                Node temp = tail.prev;
                mp.remove(temp.key);
                removenode(temp);
                insertnode(s);
                mp.put(key,s);
            }
        }

    }
}
