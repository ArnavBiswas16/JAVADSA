package Arr;

import java.io.*;

// Use the array as a hash map. As the array contains only n-1 digits (n=length), we can increase
// the val at index by n.


class DuplicateNplus1 {

   public static void main(String[] args) {
    
    int arr[] = { 0, 2, 3, 0, 3, 6, 6 };

    int n = arr.length;
    for(int i=0; i<n; i++){

        arr[arr[i]%n] += n;
    }

    for(int i=0; i<n; i++){
        if(arr[i] >= n*2){
            System.out.println(i+" ");
        }
    }

   }
}

