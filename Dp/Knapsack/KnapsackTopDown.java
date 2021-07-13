import java.io.*;
import java.math.*;
public class KnapsackTopDown {
    public static void main(String[] args) {
        int wt[] = {2,3,4,5};
        int val[] = {1,2,5,6};
        int n = wt.length;
        int cap = 8;

        int [][]t = new int[n+1][cap+1];

       
        for(int i= 1; i<n+1; i++){
            for(int j=1; j<cap+1; j++){
                if(wt[i-1] <= j ){
                    t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
                } else {
                    t[i][j] =  t[i-1][j];
                }
            }
        }

        System.out.println(t[n][cap]);
    }
}
