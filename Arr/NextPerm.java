import java.util.Arrays;
public class NextPerm {
    public static void main(String[] args) {

        int arr[] = {9,1,2,4,3,1,0};
        int l =  arr.length-1;
     
        for(int i = arr.length-2; i>=0; i--){
            if(arr[i] < arr[l]){
                l = i;
                break;
            } else{
                l = arr[i];
            }
        }
        int maxi =0;
        int max = Integer.MAX_VALUE;
        for(int i=l+1; i<arr.length; i++){
            if(arr[i]>arr[l] && arr[i]<max){
                maxi = i;
                max= arr[i];
            }
        }

        int swap = arr[l];
        arr[l] = arr[maxi];
        arr[maxi] = swap;

        int r = arr.length-1;
        l++;
        while(l<r){
            int temp =  arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
