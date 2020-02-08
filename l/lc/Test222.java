/*
 * @Author: lsd
 * @Date: 2020-02-07 21:31:47
 * @Software: vscode
 * @Description: 
 * 
 *  计算完全二叉树的节点个数，因为是完全二叉树，就要用到完全二叉树的性质：
 *      1. 只有最后一次不满
 *  于是，将整棵树分为 root、root左子树，root右子树三部分，分两种情况：
 *      1.最后一层中root左子树铺满了，那么root左子树是完全二叉树，那么只需递归遍历root右子树求其节点个数
 *      2.最后一层root左子树没铺满，那么root右子树一定是满二叉树，只需对root左子树递归遍历求其节点个数
 *  又对于一个满二叉树，如果层数为1~h层，那么节点个数为2^h-1
 */
package cn.andios.lc;

import java.util.List;
import java.util.ArrayList;


public class Test222 {
    public static void main(String[] args) {
        //数据
        Integer[] arr = new Integer[]{1,2,3,4,5,6};
        List<TreeNode6> datas = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != null){
                datas.add(new TreeNode6(arr[i]));
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
        BinTree binTree = new BinTree();
        binTree.setRoot(datas.get(0));
        System.out.println("前序遍历:");
        binTree.preOrder();

        System.out.println("节点数：" + countNodes2(binTree.root));

    }
    //适合普通树
    public static int countNodes1(TreeNode6 root) {
        if(root == null){
            return 0;
        }
        return countNodes1(root.left) + countNodes1(root.right) + 1;
    }
    //适和完全二叉树
    public static int countNodes2(TreeNode6 root){
        if(root == null){
            return 0;
        }
        int leftLevel = countLevel(root.left);
        int rightLevel = countLevel(root.right);
        //root左子树是满二叉树
        if(leftLevel == rightLevel){
            // return (int)(Math.pow(2,leftLevel)) + countNodes2(root.right);
            // 2的leftLevel次方 即 1左移leftLevel位
            return 1 << leftLevel + countNodes2(root.right);
        }
        //root右子树是满二叉树
        else{
            //return (int)(Math.pow(2,rightLevel)) +countNodes2(root.left);
            return 1 << rightLevel + countNodes2(root.left);
        }

    }
    //计算树的高度
    public static int countLevel(TreeNode6 root){
        int level = 0;
        while(root != null){
            level ++;
            root = root.left;
        }
        return level;
        
    }
}

class BinTree{
    TreeNode6 root;

    public void setRoot(TreeNode6 root){
        this.root = root;
    }
    public TreeNode6 getRoot(){
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

class TreeNode6 {
    Integer val;
    TreeNode6 left;
    TreeNode6 right;

    TreeNode6(Integer x) { val = x; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode6 getLeft() {
        return left;
    }

    public void setLeft(TreeNode6 left) {
        this.left = left;
    }

    public TreeNode6 getRight() {
        return right;
    }

    public void setRight(TreeNode6 right) {
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