import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;

public class FourSum {
    
    public static void main(String[] args) {
        int arr[] = {4,3,3,4,4,2,1,2,1,1};
        int n= arr.length;
        int target = 9;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(); 
        for(int i=0; i<n-3; i++){
            for(int j=i+1; j<n-2; j++){
                for(int k= j+1; k<n-1; k++){
                    int temp = target - (arr[i] + arr[j]+ arr[k]);
                    int l = search(k+1, n-1, temp, arr);
                    // System.out.println(l);
                    if(l !=-1){
                        ArrayList<Integer> t = new ArrayList<>();
                        t.add(i);
                        t.add(j);
                        t.add(k);
                        t.add(l);

                        res.add(t);
                    }
                }
            }
        }
        // System.out.println(res);
        HashSet<List<Integer>> set = new HashSet<List<Integer>>(res);
        System.out.println(set);
    }

    public static int search(int left, int right, int target, int[] arr){

        while(left<right){
            int mid = left + (right-left)/2;
            System.out.println(left +" "+right+ " "+ mid+ " " + target +" "+arr[mid]);
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid]<target){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }
}
