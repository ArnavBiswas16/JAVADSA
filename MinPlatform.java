import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;  

class schedule{
    int arrival;
    int departure;

    schedule(int arrival, int departure){
        this.arrival = arrival;
        this.departure = departure;
    }
}
 
class TimeComparator implements Comparator{  
    public int compare(Object o1,Object o2){  
    schedule s1=(schedule)o1;  
    schedule s2=(schedule)o2;  
      
    if(s1.departure==s2.departure)  
        return 0;  
    else if(s1.departure>s2.departure)  
        return 1;  
    else  
        return -1;  
    }  
} 
public class MinPlatform {
  
    
    public static void main(String[] args) {
        
        int min = 0;
        ArrayList<schedule> timmingList= new ArrayList<>();
        timmingList.add(new schedule(900, 1000));
        timmingList.add(new schedule(1100, 1200));
        timmingList.add(new schedule(1235, 1240));
        // timmingList.add(new schedule(1100, 1130));
        // timmingList.add(new schedule(1500, 1900));
        // timmingList.add(new schedule(1800, 2000));

        Collections.sort(timmingList, new TimeComparator());

        Queue<Integer> q= new LinkedList<>();
        q.offer(timmingList.get(0).departure);

        for(int i = 1; i< timmingList.size(); i++){
            if(q.peek()<timmingList.get(i).arrival){
                q.poll();
            }
            q.add(timmingList.get(i).departure);

            min = Math.max(min, q.size());
        }
        System.out.println(min);
    }
}

 

