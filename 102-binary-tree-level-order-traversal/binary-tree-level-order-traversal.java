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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode t = queue.poll();
                level.add(t.val);
                if(t.left != null)queue.offer(t.left);
                if(t.right != null)queue.offer(t.right);
            }
            result.add(level);
        }
        return result;
        
    }
}