import java.util.PriorityQueue;

public class StreamMedian {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    StreamMedian(){
        max = new PriorityQueue<>((a,b)->b-a);
        min = new PriorityQueue<>((a,b)->a-b);
    }
    public static void main(String[] args) {
        
       StreamMedian streamMedian = new StreamMedian();

        streamMedian.insert(3);
        streamMedian.insert(1);
        streamMedian.insert(5);
        streamMedian.insert(4);

        System.out.println(streamMedian.findMedian());

    }

    public  void insert(int n){

        if(max.isEmpty() || n<max.peek()){
            max.add(n);
        } else{
            min.add(n);
        }

        if(max.size() > min.size()+1){
            min.add(max.poll());
        } 

        else if(min.size()>max.size()){
            max.add(min.poll());
        }
    }

    public  double findMedian(){

        if(max.size() == min.size()){
            return max.peek()/2.0 + min.peek()/2.0;
        } else {
            return max.peek();
        }
    }
}
