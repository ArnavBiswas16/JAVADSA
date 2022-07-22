public class ReverseInGrp {
    public static void main(String[] args) {
       
        LinkedList l = new LinkedList();

        l.insert(2);
        l.insert(4);
        l.insert(3);
        l.insert(7);
        l.insert(5);
        l.insert(1);

        int n= 4;
       
        printList(reverseSet(l.head ,n)); 
    }

    static Node reverseSet(Node head, int n){

        Node prev, curr, next;
        prev = null;
        next = null;
        int i= 1;
        curr = head;
        while(i <= n && curr!=null){

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        if (next != null)
            head.next = reverseSet(next, n);
 
        // prev is now head of input list
        return prev;
    }

    static void printList(Node head)
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
