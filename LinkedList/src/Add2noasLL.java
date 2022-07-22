import java.util.*;
public class Add2noasLL {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();

        l.insert(2);
        l.insert(4);
        l.insert(3);
        l.insert(7);

        LinkedList l1 = new LinkedList();

        l1.insert(1);
        l1.insert(3);
        l1.insert(4);

        // use stack
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        Stack<Integer> s3 = new Stack<Integer>();
        // Queue<Integer> s3= new ArrayDeque<Integer>();

        Node h = l.head;
        Node h1 = l1.head;

        while(h!=null || h1!=null){

            if(h != null){
                s1.push(Integer.valueOf(h.data));
                h= h.next;
            } 

            if(h1 != null){
                s2.push(Integer.valueOf(h1.data));
                h1=h1.next;
            } 
        }

Integer c = 0;

        while(!s1.isEmpty() || !s2.isEmpty()){
            Integer e1=0;
            Integer e2=0;

            if(!s1.isEmpty()){
                e1 = s1.pop();
            } 
            if(!s2.isEmpty()){
                e2 = s2.pop();
            } 
            Integer sum = e1 + e2 + c;
            if(sum>9){
                c = sum/10;
                sum = sum % 10;
            } else {
                c=0;
            }
            s3.add(sum);

        }
        LinkedList res = new LinkedList();

        for (Integer i : s3) {
            res.insert(i);
        }
        Node prev, curr, next;
        prev = null;

        curr = res.head;
        while(curr!=null){

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        res.head = prev;
        res.show();

    }
}
