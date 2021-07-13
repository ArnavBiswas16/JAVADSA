
public class StockBuySell {
    public static void main(String[] args) {
        int arr[] = {7,6,1,4,5};
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<min){
                min = arr[i];
            } 
            if (max< arr[i] - min){
                max = arr[i]-min;
            }
        }
        System.out.println(max);
    }
}
