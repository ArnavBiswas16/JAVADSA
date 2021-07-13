public class Rodcutting {
    public static void main(String[] args) {
        int p[] = {2,3,5,7,8};
        int l[] = {1,2,3,4,5};
        int n = 5;

        int t[][] = new int[p.length+1][n+1];

        for(int i=1;i<p.length+1;i++){
            for(int j=1;j<n+1;j++){

                if(l[i-1] <= j){
                    t[i][j] = Math.max(p[i-1] + t[i][j-l[i-1]], t[i-1][j]);
                } else {
                    t[i][j]= t[i-1][j];
                }
            }
        }

        System.out.println(t[p.length][n]);
    }
}
