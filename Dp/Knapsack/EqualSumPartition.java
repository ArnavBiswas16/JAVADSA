public class EqualSumPartition {
    public static void main(String[] args) {
        int arr[] = {3,3};
        int n = arr.length;
        int sum=0;
        for(int i=0; i<n; i++){
            sum+=arr[i];
        }
        if(sum%2!=0){
            System.out.println("False");
        } else {
            sum/=2;
            boolean t[][] = new boolean[n+1][sum+1];

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

                    if(arr[i-1]<= j){
                        t[i][j] = t[i-1][j- arr[i-1]] || t[i-1][j];
                    } else {
                        t[i][j] = t[i-1][j];
                    }
                }
            }

            System.out.println(t[n][sum]);


        }

    }
}
