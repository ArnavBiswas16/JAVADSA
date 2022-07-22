import java.util.PriorityQueue;
import java.util.Stack;

class FirstNegNoInWindowK {
    public static void main(String[] args) {
        int arr[] = {-1,2,-3,5,6,9};
        int k=3, i=0,j=0;
        PriorityQueue <Integer> s = new PriorityQueue<Integer>();

        for(j=0; j<arr.length; j++){
            if(j-i+1 <= k){
                if(arr[j]< 0){
                    s.add(j);
                }
            } else {
                if(s.isEmpty()){
                    System.out.print(0);
                } else {
                    System.out.print(arr[s.peek()]);
                }
                if(arr[i] < 0){
                    s.poll();
                }
                i++;
                
                if(arr[j]< 0){
                   s.add(j);
                }
            }
        }
        if(s.isEmpty()){
            System.out.print(0);
        } else {
            System.out.print(arr[s.peek()]);
        }
    }    
}
