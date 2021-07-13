
public class PascalsTri {
    public static void main(String[] args) {
        int n = 6;
            
        for(int line = 1; line <= n; line++)
        {
            
        int C=1;// used to represent C(line, i)
        for(int i = 1; i <= line; i++)
        {
            // The first value in a line is always 1
            System.out.print(C+" ");
            C = C * (line - i) / i;
        }
        System.out.println();
        }
    }
}
