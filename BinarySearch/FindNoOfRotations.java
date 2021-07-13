
public class FindNoOfRotations {
    public static void main(String[] args) {
        int arr[] ={11,12,15,18,2,5,6,8};
        int n = arr.length;
        int s=0, e=arr.length-1;
        if(arr[s]<arr[e]){
            System.out.println(0);
        } else{
            while(s<=e){
                int mid = s+((e-s)/2);
                int next = (mid+1)%n;
                int prev = (mid+n-1)%n;
                if(arr[mid]<arr[next] && arr[mid]<arr[prev]){
                    System.out.println(mid);
                    System.exit(0);
                } else {
                    if(arr[mid]> arr[e]){
                        s=mid+1;
                    } else{
                        e=mid-1;
                    }
                }  
              }
        }
    }
}
