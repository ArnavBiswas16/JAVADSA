import java.util.Arrays;
public class NextPerm {
    public static void main(String[] args) {

        int arr[] = {1,3,5,4,2};
        int i=0, l =  arr.length;

        for(i=l-2; i>=0; i--){
            if(arr[i]< arr[i+1]){
                break;
            }
        }
        int ind = i;

        for(i= l-1; l>=ind; i--){
            if(arr[i]>arr[ind]){
                break;
            }
        }

    
        int temp  = arr[i];
        arr[i] = arr[ind];
        arr[ind] = temp;


        ind++; l--;
        while(ind < l){
            temp = arr[l];
            arr[l] = arr[ind];
            arr[ind] = temp;
            ind++; l--;
        }
System.out.println(Arrays.toString(arr));
    }
}
