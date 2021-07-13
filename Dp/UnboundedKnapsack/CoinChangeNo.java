public class CoinChangeNo {
    public static void main(String[] args) {
        int change[] = {1,2,3};
        int sum = 5;
        int n = change.length;

        int t[][] = new int[n+1][sum+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i == 0){
                    t[i][j] = 0;
                } else if(j == 0){
                    t[i][j] = 1;
                }
                if(i ==0 && j == 0){
                    t[i][j] = 1;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if (change[i-1] <= j){
                    t[i][j] = t[i-1][j] + t[i][j- change[i-1]];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

System.out.println(t[n][sum]);

    }
}
