/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return 1+Math.max(l,r);
        // Queue<TreeNode> queue = new LinkedList<>();
        // int dpt=0;
        // queue.offer(root);
        // while(!queue.isEmpty()){
        //     int n = queue.size();
        //     dpt++;
        //     for(int i=0;i<n;i++){
        //         TreeNode t = queue.poll();
        //         if(t.left!=null)queue.offer(t.left);
        //         if(t.right!=null)queue.offer(t.right);
        //     }
        // }
        // return dpt;
        
    }
}