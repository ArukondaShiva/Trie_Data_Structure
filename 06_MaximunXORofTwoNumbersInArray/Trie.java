class Node{
    
    Node links[] = new Node[2];

    boolean containsKey(int bit){
        return links[bit]!=null;
    }

    void put(int bit, Node node){
        links[bit] = node;
    }

    Node get(int bit){
        return links[bit];
    }

}

public class Trie{

    private Node root;

    Trie(){
        root = new Node();
    }


    public void insert(int num){

        Node node = root;

        for(int i=31;i>=0;i--){
            int bit = (num>>i) & 1;
            if(!node.containsKey(bit)){
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }

    }


    public int getMax(int num){

        Node node = root;

        int maxNum = 0;

        for(int i=31;i>=0;i--){
            
            int bit = (num>>i) & 1;

            if(node.containsKey(1-bit)){
                maxNum = maxNum | (1<<i);
                node = node.get(1-bit);
            }
            else{
                node = node.get(bit);
            }

        }

        return maxNum;
        
    }


    public static void main(String[] args) {

        Trie trie = new Trie();
        
        int arr1[] = {6,8};
        int arr2[] = {7,8,2};

        int n = arr1.length;
        int m = arr1.length;

        for(int i=0;i<n;i++){
            trie.insert(arr1[i]);
        }

        int maxXOR = 0;

        for(int i=0;i<m;i++){
            int curXOR = trie.getMax(arr2[i]);
            maxXOR = Math.max(maxXOR, curXOR);
        }

        System.out.println(maxXOR);

    }

}
