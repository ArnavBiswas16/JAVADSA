import java.util.HashMap;
import java.util.Map;

class CountOccurrencesAnagrams {
    public static void main(String[] args) {
        String str = "orfforfro";
        String ptrn = "ffor"; 
        int n = ptrn.length();  
        int count =0;
        int mapSize = 0;

        Map<Character, Integer> m  = new HashMap<Character, Integer>();

        for(int i = 0; i < n; i++){
            char c= ptrn.charAt(i); 
            if(m.containsKey(c)){
                m.put(c, m.get(c)+1);
            } else {
                m.put(c, 1);
            }
        }
        mapSize = m.size();

        int i=0;
        for(int j = 0; j < str.length(); j++){

            if(j-i+1 <= n){

                char c= str.charAt(j); 
                if(m.containsKey(c)){
                    m.put(c, m.get(c)-1);
                }
                if(m.get(c) == 0){
                    mapSize--;
                } 
            } else {

                if(mapSize == 0){
                    count ++;
                }
                char c= str.charAt(i); 
                if(m.containsKey(c)){
                    m.put(c, m.get(c)+1);
                }
                if(m.get(c) == 1){
                    mapSize++;
                }
                i++;

                c= str.charAt(j); 
                if(m.containsKey(c)){
                    m.put(c, m.get(c)-1);
                } 
                if(m.get(c) == 0){
                    mapSize--;
                } 
            }
        }
        System.out.println(count);
    }
    
}
