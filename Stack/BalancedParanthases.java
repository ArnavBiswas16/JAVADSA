import java.util.*;

class BalancedParanthases{
    public static void main(String[] args) {
        String str ="{[()]}{[]}";
        System.out.println( checkBalanced(str)); 
    }

    public static boolean checkBalanced(String str){
        Stack<Character> s = new Stack<Character>();

        for(int i=0; i<str.length(); i++){
            char c= str.charAt(i);
            if(c == '(' || c =='{'||c=='['){
                s.push(c);
                continue;
            }
System.out.println(s);
            if(s.isEmpty()){
                return false;
            }

            char p = s.pop();
            switch(c){
                case '{':
                    if(p!='}'){
                        return false;
                    }
                    break;
                case '[':
                    if(p!=']'){
                        return false;
                     }
                     break;

                case '<':
                    if(p!=')'){
                      return false;
                    }
                    break;
                }
        }
        return s.isEmpty();
    }

}