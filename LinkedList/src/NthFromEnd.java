public class NthFromEnd {

    static int i = 0;
    public static void main(String[] args) {
        LinkedList l = new LinkedList();

        l.insert(1);
        l.insert(4);
        l.insert(3);
        l.insert(6);
        l.insert(2);
        l.insert(9);

        int n = 2;

        nth(l.head, n);

    }

     static void nth(Node h, int n){

        if(h.next == null){
            return;
        } 
           
        nth(h.next, n);
        if (++i == n){
            System.out.println(h.data);
        }


     }
}
