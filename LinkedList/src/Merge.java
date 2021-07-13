public class Merge {
    
    public static void main(String[] args) {
        
        LinkedList l = new LinkedList();

        l.insert(1);
        l.insert(2);
        l.insert(4);
        l.insert(6);
        l.insert(10);


        LinkedList l1 = new LinkedList();

        l1.insert(0);
        l1.insert(5);
        l1.insert(6);
        l1.insert(7);
        l1.insert(9);

        Node res = new Node();
        Node tail;

        Node h = l.head;
        Node h1 = l1.head; 

        if(h.data <= h1.data){
            res = h;
            tail = h;
            h = h.next;

        } else {
            res = h1;
            tail = h1;
            h1 = h1.next;
        }

        while(h.next!= null && h1.next!=null){
            if(h.data <= h1.data){

                tail.next = h; 
                tail = h;
                h=h.next;
    
            } else {
               
                tail.next = h1; 
                tail = h1;
                h1=h1.next;
            }
        }

        if(h.next != null){
            tail.next = h;
        }
        if(h1.next != null){
            tail.next = h1;
        }

        LinkedList r = new LinkedList();
        r.head = res;

        r.show();
    }
}
