public class Middle {
    public static void main(String[] args) {
        
        LinkedList l = new LinkedList();

        l.insert(1);
        l.insert(2);
        l.insert(3);
        l.insert(6);
        l.insert(0);

        Node f = l.head;
        Node s = l.head.next;

        while(s.next != null){
            f = f.next;

            if(s.next != null){
                s = s.next;
            }

            if(s.next != null){
                s=s.next;
            }
            
        }
        System.out.println(f.data);
    }
}
