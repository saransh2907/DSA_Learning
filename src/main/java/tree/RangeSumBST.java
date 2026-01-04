package main.java.tree;

import java.util.List;

public class RangeSumBST {

    public static void main(String[] args) {
//        Integer[] arr = {3, 5, 7, 10, null, 15, 18};
        Integer[] arr = {1, 3, null, 5, 6, 7, null, 10, null, 13, null, 15, null, 18, null};
        TreeNode tree = TreeNode.buildFromArray(arr);
        System.out.println(tree);
        int sum = rangeSumBST(tree, 6, 10);
//        System.out.println(sum);
    }


    /**
     * Tree order is In order which will give us Sorted  and it is done in order of LNR left -> node -> right
     */
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
