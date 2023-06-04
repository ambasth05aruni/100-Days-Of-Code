class Solution {
    public int findCircleNum(int[][] isConnected) {
      int V=isConnected[0].length;
int adj[]=new int[V];
int count=0;
for(int i=0;i<V;i++){
if(adj[i]==0){
dfs(i,isConnected,adj);
count++;
}
}
return count;
}
public void dfs(int in,int[][] Con,int[] adj){
if(adj[in]==1){
return;
}
adj[in]=1;
for(int i=0;i<adj.length;i++){
if(Con[in][i]==1 && in!=i){
dfs(i,Con,adj);
}
}
    }
}