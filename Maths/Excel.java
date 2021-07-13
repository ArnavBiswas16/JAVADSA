
public class Excel {
    public static void main(String[] args) {
        String str = "BCD";
        double line = 0; 
        for(int i=str.length()-1; i>=0; i--){
            int charAscii = str.charAt(i) - 64;
            double k = Math.pow(26, str.length()-1-i);
            line+= charAscii * k;
        }
        System.out.println(line);
    }
}
