import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class MaxOfAllSubarr {
    public static void main(String[] args) {
        int arr[] = {1,-2,6,3,-9,0,7,5,-8};
        int k =3;
        ArrayList<Integer> ans= new ArrayList<Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new MyComparator());
        int i=0;

        for(int j=0;j< arr.length; j++){
            if(j-i+1 <= k){
                pq.add(arr[j]);
            } else {

                ans.add(pq.peek());
                if(pq.peek() == arr[i]){
                   pq.poll();
                }
                i++;
                pq.add(arr[j]);
            }
        }
        ans.add(pq.peek());

System.out.println(ans);
    }
}

class MyComparator implements Comparator<Integer>{
              
    
    public int compare(Integer s1, Integer s2) {
        if (s1 < s2)
            return 1;
        else if (s1 > s2)
            return -1;
        return 0;
        }
}