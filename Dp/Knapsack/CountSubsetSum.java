public class CountSubsetSum {
    public static void main(String[] args) {
        int arr[] ={4,6,2,8,11};
        int sum = 10;
        int n = arr.length;
        int t[][] = new int[n+1][sum+1];

        for(int i=0 ;i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i==0 && j ==0){
                    t[i][j] =1;
                } else if(i==0 && j!=0){
                    t[i][j] =0;
                }else if(i!=0 && j==0){
                    t[i][j] =1;
                }
            }
        }

        for(int i=1 ;i<n+1; i++){
            for(int j=1; j<sum+1; j++){

                if(arr[i-1] > j){
                    t[i][j] = t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j] + t[i-1][j- arr[i-1]];
                }
               
            }
        }

        System.out.println(t[n][sum]);
    }
}
