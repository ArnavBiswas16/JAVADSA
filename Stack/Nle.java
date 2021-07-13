import java.util.Stack;
import java.util.*;
import java.io.*;
public class Nle {
    public static void main(String[] args) {
        int arr[] = {4,2,6,1,0};
        int nle[] = new int[arr.length];

        Stack<Integer> s = new Stack<Integer>();
        s.push(0);
        for(int i=1; i<arr.length; i++){
            while(!s.isEmpty() && arr[i]<arr[s.peek()]){
                int p = s.pop();
                nle[p] = arr[i];
            }
            s.push(i);
        }

        while(!s.isEmpty()){
            int p = s.pop();
            nle[p] = -1;
        }
        System.out.println(Arrays.toString(nle));
    }    
}
