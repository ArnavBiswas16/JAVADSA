package queue;

import java.util.LinkedList;

public class Queue {

    public static LinkedList<Object> que = new LinkedList<>();

    public static Queue createQueue(){

        return new Queue();
    }

    public void enqueue(Object val){
        que.addLast(val);
    }

    public Object deque(){
        return que.removeFirst();
    }

    public Object seek(){
        return que.getFirst();
    }
}
