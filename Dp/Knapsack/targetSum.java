public class targetSum {
    public static void main(String[] args) {
        
        int arr[]={4,2,3};
        int n = arr.length;
        int target =1;
        int range = 0;
        for(int i=0;i <n; i++){
            range+= arr[i];
        }
        int sum = (target+range) /2;
 

        int t[][] = new int[n+1][sum+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i==0 && j==0){
                    t[i][j] = 1;
                } 
                else if(i==0 && j!=0){
                         t[i][j] = 0;
                    }
                else if(j ==0 && i!=0){
                    t[i][j] = 1;
                }
            }
        }


        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){

                if(j< arr[i-1]){
                    t[i][j] = t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j]+t[i-1][j-arr[i-1]];
                }
            }
        }

     

System.out.println(t[n][sum]);
    }
}
