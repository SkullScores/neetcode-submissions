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
    public class treeInfo
    {
        int ht;
        int diam;

        treeInfo(int ht, int diam)
        {
            this.ht=ht;
            this.diam=diam;
        }
    }

    public treeInfo helper(TreeNode root)
    {
        if(root==null)
        {
            return new treeInfo(0,0);
        }

        treeInfo left = helper(root.left);
        treeInfo right = helper(root.right);

        int Ht = Math.max(left.ht,right.ht)+1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int Diam = Math.max(diam3, Math.max(diam1,diam2));

        return new treeInfo(Ht,Diam);
    }

    public int diameterOfBinaryTree(TreeNode root) 
    {
        return helper(root).diam-1;
    }
}
