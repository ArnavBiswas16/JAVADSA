import java.io.*;
import java.util.*;
public class LargestAreaHistogram {
    public static void main(String[] args)throws IOException {
        int arr[] = {6,2,5,4,5,1,6};
        int max = 0;
        int area = 0;
        int nlr[] = nlr(arr);
        int nll[] = nll(arr);
        for(int i =0; i<arr.length; i++){

            int r = nlr[i]
                area = (nlr[i]-1 - nll[i]+1 +1) * arr[i];
                System.out.println(area+" "+ i);
                if(area > max){
                    max = area;
                }
        }
        System.out.println(max);

    
    }

    public static int[] nlr(int[] arr){
        int []nlr = new int[arr.length];
        Stack<Integer> s = new Stack<Integer>();
        s.push(0);
        for(int i=1; i<arr.length; i++){
            while(!s.isEmpty() && arr[i]<=arr[s.peek()]){
                nlr[s.pop()] = i;
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            nlr[s.pop()] = -1;
        }
        return nlr;
    }

    public static int[] nll(int[] arr){

        int []nll = new int[arr.length];
        Stack<Integer> s = new Stack<Integer>();
        s.push(arr.length-1);
        for(int i=arr.length-1; i>=0; i--){
            while(!s.isEmpty() && arr[i]<=arr[s.peek()]){
                nll[s.pop()] = i;
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            nll[s.pop()] = -1;
        }
        return nll;
    }
}
