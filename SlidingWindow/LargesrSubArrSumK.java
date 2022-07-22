class LargesrSubArrSumK {
    public static void main(String[] args) {
        int arr[] = {4,1,1,1,1,1,3,5};
        int n=5;
        int i=0, j=0;
        int max=0;
        int subArraySum=0;

        for( j=0; j<arr.length; j++){

            subArraySum+= arr[j];
            if(subArraySum == n){
                max= Math.max((j-i+1), max);
            }

            if(subArraySum > n){
                subArraySum-= arr[i];
                i++;
            }
            
        }

System.out.println(max);
    }
}
