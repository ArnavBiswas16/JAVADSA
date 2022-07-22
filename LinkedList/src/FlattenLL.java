class LL {
    CNode head;
}

class CNode {
    int data;
    CNode next;
    CNode bottom;
    
    CNode(int data){
        data = data;
    }
}

public class FlattenLL {
    public static void main(String[] args) {

        flaten(head)
        
    }

    static CNode merge(CNode a, CNode b){

        CNode curr = new CNode(-1);
        CNode res =curr;

        while(a!=null && b!=null){

            if(a.data < b.data){
                curr = curr.bottom;
                a=a.bottom;
            } else {
                curr = curr.bottom;
                b=b.bottom;
            }
        }

        if(a == null){
            curr.bottom = b;
        }
        if(b == null){
            curr.bottom = a;
        }

        return res.bottom;
    }

    static CNode flaten(CNode head){
        
        if(head ==null || head.next == null){
            return head;
        } 

        head.next = flaten(head.next);
        head = merge(head, head.next);
        return head;
    }
}



