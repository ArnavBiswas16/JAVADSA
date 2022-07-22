import java.util.Stack;

public class CountInversion {
    
    public static void main(String[] args) {
        int arr[] = {8,4,2,1};
        int n = arr.length;
        int ngr[] = new int[n]; 

        Stack<Integer> s = new Stack<>();
        s.push(0);

        for(int i=0; i<n; i++){
            while(!s.isEmpty() && arr[i] > arr[s.peek()]){
               int p =  s.pop();
               ngr[p] = arr[i]; 
            }
            s.push(i);
        }

        while(!s.isEmpty()){
            int p = s.pop();
            ngr[p] = n-1;
        }
        int c=0;
        for(int i =0; i<n; i++){
            c += (ngr[i]-i);
        }
        
        System.out.println(c);
 
    }
}
