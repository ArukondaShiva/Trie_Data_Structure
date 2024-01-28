class Node{

    Node links[] = new Node[26];
    int countPrefix = 0;
    int countEndsWith = 0;

    Node(){

    }

    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }

    void put(char ch, Node node){
        links[ch-'a'] = node;
    }

    Node get(char ch){
        return links[ch-'a'];
    }

    void increaseEnd(){
        countEndsWith++;
    }

    void increasePrefix(){
        countPrefix++;
    }

    void deleteEnd(){
        countEndsWith--;
    }

    void reducePrefix(){
        countPrefix--;
    }

    int getEnd(){
        return countEndsWith;
    }

    int getPrefix(){
        return countPrefix;
    }

}


public class Trie{

    private static Node root;


    Trie(){
        root = new Node();
    }

    public void insert(String word){

        Node node = root;

        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
               node.put(word.charAt(i),new Node());
            }
            node = node.get(word.charAt(i));
            node.increasePrefix();
        }
        node.increaseEnd();
    }


    public int countWordsEqualTo(String word){
        
        Node node = root;

        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }
            else{
                return 0;
            }
        }

        return node.getEnd();
    }



    public int countWordsStartingWith(String word){

        Node node = root;

        for(int i=0;i<word.length();i++){
           if(node.containsKey(word.charAt(i))){
              node = node.get(word.charAt(i));
           }
           else{
              return 0;
           }
        }

        return node.getPrefix();

    }



    public void erase(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
                node.reducePrefix();
            }
            else{
                return;
            }
        }
        node.deleteEnd();
    }


    public static void main(String args[]){

        Trie trie = new Trie();

        trie.insert("shiva");
        trie.insert("shiva");
        trie.insert("shivaji");
        trie.insert("shivaji");

        String word1 = "shiva";

        System.out.println("count words equal to "+word1+" : "+trie.countWordsEqualTo(word1));

        String word2 = "shivaji";
        System.out.println("count words equal to "+word2+" : "+trie.countWordsEqualTo(word2));

        String word3 = "shiva";
        System.out.println("count words have prefix equal to "+word3+" : "+trie.countWordsStartingWith(word3));


        trie.erase("shiva");

        System.out.println("count words equal to "+word1+" : "+trie.countWordsEqualTo(word1));
        System.out.println("count words have prefix equal to "+word3+" : "+trie.countWordsStartingWith(word3));


    }


}
