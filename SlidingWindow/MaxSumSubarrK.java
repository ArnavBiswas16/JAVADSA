class MaxSumSubarrK {
    public static void main(String[] args) {
        int arr[] = {9,1,3,2,7,8,5};
        int i =0, k = 3;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int j =0; j<arr.length; j++){
            if(j-i+1 <= k){
                sum+= arr[j];
            } else {
                sum= sum - arr[i] + arr[j];
                i++;
                maxSum = Math.max(maxSum, sum);
            }
            
        }

        System.out.println(maxSum);
    }
}
