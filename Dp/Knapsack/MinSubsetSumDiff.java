import java.util.ArrayList;

public class MinSubsetSumDiff {
    public static void main(String[] args) {
        int arr[] = {1,2,7};
        int range =0;
        int n =arr.length;
        for(int i=0;i<n; i++){
            range+=arr[i];
        }

        boolean t[][] = new boolean[n+1][range+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<range+1; j++){
                if(i==0 && j==0){
                    t[i][j] = true;
                } 
                else if(i==0 && j!=0){
                         t[i][j] = false;
                    }
                else if(j ==0 && i!=0){
                    t[i][j] = true;
                }
            }
        }


        for(int i=1; i<n+1; i++){
            for(int j=1; j<range+1; j++){

                if(j< arr[i-1]){
                    t[i][j] = t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j]||t[i-1][j-arr[i-1]];
                }
            }
        }

        ArrayList<Integer> r= new ArrayList<Integer>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i< (range+1)/2; i++){
            // System.out.print(t[n][i]);
            if(t[n][i] == true){

                r.add(i);
            }
        }

        for(int i=0; i< r.size(); i++){
            int diff = range - 2*r.get(i);
            if(diff < min){
                min = diff;
            }
        }
        System.out.println(min);

    }
}
