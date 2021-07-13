import java.io.*;
import java.util.Arrays;
public class countFreq1ton {
    public static void main(String[] args) {
        int arr[] = {2, 3, 3, 2, 5};
        int n = arr.length;

        for (int j = 0; j < n; j++)
            arr[j] = arr[j] - 1;

        for (int i=0; i<n; i++){
            arr[arr[i] % n] = arr[arr[i] % n] + n;
            }

            for (int i=0; i<n; i++){

            System.out.print(i+1+"--");
            System.out.println(arr[i]/n);
        }

    }
}
