import java.util.Arrays;

public class DutchFlag {
    public static void main(String[] args) {
        int arr[] = {2,1,0,2,1,0,0,1,1,2,1};
        int n= arr.length;

        int l=0, r =n-1;

        for(int i=0; i<n && i<r; i++){
            if(arr[i] == 0){
                while(arr[l] == 0){
                    l++;
                }

                arr[i] = arr[l];
                arr[l] = 0;
                l++;
            } else if(arr[i] == 2){
                while(arr[r] ==2){
                    r--;
                }
                arr[i] = arr[r];
                arr[r] = 2;
                r--;
            }

        }
        System.out.println(Arrays.toString(arr));
    }
}
