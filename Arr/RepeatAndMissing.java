//Given an unsorted array of size n. Array elements are in the range from 1 to n. One number
// from set {1, 2, …n} is missing and one number occurs twice in the array.
public class RepeatAndMissing {
    public static void main(String[] args) {
        int arr[] = { 7, 3, 4, 5, 5, 6, 2 };
        int n = arr.length;
        
        for(int i=0; i<n; i++){
            arr[(arr[i]-1)%n]+=n; 
        }
        for(int i=0; i<n; i++){
            if(arr[i] > (n+1)*2){
                System.out.println(i+1 +" :Repeated element");
            }
            if(arr[i] < n+1){
                System.out.println(i+1+" :Missing element");

            }
        }

    }
}
