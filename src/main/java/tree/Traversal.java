package main.java.tree;

import java.util.*;

public class Traversal {

    public static List<List<Integer>> levelOrderTraversal(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        int level = 0;
        while (!q.isEmpty()){
            result.add(new ArrayList<>());
            int size = q.size();
            for(int i= 0; i < size; i++){
                TreeNode treeNode = q.poll();
                result.get(level).add(treeNode.val);

                if(treeNode.left != null){
                    q.offer(treeNode.left);
                }
                if(treeNode.right != null){
                    q.offer(treeNode.right);
                }
            }
            level++;
        }
        return result;
    }

    public static List<List<Integer>> levelOrderTraversal2(TreeNode root){
        if(root == null)
            return new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        TreeNode last = root;
        while (!q.isEmpty()){
            TreeNode treeNode = q.poll();
            subList.add(treeNode.val);
            if(treeNode.left != null)
                q.offer(treeNode.left);
            if(treeNode.right != null)
                q.offer(treeNode.right);
            if(treeNode == last){
                result.add(subList);
                last = q.peekLast();
                subList = new ArrayList<>();
            }
        }
        return result;
    }

}
