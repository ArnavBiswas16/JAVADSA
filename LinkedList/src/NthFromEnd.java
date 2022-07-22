public class NthFromEnd {

    // static int i = 1;
    public static void main(String[] args) {
        LinkedList l = new LinkedList();

        l.insert(1);
        l.insert(4);
        l.insert(3);
        l.insert(6);
        l.insert(2);
        l.insert(9);

        int n = 2;

        nth(l.head, n, 1);
        l.show();
    }

     static int nth(Node h, int n, int i){

        if(h.next == null){
            return i;
        } 
           
        i = nth(h.next, n, i);
        if (++i == n){
            h.data = h.next.data;
            h.next = h.next.next;
            
        }

        return i;
     }
}
