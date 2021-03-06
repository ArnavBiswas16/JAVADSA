public class LCS {
    public static void main(String[] args) {
        String x= "HEAP";
        String y= "PEA";

        int m = x.length();
        int n = y.length();

        int t[][] = new int[m+1][n+1];

        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){

                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        System.out.println(t[m][n]);
    }
}
