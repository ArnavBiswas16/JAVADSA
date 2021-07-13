public class ReverseLinkList {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();

        l.insert(1);
        l.insert(4);
        l.insert(3);

        // iterative 
        Node prev, curr, next;
        prev = null;

        // curr = l.head;
        // while(curr!=null){

        //     next = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = next;
        // }
        // l.head = prev;
        // l.show();

        // iterative method
        l.head = recursionReverse(l.head);
        l.show();
        
                
        // iterative method
        l.head = recursionReverse1(l, l.head, null);
        l.show();


    }

    public static Node recursionReverse(Node n){

        if(n.next == null){
            return n;
        }

        Node rest =  recursionReverse(n.next);

        n.next.next = n;

        n.next = null;

     return rest;
        
    }


    public static Node recursionReverse1(LinkedList l, Node n, Node prev){

        if(n.next == null){
            l.head = n;
            n.next = prev;
            return n;
        }

        Node next1 =  n.next;
        n.next = prev;

        recursionReverse1(l, next1, n);
     return l.head;
        
    }
}
