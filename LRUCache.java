import java.util.HashMap;
import java.util.LinkedList;

public class Node{

    int data;
    Node next;
    Node pre;

    public node(int data){
        this.data = data;
    }

}

public class Dll{

    Node head = null;
    Node tail = null;
    int capacity, count;

    public Dll(Node head){
        this.head = head;
    }


    public void addToHead(Node node)
    {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }
}

public class LRUCache {
    public static void main(String[] args) {
        int pagereq[] ={1,2,3,4,1,3};
        int cacheSize = 3; 
        int pageFault = 0;

        Dll cache = new Dll();
        HashMap<Integer, Node> m = new HashMap<Integer, Node>();
        
        for(int n : pagereq){

            if(cache.size()<cacheSize){
                if(!m.containsKey(n)){
                    cache.add(n);
                    m.put(n, cache.indexOf(n));
                    pageFault++;
                } else {
                    int index = m.get(n);
                    cache.remove(index);
                    cache.add(n);
                    m.put(n, cache.indexOf(n));
                }
            } else {
                if(!m.containsKey(n)){
                    m.remove(cache.peek());
                    cache.remove();
                    cache.add(n);
                    m.put(n, cache.indexOf(n));
                    pageFault++;
                } else {
                    int index = m.get(n);
                    cache.remove(index);
                    cache.add(n);
                    m.put(n, cache.indexOf(n));
                }
            }
            System.out.println(cache);
            System.out.println(m);
        }
        
    }
}
