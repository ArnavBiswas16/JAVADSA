
public class Findfirstoccurence {
    public static void main(String[] args) {
        int arr[] ={2,4,4,10,10,10,18,20,30};
        int k=4;
        int res = -1;
        int s =0, e = arr.length-1;
        while(s<=e){
            int mid = s+((e-s)/2);
            if (arr[mid] == k){
                res = mid;
                e=mid-1;
            } else if(arr[mid]>k){
                e=e-1;
            } else{
                s=mid+1;
            }
        }
        System.out.println(res);
    }
}
