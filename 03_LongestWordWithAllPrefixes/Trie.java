class Node{

    Node links[] = new Node[26];
    boolean flag = false;

    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }

    Node get(char ch){
        return links[ch-'a'];
    }

    void put(char ch,Node node){
        links[ch-'a'] = node;
    }

    void setEnd(){
        flag = true;
    }

    boolean isEnd(){
        return flag;
    }

}


public class Trie{

    private Node root;

    Trie(){
        root = new Node();
    }


    public void insert(String word){
        Node node = root;

        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
               node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }

        node.setEnd();

    }


    public boolean checkIfPrefixExists(String word){

       Node node = root;
       boolean flag = true;

       for(int i=0;i<word.length();i++){
         
          if(node.containsKey(word.charAt(i))){
             node = node.get(word.charAt(i));
             flag = flag & node.isEnd();
          }
          else{
            return false;
          }
         
       }
        
       return flag;
    }



    public static void main(String args[]){

        String words[] = {"n","ninja","ninj","ni","nin","ninga"};

        Trie trie = new Trie();

        for(int i=0;i<words.length;i++){
            trie.insert(words[i]);
        }

        String longest = "";


        for(int i=0;i<words.length;i++){

            String word = words[i];

            if(trie.checkIfPrefixExists(word)){
                if(word.length()>longest.length()){
                    longest = word;
                }
                else if(word.length()==longest.length() && word.compareTo(longest)<0){
                    longest = word;
                }
            }

        }

        
        System.out.println(longest);

    }

}