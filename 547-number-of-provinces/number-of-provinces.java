class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int p = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(isConnected,visited,i);
                p++;
            }
        } 
        return p; 
    }
    private void dfs(int[][] graph,boolean[] visi , int city){
        visi[city]=true;
        for(int j=0;j<graph.length;j++){
            if(graph[city][j]==1 && !visi[j] ){
                dfs(graph,visi,j);
            }
        }
    }
}