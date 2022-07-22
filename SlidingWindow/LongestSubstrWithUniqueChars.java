import java.util.HashMap;
public class LongestSubstrWithUniqueChars {

   
    public static void main(String[] args) {
        char arr[] = {'a','b','e','a','b','h', 'a'};
        // char arr[] = {'a','b','c'};

        char c;
        int i=0;
        int max = 0;
        int size = 0;
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();

        for(int j=0; j<arr.length; j++){
           
            c = arr[j];
            if(m.containsKey(c)){

                while(m.containsKey(c)){
                    m.remove(arr[i]);
                    size--;
                    i++;
                }
            } 
            m.put(c, 1);
            size++;

            max = Math.max(max, size);
        }

        System.out.println(max);
    }    


}
