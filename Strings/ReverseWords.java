
public class ReverseWords {
    public static void main(String[] args) {
        String str = "What is the Date";
        String strArr[] = str.split(" ");
        for(int i=strArr.length-1; i>=0; i--){
            System.out.print(strArr[i]+" ");
        }
    }
}
