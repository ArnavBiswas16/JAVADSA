
public class LinkedList {
    
    Node head;
    public void insert(int data){
        Node n = new Node();

        n.data = data;
        n.next = null;

        if(head == null){
            head = n;
        } else {

            Node m = head;

            while(m.next != null){
                m = m.next;
            }
            m.next = n;
        }
    }


    public void show(){
        Node m = head;

        if(m !=null){
            do{
                System.out.println(m.data);
                m = m.next;
            }while(m != null);
        }
    }


    public void delete(int k){
        Node m = head;
        Node p = head;

        if(m !=null){
            do{
                if(m.data == k){
                    // if head is to be deleted
                    if(m == head){
                        head = head.next;
                        break;
                    } else
                    // if tail is to be deleted
                    if(m.next == null){
                        p.next = null;
                        break;
                    } else { // if any element is to be deleted from middle

                        p.next = m.next;
                        break;
                    }

                } else {
                    if(m!=head){
                        p=p.next;
                    }
                    m = m.next;
                   
                }
            } while(m != null);
        }
    }
       
    public void insertAtStart(int data){
        Node n = new Node();

        n.data = data;
        n.next = head;

        head = n;


    }

    public void insertAt(int data, int index){

        if(index == 0){
            insertAtStart(data);
            return;
        }

        Node m = head;

        for(int i=0; i<index-1; i++){
            m = m.next;
        }

        Node n = new Node();

        n.data = data;
        n.next = m.next;

        m.next = n;


    }

    public void deleteFirst(){
        head = head.next;
    }

    public void deleteLast(){

        Node m = head;
        Node p = head;

        if(m !=null){
            do{
                if(m!=head){
                    p=p.next;
                }
                m = m.next;  
                
            } while(m.next != null);

             //tail is to be deleted
             if(m.next == null){
                p.next = null;
            }
        }
    }
}
