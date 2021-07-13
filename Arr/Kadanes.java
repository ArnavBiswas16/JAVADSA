
public class Kadanes {
    public static void main(String[] args) {
        int arr[] ={-2,-3,4,-1,-2,1,5,-3};
        int msf = Integer.MIN_VALUE; 
        int meh = 0;
        for(int i=0; i<arr.length; i++){
            meh+=arr[i];

            if(meh<arr[i]){
                meh = arr[i];
            }
            if(msf<meh){
                msf = meh;
            }
        }
        System.out.println(msf);
    }
}
