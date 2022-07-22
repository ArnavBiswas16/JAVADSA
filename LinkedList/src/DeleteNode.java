class DeleteNode {  // not possible to delete the last node of list. Use doubly linked list for that.
    public static void main(String[] args) {
        LinkedList l = new LinkedList();

        l.insert(2);
        l.insert(4);
        l.insert(3);
        l.insert(7);

        // l.show();

        Node n = l.head;

        deleteN(n);

        l.show();
    }

    static void deleteN(Node n){

        if(n.next != null){
           
            n.data = n.next.data;
            n.next =  n.next.next;
        }

    }
}