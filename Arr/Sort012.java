
import java.io.*;
import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        int arr[] ={2,1,1,0,0,2,1,0,0,2};
        int zero=-1, one=0;
        for(int i=0; i<arr.length; i++){
            if (arr[i] == 0){
                zero++;
            } else if(arr[i] == 1){
                one++;
            } 
        }
        one += zero; 
        for(int i=0; i<arr.length; i++){
            if (i<=zero){
                arr[i] =0;
            } else if(i<=one){
                arr[i] =1;
            } else {
                arr[i] = 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
