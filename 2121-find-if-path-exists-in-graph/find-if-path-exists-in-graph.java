class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edg : edges){
            adj.get(edg[0]).add(edg[1]);
            adj.get(edg[1]).add(edg[0]);
        }
        boolean[] visited = new boolean[n]; 
        return dfs(adj,visited,source,destination);
    }
    private boolean dfs(List<List<Integer>> adj,boolean[] visi , int crr,int des){
        if(crr == des)return true;
        visi[crr] = true;
        for(int nei : adj.get(crr)){
            if(!visi[nei]){
                if(dfs(adj,visi,nei,des)) return true;
            }
        }
        return false;
    }
}