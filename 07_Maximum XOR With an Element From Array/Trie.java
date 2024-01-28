import java.util.Arrays;

class Node{

    Node links[] = new Node[2];

    Node(){

    }

    boolean containsKey(int bit){
        return links[bit]!=null;
    }

    void put(int bit,Node node){
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

    public int[] maximizeXor(int[] nums, int[][] queries){
        
        int n = nums.length;
        int m = queries.length;

        int[][] offlineQueries = new int[m][3];

        for(int i=0;i<m;i++){
            int temp[] = new int[3];
            temp[0] = queries[i][1];
            temp[1] = queries[i][0];
            temp[2] = i;
            offlineQueries[i] = temp;
        }

        Arrays.sort(offlineQueries,(a,b)->a[0]-b[0]);

        int ind = 0;
        int ans[] = new int[m];

        Trie trie = new Trie();

        for(int i=0;i<m;i++){

            while (ind<n && nums[ind]<=offlineQueries[i][0]) {
                trie.insert(nums[ind]);
                ind++;
            }

            int queryInd = offlineQueries[i][2];

            if(ind!=0){
                int maxi = trie.getMax(offlineQueries[i][1]);
                ans[queryInd] = maxi;
            }
            else{
                int maxi = -1;
                ans[queryInd] = maxi;
            }

        }

        return ans;

    }


    public static void main(String[] args) {
        
        Trie trie = new Trie();

        int[] nums = {0,1,2,3,4};
        int[][] queries = {{3,1},{1,3},{5,6}};

        int ans[] = trie.maximizeXor(nums,queries);

        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }

}