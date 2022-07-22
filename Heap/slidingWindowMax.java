package Heap;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class slidingWindowMax {
    public static void main(String[] args) {
        int n = 3;
        int[] arr = {4,2,6,-1,5,9,3};

        PriorityQueue<Integer> p = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i=0; i<arr.length; i++){
            if(p.size()<n){
                p.add(arr[i]);
            }
            
        }
    }
}
