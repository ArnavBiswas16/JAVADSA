
public class StockBuySell {
    public static void main(String[] args) {
        int arr[] = {2,6,7,1,3,2,1};
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0; i<arr.length; i++){
            min = Math.min(min, arr[i]);
             max = Math.max(max, (arr[i]-min));
        }
        System.out.println(max);
    }
}
