public class ShortestCommonSuperSeq {
    public static void main(String[] args) {
        String x= "acbcf";
        String y= "abcdaf";

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

        m = x.length();
        n = y.length();
        StringBuilder str = new StringBuilder();
        while(m>0 && n>0){

            if(x.charAt(m-1) == y.charAt(n-1)){
                str.append(x.charAt(m-1));
                m--; n--;
            } else {
                if(t[m][n-1] > t[m-1][n]){
                    str.append(x.charAt(n-1));
                    n--;
                } else{
                    str.append(x.charAt(m-1));
                    m--;
                }
            }
        }
        System.out.println(str.reverse());

        while(m>0){
            str.append(x.charAt(m-1));
            m--;
        }
        while(n>0){
            str.append(y.charAt(n-1));
            n--;
        }
        System.out.println(str.reverse());
    }
}
