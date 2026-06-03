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

/*
preorder = [1,2,3,4]
inorder = [2,1,3,4]

[2] [3,4]



index 0 in pre order -> root of the entire tree
value 1 in in order -> index 1, value to left is left sub tree, value to right is right sub tree

  1
|. |
2. 3
     | 4

*/


class Solution {
    private int preorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       preorderIndex = 0;

       return buildSubtree(preorder, inorder, 0, inorder.length-1);
    }

    private TreeNode buildSubtree(int[] preorder, int[] inorder, int inorderLeft, int inorderRight) {
        // define base case for recursion

        if(inorderLeft>inorderRight) {
            return null;
        }

        int rootValue = preorder[preorderIndex];
        preorderIndex++;

        TreeNode root = new TreeNode(rootValue);

        int inorderIndex = inorderLeft;

        while(inorderIndex < inorderRight) {
            if(inorder[inorderIndex] == rootValue) {
                break;
            }
            inorderIndex++;
        }

        root.left = buildSubtree(preorder, inorder, inorderLeft, inorderIndex-1);
        root.right = buildSubtree(preorder, inorder, inorderIndex+1, inorderRight);

        return root;

    }

}
