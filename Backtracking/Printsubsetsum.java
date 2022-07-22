import java.util.ArrayList;

public class Printsubsetsum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n = arr.length;
        int target = 8;
        ArrayList<Integer> ans = new ArrayList<>();
        subsetsum(0, arr, target, ans);

    }

    public static void subsetsum(int index, int[] arr,  int target, ArrayList<Integer> ans){
        if(index>arr.length-1){
            return;
        }

        subsetsum(index+1, arr,  target, ans);
        ans.add(arr[index]);
        if(checkSum(ans) == target){
            System.out.println(ans);

        }
        subsetsum(index+1, arr, target, ans);
        ans.remove(ans.size()-1);
    }

    static int checkSum(ArrayList<Integer> ans){
        int sum=0;
        for (Integer i: ans) {
            sum+=i;
        }
        return sum;
    }
}
