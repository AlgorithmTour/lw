/*
 * @Author: lsd
 * @Date: 2020-02-08 18:00:06
 * @Software: vscode
 * @Description: 
 * 
 */
package cn.andios.lc;

import java.util.List;
import java.util.ArrayList;

public class Test404 {
    public static void main(String[] args) {
        //数据
        Integer[] arr = new Integer[]{3,9,20,null,null,15,7};
        List<TreeNode9> datas = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != null){
                datas.add(new TreeNode9(arr[i]));
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
        BinTree9 binTree = new BinTree9();
        binTree.setRoot(datas.get(0));
        System.out.println("前序遍历:");
        binTree.preOrder();
        System.out.println("左叶子和：" + sumOfLeftLeaves(datas.get(0)));
    }
    public static int sumOfLeftLeaves(TreeNode9 root) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        //计算左子树
        if(root.left != null){
            //左子节点是叶子结点
            if(root.left.left == null && root.left.right == null){
                sum += root.left.val;
            }else{
                //左子节点不是叶子节点
                sum += sumOfLeftLeaves(root.left);
            }
        
        }
        //计算右子树
        sum += sumOfLeftLeaves(root.right);
        return sum;
           
    }
}

class BinTree9{
    TreeNode9 root;

    public void setRoot(TreeNode9 root){
        this.root = root;
    }
    
    public TreeNode9 getRoot(){
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

class TreeNode9 {
    Integer val;
    TreeNode9 left;
    TreeNode9 right;

    TreeNode9(Integer x) { val = x; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode9 getLeft() {
        return left;
    }

    public void setLeft(TreeNode9 left) {
        this.left = left;
    }

    public TreeNode9 getRight() {
        return right;
    }

    public void setRight(TreeNode9 right) {
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