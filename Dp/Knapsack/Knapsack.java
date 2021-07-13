import java.io.*;
import java.util.Arrays;
public class Knapsack {

    public static void main(String[] args) {
        int wt[] = {2,3,4,5};
        int val[] = {1,2,5,6};
        int n = wt.length;
        int cap = 8;

        int t[][] = new int[n+1][cap+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<=cap; j++){
                t[i][j] = -1;
            }
        }
      
        System.out.println(maxProfit(wt, val, cap, n-1, t));

    }

    public static int maxProfit(int[] wt, int[] val, int cap, int n, int[][] t){
        
        if( n == 0 || cap==0){
            return 0;
        }

        if(t[n][cap] != -1){
            return t[n][cap];
        }

        if(wt[n] <= cap){
            t[n][cap] = Math.max(val[n]+ maxProfit(wt, val, cap-wt[n], n-1, t), maxProfit(wt, val, cap, n-1, t));
            return t[n][cap];
        } else {
            t[n][cap] = maxProfit(wt, val, cap, n-1, t);
            return t[n][cap];

        }

    }

}
