public class SubsetSum {
    public static void main(String[] args) {
        int arr[] = {2,3,7,8,10};
        int sum = 11;
        int n = arr.length;
        Boolean t[][] = new Boolean[n+1][sum+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){

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
            for(int j=1; j<sum+1; j++){

                if(arr[i-1]<=j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                } else{
                    t[i][j] = t[i-1][j];
                }
            }
            
        }

        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                System.out.print(t[i][j]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
        System.out.println(t[n][sum]);
    }
}
