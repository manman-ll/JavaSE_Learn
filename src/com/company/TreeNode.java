package com.company;
import java.util.*;
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (){}
    TreeNode(int val){this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode createTree(Integer []array,int index){
        TreeNode treeNode = null;
        if (index<array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            treeNode = new TreeNode(value);
            treeNode.left = createTree(array, 2*index+1);
            treeNode.right = createTree(array, 2*index+2);
            return treeNode;
        }
        return treeNode;
    }

    //迭代层序遍历
    public List<Integer> getLevelList(TreeNode root){
        List<Integer> ret = new ArrayList<Integer>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i=0;i<length;i++){
                TreeNode tempNode = queue.poll();
                ret.add(tempNode.val);
                if(tempNode.left != null) queue.offer(tempNode.left);
                if(tempNode.right != null) queue.offer(tempNode.right);
            }
        }
        return ret;
    }

    //迭代先序遍历
    public List<Integer> getPreList(TreeNode root){
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            ret.add(root.val);
            if(root.right != null) stack.push(root.right);
            if(root.left != null) stack.push(root.left);
        }
        return ret;
    }

    //迭代后序遍历
    public List<Integer> getEndList(TreeNode root){
        ArrayList<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            ret.add(0,root.val);
            if(root.left != null) stack.push(root.left);
            if(root.right != null) stack.push(root.right);
        }
        return ret;
    }

    //迭代中序遍历
    public List<Integer> getMidList(TreeNode root){
        List<Integer> ret = new ArrayList<Integer>();
        if(root == null) return ret;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ret.add(root.val);
            root = root.right;
        }
        return ret;
    }

    //递归先序遍历
    public List<Integer> getPreOrder(TreeNode root){
        List<Integer> ret = new ArrayList<Integer>();
        preOrder(root,ret);
        return ret;
    }
    private void preOrder(TreeNode root,List<Integer> ret){
        if(root==null) return;
        ret.add(root.val);
        preOrder(root.left,ret);
        preOrder(root.right,ret);
    }

    //递归中序遍历
    public List<Integer> getMidOrder(TreeNode root){
        List<Integer> ret = new ArrayList<Integer>();
        midOrder(root,ret);
        return ret;
    }
    private void midOrder(TreeNode root,List<Integer> ret){
        if(root==null) return;
        midOrder(root.left,ret);
        ret.add(root.val);
        midOrder(root.right,ret);
    }

    //递归后序遍历
    public List<Integer> getEndOrder(TreeNode root){
        List<Integer> ret = new ArrayList<Integer>();
        endOrder(root,ret);
        return ret;
    }
    private void endOrder(TreeNode root,List<Integer> ret){
        if(root==null) return;
        endOrder(root.left,ret);
        endOrder(root.right,ret);
        ret.add(root.val);
    }

    //递归层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null) return ret;
        levelOrder(root,0,ret);
        return ret;
    }
    public void levelOrder(TreeNode root,int depth,ArrayList<List<Integer>> ret) {
        if(root == null){
            return;
        }
        if(depth >= ret.size()) ret.add(new ArrayList<Integer>());
        ret.get(depth).add(root.val);
        levelOrder(root.left,depth+1,ret);
        levelOrder(root.right,depth+1,ret);
    }
}
