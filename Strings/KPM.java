import java.util.Arrays;

public class KPM {
    public static void main(String[] args) {
        String str = "abxabcabyabcaby";
        String ptt = "abcaby";

        int n = str.length();
        int m = ptt.length();


        int lps[] = new int[m];
        lps[0] = 0;

        // create lps
        int i =0, j =1;

        while(j<m){
            if(ptt.charAt(i) == ptt.charAt(j)){
                lps[j] = i+1;
                i++;
            }
            j++;
        }

        // start matching


        i=0; j=0;
        

        while(i<n){
            if(ptt.charAt(j)== str.charAt(i)){
                j++;
                i++;
            } else {
                if(j !=0){
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
            if(j == m){
                System.out.println("found at "+ (i-j));
                j = 0;
            }
        }

    }
}
