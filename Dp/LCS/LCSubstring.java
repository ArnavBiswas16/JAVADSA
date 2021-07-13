public class LCSubstring {

    public static void main(String[] args) {
        String x= "abcd";
        String y= "abmd";

        int m = x.length();
        int n = y.length();

        int t[][] = new int[m+1][n+1];

        int max = 0;
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){

                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                    if(t[i][j] > max){
                        max = t[i][j];
                    }
                } else {
                    t[i][j] = 0;
                }
            }
        }
        System.out.println(max);
    }
}
