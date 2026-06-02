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
[1,2,3,4]
[2,1,3,4]

2 -> 0
1 -> 1
3 -> 2
4 -> 3

1 -> 1(1)
2 -> 0

*/


class Solution {
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        for (int i =0; i<inorder.length;i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart > preEnd || inStart>inEnd) {
            return null;
        }

        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inorderIndexMap.get(rootValue);

        int leftSize = rootIndex - inStart;

        root.left = build(preorder, preStart+1, preStart+leftSize, inStart, rootIndex-1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, rootIndex +1, inEnd);

        return root;
    }
}
