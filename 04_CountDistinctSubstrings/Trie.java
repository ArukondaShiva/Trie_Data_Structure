class Node{

    Node links[] = new Node[26];

    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }

    void put(char ch,Node node){
        links[ch-'a'] = node;
    }

    Node get(char ch){
        return links[ch-'a'];
    }

}

public class Trie{

    private Node root;

    Trie(){
        root = new Node();
    }


    public int countDistinctSubstrings(String word){

        int count = 0;

        for(int i=0;i<word.length();i++){

            Node node = root;

            for(int j=i;j<word.length();j++){

                if(!node.containsKey(word.charAt(i))){
                    count++;
                    node.put(word.charAt(i),new Node());
                }
                node = node.get(word.charAt(i));
            }
        }

        return count+1;
    }


    public static void main(String args[]){

        /*
        count no of distinct substrings including empty string("")
        if string is "abab"
        substrings --> 
        a,ab,abc,abcd
        b,ba,bab
        total --> 7+1("") ==> 8 distinct substrings
         */


        Trie trie = new Trie();

        System.out.println(trie.countDistinctSubstrings("abab"));


    }

}