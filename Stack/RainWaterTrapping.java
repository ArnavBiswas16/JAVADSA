
import java.util.Arrays;

public class RainWaterTrapping {
    
    public static void main(String[] args) {
        int arr[] = {3,0,0,2,0,4};
        int n = arr.length;
        int maxr[] = new int[n];
        int maxl[] = new int[n];

        int total=0;

        int max = arr[0];
        maxr[0] = max;
        for(int i=1; i<n; i++){
            max = Math.max(max, arr[i]);
            maxr[i] = max;
        }

        max = arr[n-1];
        maxl[n-1] = max;

        for(int i=n-1; i>=0; i--){
            max = Math.max(max, arr[i]);
            maxl[i] = max;
        }


        for(int i=0; i<n; i++){
            total+= Math.min(maxl[i], maxr[i]) - arr[i];
        }
        System.out.println(total);
    }
    
}
