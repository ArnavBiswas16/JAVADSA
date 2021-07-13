
public class pow {
    public static void main(String[] args) {
        int x= 2, y= 3;
        System.out.println(power(x,y));
    }

    public static int power(int x, int y){
        int temp;
        if(y==0){
            return 1;
        }
        temp = power(x, y/2);
        if(y%2 == 0){
            return temp * temp;
        } else {
            return x*temp*temp;
        }
    }
}
