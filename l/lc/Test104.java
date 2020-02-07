/*
 * @Author: lsd
 * @Date: 2020-02-02 15:28:01
 * @Software: vscode
 * @Description: 这种创建二叉树的方式只能创建完全二叉树
 */
package cn.andios.lc;

import java.util.ArrayList;
import java.util.List;

public class Test104 {
    public static void main(String[] args) {
        //创建树
        BinTree1 binTree = new BinTree1();
        //节点数据
        Integer [] arr = new Integer[]{3,9,20,null,null,15,7};
        List<TreeNode1> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new TreeNode1(arr[i]));
        }

        for (int parIndex = 0; parIndex < list.size() / 2; parIndex++) {
            if(list.get(parIndex) == null){
                continue;
            }
            list.get(parIndex).left = list.get(2 * parIndex + 1);
            if(2 * parIndex + 2 < list.size()){
                list.get(parIndex).right = list.get(2 * parIndex + 2);
            }
        }
        //构建二叉树
        binTree.setTreeNode(list.get(0));

        int x = maxDepth(list.get(0));
        System.out.println("最大深度："+x);
        
        System.out.println("前序遍历:");
        binTree.preOrder();
        
    }
    //求最大深度
    public static int maxDepth(TreeNode1 root) {
        
        if(root == null){
            return 0;
        }
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        return Math.max(lDepth, rDepth) + 1;
    }

}
class TreeNode1 {
    Integer val;
    TreeNode1 left;
    TreeNode1 right;
    
     TreeNode1(Integer x) { val = x; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public cn.andios.lc.TreeNode1 getLeft() {
        return left;
    }

    public void setLeft(cn.andios.lc.TreeNode1 left) {
        this.left = left;
    }

    public cn.andios.lc.TreeNode1 getRight() {
        return right;
    }

    public void setRight(cn.andios.lc.TreeNode1 right) {
        this.right = right;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "TreeNode1{" +
                "val=" + val +
                '}';
    }

    //前序
    public void preOrder(){
        System.out.print(this.val + "\t");
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }

    //中序
    public void inOrder(){
        if(this.left != null){
            this.left.inOrder();
        }
        System.out.print(this.val + "\t");
        if(this.right != null){
            this.right.inOrder();
        }
    }

    //后序
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

class BinTree1{
    private TreeNode1 root;
    public void setTreeNode(TreeNode1 root){
        this.root = root;
    }
    //前序
    public void preOrder(){
        if(this.root != null){
            root.preOrder();
        }
    }
    //中序
    public void inOrder(){
        if(this.root != null){
            root.inOrder();
        }
    }
    //后序
    public void postOrder(){
        if(this.root != null){
            root.postOrder();
        }
    }
}
