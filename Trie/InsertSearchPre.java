
public class InsertSearchPre {
    public static void main(String[] args) {
        
        Trie t = new Trie();
        // t.insert("apple");
        // t.insert("apple");

        // System.out.println(t.search("appl"));
        // System.out.println(t.startsWith("appl"));
        // System.out.println(t.countWordsStartWith("ap"));
        // System.out.println(t.searchCount("apple"));
        String[] arr = {"n","ni","nin","ninj","ninja","ninjaa"};
        // String[] arr = {"an","nc"};

        // System.out.println( t.completeWord(arr, t));
        System.out.println(t.distinctSubStr("abab", t));
    }
}

class Node{

    Node links[] = new Node[26];
    boolean isEnd; 
    private int prefixCnt;
    private int endCnt;


    public int getEndCnt() {
        return endCnt;
    }

    public int getPrefixCnt() {
        return prefixCnt;
    }

    boolean containsKey(char ch){
        return(links[ch -'a'] != null);
    }

    void put(char ch){
        links[ch - 'a'] = new Node();
    }

    Node get(char ch){
        return links[ch -'a'];
    }

    void increasePreCount(){
        prefixCnt++;
    }

    void increaseEndCount(){
        endCnt++;
    }

    public void setEnd() {
        this.isEnd = true;
    }
    
}

class Trie {

    private static Node root;
    
    Trie(){
        root = new Node();
    }

    public void insert(String str){
      Node node = root;  
      for(int i=0; i<str.length(); i++){
        if(!node.containsKey(str.charAt(i))){
            node.put(str.charAt(i));
        }
        node = node.get(str.charAt(i));
        node.increasePreCount();
      }
      node.increaseEndCount();
      node.setEnd();
    }

    // public void erase(String str){

    // } 

    public boolean search(String str){

        Node node = root;
        for(int i=0; i<str.length(); i++){
            if(node.containsKey(str.charAt(i))){
                node = node.get(str.charAt(i));
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    public int searchCount(String str){
        Node node = root;
        for(int i=0; i<str.length(); i++){
            if(node.containsKey(str.charAt(i))){
                node = node.get(str.charAt(i));
            } else {
                return 0;
            }
        }
        return node.getEndCnt();
    }

    public boolean startsWith(String str){
        Node node = root;
        for(int i=0; i<str.length(); i++){
            if(node.containsKey(str.charAt(i))){
                node = node.get(str.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }

    public int countWordsStartWith(String str){
        Node node = root;
        for(int i=0; i<str.length(); i++){
            if(node.containsKey(str.charAt(i))){
                node = node.get(str.charAt(i));
            } else {
                return 0;
            }
        }
        return node.getPrefixCnt();
    }

    public String completeWord(String[] strArr, Trie t){

        String ans = null;
        for(String str: strArr){

            t.insert(str);
        }

        outer:
        for(String str: strArr){

             
            for(int i = 0; i<str.length(); i++){

                if(!t.search(str.substring(0, i+1))){
                    continue outer;
                }
            }

            if(ans == null){
                ans = str;
            } else {
                if(ans.compareTo(str) < 0){
                    ans = str;
                }
            }
        }
        return ans;
    }

    public int distinctSubStr(String str, Trie t){

        int count=0;
        for(int i=str.length()-1; i>=0; i--){
            for(int j=i; j<str.length(); j++){
                System.out.println(str.substring(i, j+1));
                if(!t.search(str.substring(i, j+1))){
                    t.insert(str.substring(i, j+1));
                    count++;
                }
            }
            
        }
        return count;
    }
}

