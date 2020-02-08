/*
 * @Author: lsd
 * @Date: 2020-02-08 11:48:05
 * @Software: vscode
 * @Description: 
 */
package cn.andios.lc;

import java.util.List;
import java.util.ArrayList;

public class Test110 {
    public static void main(String[] args) {
        //数据
        Integer[] arr = new Integer[]{1,2,2,3,3,null,null,4,4};
        List<TreeNode7> datas = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != null){
                datas.add(new TreeNode7(arr[i]));
            }else{
                datas.add(null);
            }
        }
        //构建树
        for (int i = 0; i < datas.size() / 2; i++) {
            if(datas.get(i) == null){
                continue;
            }
            datas.get(i).left = datas.get(2 * i + 1);
            if(2 *i + 2 < datas.size()){
                datas.get(i).right = datas.get(2 * i + 2);
            }
        }
        BinTree7 binTree = new BinTree7();
        binTree.setRoot(datas.get(0));
        System.out.println("前序遍历:");
        binTree.preOrder();
        System.out.println("是否为平衡二叉树：" + isBalanced(binTree.getRoot()));
        
    }
    public static boolean isBalanced(TreeNode7 root) {
        if(root == null){
            return true;
        }
        int lDepth = getDepth(root.left);
        int rDepth = getDepth(root.right);

        if(Math.abs(lDepth - rDepth) >1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }
    public static int getDepth(TreeNode7 root){
        if(root == null){
            return 0;
        }
        int lDepth = getDepth(root.left);
        int rDepth = getDepth(root.right);
        return Math.max(lDepth, rDepth) + 1;
    }
}

class BinTree7{
    TreeNode7 root;

    public void setRoot(TreeNode7 root){
        this.root = root;
    }
    
    public TreeNode7 getRoot(){
        return this.root;
    }

    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }
    }
    public void inOrder(){
        if(this.root != null){
            this.root.inOrder();
        }
    }
    public void postOrder(){
        if(this.root != null){
            this.root.postOrder();
        }
    }
}

class TreeNode7 {
    Integer val;
    TreeNode7 left;
    TreeNode7 right;

    TreeNode7(Integer x) { val = x; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode7 getLeft() {
        return left;
    }

    public void setLeft(TreeNode7 left) {
        this.left = left;
    }

    public TreeNode7 getRight() {
        return right;
    }

    public void setRight(TreeNode7 right) {
        this.right = right;
    }

    public void preOrder(){
        System.out.print(this.val + "\t");
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }

    public void inOrder(){
        if(this.left != null){
            this.left.inOrder();
        }
        System.out.print(this.val + "\t");
        if(this.right != null){
            this.right.inOrder();
        }
    }
    public void postOrder(){
        if(this.left != null){
            this.left.postOrder();
        }
        if(this.right != null){
            this.right.postOrder();
        }
        System.out.print(this.val + "\t");
    }
}