import java.util.HashMap;

class MinWindowSubstr {
    public static void main(String[] args) {
        
        String str = "time to practice";
        String ptr = "tipt";
        int min= Integer.MAX_VALUE;
        
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        int size =0;
        for(int i=0; i<ptr.length(); i++){
            char c= ptr.charAt(i);
            if(m.containsKey(c)){
                m.put(c, m.get(c)+1);
            } else {
                m.put(c, 1);
                size++;
            }
        }
        
        int i=0;
        for(int j=0; j<str.length(); j++){
            
            
            char c = str.charAt(j);
            if(m.containsKey(c)){
                m.put(c,  m.get(c)-1);

                if(m.get(c) == 0){
                    size--;
                }
            }

            if(size ==0){
                while(i<j && size == 0){
                    min = Math.min(min, j-i+1);
System.out.println(min +" "+i+" "+j);
                    char k = str.charAt(i);
                    if(m.containsKey(k)){
                        m.put(k,  m.get(k)+1);
                        if(m.get(k) == 1){
                            size++;
                        }
                    }
                    i++;
                }
            }
        }
        System.out.println(min);
    }
}
