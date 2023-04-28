class Solution {
    public int numSimilarGroups(String[] strs) {
       int cnt=0;
        boolean vis[]=new boolean[strs.length];
        for(int i=0;i<strs.length;i++){
            if(!vis[i]){
                vis[i]=true;
                cnt++;
                Queue<String> q=new LinkedList<>();
                q.add(strs[i]);
                while(!q.isEmpty()){
                    String x=q.poll();
                    for(int j=0;j<strs.length;j++){
                        if(!vis[j] && isSimilar(x,strs[j])){
                            vis[j]=true;
                            q.add(strs[j]);
                        }
                    }
                }
            }
        }
        return cnt;
    }
    private boolean isSimilar(String x,String y){
        int diff=0;
        for(int i=0;i<x.length() && diff<3;i++)
           if(x.charAt(i)!=y.charAt(i))    diff++;
        return diff<3;
    }
}