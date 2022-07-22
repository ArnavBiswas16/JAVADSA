import java.util.*;
public class CheckPalindrome {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();

        l.insert(2);
        l.insert(4);
        l.insert(4);
        l.insert(2);

        Node h = l.head;

        Stack<Integer>  s = new Stack<Integer>();
       
        while(h!=null){
            s.push(h.data);
            h = h.next;
        }
        h = l.head;
        while(h!=null){
            if(!s.isEmpty()){


                if(s.pop() != h.data){
                    System.out.println("Not a palindrome1");
                    System.exit(0);
                }
            } else {
                System.out.println("Not a palindrome");
                System.exit(0);
            }
            h=h.next;
        }
        System.out.println("palindrome");
        
    }
}
