import java.util.HashMap;

class LongestSubstringWithKUniqueCharacters {
    public static void main(String[] args) {
        char arr[] = {'a','a','b','e','c','b','e','b','e','h', 'a'};
        // char arr[] = {'a','b','c'};
        int k = 3;

        char c;
        int i=0;
        int max = 0;
        int size = 0;
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();

        for(int j=0; j<arr.length; j++){

           
            if(size > k){

                while(size >k){
                    c= arr[i];
                    if(m.get(c) > 1){
                        m.put(c, m.get(c)-1);
                    } else {
                        m.remove(c);
                        size--;
                    }
                    i++;
                }
            } else {

                c= arr[j];

                if(m.containsKey(c)){
                    m.put(c, m.get(c)+1);
                } else {
                    m.put(c,1);
                    size++;
                }
            }
            if(size == k){
                max = Math.max(max, j-i+1);
            }
        }

        System.out.println(max);
    }    
}
