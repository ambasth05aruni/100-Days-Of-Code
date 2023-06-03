class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n==1) {
            return 0;
        }        
        Node[] nodes = new Node[n];        
        for (int i=0; i < n; i++) {
            if (nodes[i] == null) {
                nodes[i] = new Node(i, informTime[i]);
            }            
            if (i != headID) {
                if(nodes[manager[i]] == null) {
                    nodes[manager[i]] = new Node(manager[i], informTime[manager[i]]);
                }
                nodes[manager[i]].adjacent.add(nodes[i]);
            }
        }
        
        return dfs(nodes[headID]);
    }
    
    int dfs(Node node) {
        if (node == null) {
            return 0;
        }
        int accumulatedTime = 0;
        for (Node child : node.adjacent) {
            accumulatedTime = Math.max(accumulatedTime, dfs(child));
        }
        accumulatedTime += node.time;
        return accumulatedTime;
    }
    
    class Node {
        int ix;
        int time;
        List<Node> adjacent = new ArrayList<>();
        
        Node (int ix , int time) {
            this.ix = ix;
            this.time = time;
        }
    }
}