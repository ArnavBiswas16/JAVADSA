import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Queue;

import javax.management.Query;
class Job{
    int id;
    int deadline;
    int profit;

    Job(int id, int deadline, int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

class JObComparator implements Comparator{
    public int compare(Object o1,Object o2){
        Job j1 = (Job)o1;
        Job j2 = (Job)o2;

        if(j1.deadline == j2.deadline){
            if(j1.profit > j2.profit){
                return -1;
            }
        }
        if(j1.deadline < j2.deadline){
            return -1;
        } else return 1;
    }



}
public class JobSchedule {
    
  
    public static void main(String[] args) {

        ArrayList<Job> jList = new ArrayList<>();
        jList.add(new Job(1, 4, 20));
        jList.add(new Job(2, 1, 10));
        jList.add(new Job(3, 1, 40));
        jList.add(new Job(4, 1, 30));

        Collections.sort(jList, new JObComparator());

        int p = jList.get(0).profit;
        int c = 1;
        for(int i =1; i<jList.size(); i++){
            if(jList.get(i-1).deadline == jList.get(i).deadline){
                continue;
            } else {
                p+=jList.get(i).profit;
                c++;
            }
        }
        System.out.println(p+" profit" + c + " jobs");

    }
}
