

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Interval{
    int start, end;
    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}
public class MergeOverlapping {
    public static void main(String[] args) {
        Interval arr[]=new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        mergeIntervals(arr);
    }

    static void mergeIntervals(Interval[] interval){

        Stack<Interval> s = new Stack<>();


        // sort the arr according to the start
        Arrays.sort(interval, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });

        s.push(interval[0]);

        for(int i=1; i<interval.length; i++){
            Interval top = s.peek();
            if(top.end< interval[i].start){
                s.push(interval[i]);
            } else if(top.end<interval[i].end){
                top.end = interval[i].end;
                s.pop();
                s.push(top);
            }
        }
        while (!s.isEmpty())
        {
            Interval t = s.pop();
            System.out.print("["+t.start+","+t.end+"] ");
        } 
    }
}
