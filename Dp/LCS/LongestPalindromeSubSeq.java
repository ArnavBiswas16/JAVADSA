public class LongestPalindromeSubSeq {
    public static void main(String[] args) {
        String x = "agbcba";

        StringBuilder input1 = new StringBuilder();
        input1.append(x);
        String y = input1.reverse().toString();
        int m = x.length();

        int t[][] = new int[m+1][m+1];

        for(int i=1; i<m+1; i++){
            for(int j=1; j<m+1; j++){

                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        System.out.println(t[m][m]);
    }
}
