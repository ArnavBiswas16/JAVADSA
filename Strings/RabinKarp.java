package Strings;

public class RabinKarp {
    public static void main(String[] args) {
        String str = "AABAACAADAABAABA";
        String pat = "AABA";
        int patlen = pat.length();

        int patHash = 0, subHash = 0;
        for(int i = 0; i<patlen; i++){
            patHash+= pat.charAt(i);
        } 

        for(int j=0; j<(str.length()-patlen); j++){
            if(j!=str.length()){
                subHash+= str.charAt(j);
            }
            if(j>pat.length()){
                subHash-= str.charAt(j-patlen);
            }
            if(subHash == patHash){
                while(int k <= )
            }
        }
    }
}
