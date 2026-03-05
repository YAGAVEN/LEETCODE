class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if(root==null)return res;
        dfs(root,"",res);
        return res;
    }
    private void dfs(TreeNode root,String s,ArrayList<String> res){
        if(root==null)return;
        if(root.left==null && root.right==null){
            res.add(s+root.val);
            return;
        }
        dfs(root.left,s+root.val+"->",res);
        dfs(root.right,s+root.val+"->",res);

    }
}