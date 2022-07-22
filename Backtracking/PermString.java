
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermString {
    public static void main(String[] args) {
        
        String str = "ABC";
        ArrayList<ArrayList<Character>> ans = new ArrayList<>();
        ArrayList<Character> ds = new ArrayList<>();

        boolean freq[] = new boolean[str.length()]; 
        recurPermute(str, ans, ds, freq);

        System.out.println(ans);

    }

    static void recurPermute(String str, ArrayList<ArrayList<Character>> ans, ArrayList<Character> ds,boolean freq[]){
        if(ds.size() == str.length()){
            System.out.println(ds);
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0; i<str.length(); i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(str.charAt(i));
                recurPermute(str, ans, ds, freq);
                freq[i] = false;
                ds.remove(ds.size()-1);
            }
        }
    }
}
