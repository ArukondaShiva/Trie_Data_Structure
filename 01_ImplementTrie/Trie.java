class Node{
   
   Node links[] = new Node[26];
   boolean flag = false;

   Node(){
   }

   boolean containsKey(char ch){
      return links[ch-'a']!=null;
   }

   void put(char ch,Node node){
      links[ch-'a'] = node;
   }

   Node get(char ch){
      return links[ch-'a'];
   }

   void setEnd(){
      flag = true;
   }

   boolean isEnd(){
      return flag;
   }

}

public class Trie{

   private static Node root;

   Trie(){
      System.out.println("Trie is created");
      root = new Node();
   }

   
   //function for insert a word into the trie
   public static void insert(String word){

       Node node = root;

       for(int i=0;i<word.length();i++){
          if(!node.containsKey(word.charAt(i))){
              node.put(word.charAt(i), new Node());
          }
          node = node.get(word.charAt(i));
       }
       node.setEnd();
   }

    

   //searching a word in a trie
   public static boolean search(String word){

       Node node = root;

       for(int i=0;i<word.length();i++){
         if(!node.containsKey(word.charAt(i))){
            return false;
         }
         node = node.get(word.charAt(i));
       }

       return node.isEnd();

   }


    //to check if there is any words in tries that has prefix "word"
    public static boolean startsWith(String word){
       
        Node node = root;

        for(int i=0;i<word.length();i++){
           if(!node.containsKey(word.charAt(i))){
              return false;
           }
           node = node.get(word.charAt(i));
        }

        return true;
    }



    public static void main(String args[]){

         Trie trie = new Trie();

         trie.insert("shiva");
         
         System.out.println("searching shiva :"+ trie.search("shiva"));
         System.out.println("searching shiv :"+ trie.search("shiv"));

         System.out.println("statts with 'shi' :"+ trie.startsWith("shi"));
         System.out.println("searching with kin:"+ trie.search("kin"));

    }

}