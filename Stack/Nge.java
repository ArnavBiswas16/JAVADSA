import java.util.*;
import java.io.*;

public class Nge {
    public static void main(String[] args) {
        int arr[] = {13,16,11,15};
        int nge[] = new int[arr.length];

        Stack<Integer> s = new Stack<Integer>();
        s.push(0);
        for(int i=0; i<arr.length; i++){
            
            while(!s.empty() && arr[i] > arr[s.peek()]){
                int p = s.pop();
                nge[p] = arr[i];
            }
            s.push(i);       
        }
        
        while(!s.empty()){
            int p = s.pop();
            nge[p] = -1;
        }
        System.out.println(Arrays.toString(nge));
    }
}
