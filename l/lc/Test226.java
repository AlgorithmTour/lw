/*
 * @Author: lsd
 * @Date: 2020-02-07 14:03:29
 * @Software: vscode
 * @Description: 
 */
package cn.andios.lc;

import java.util.List;
import java.util.ArrayList;

public class Test226 {
    public static void main(String[] args) {
        //数据
        Integer[] arr = new Integer []{4,2,7,1,3,6,9}; 
        //节点
        List<TreeNode3> datas = new ArrayList<>();
        for (Integer i : arr) {
            if(i != null){
                datas.add(new TreeNode3(i));
            }
        }
        //构建树
        for (int parIndex = 0; parIndex < datas.size() / 2; parIndex++) {
            if(datas.get(parIndex) == null){
                continue;
            }
            datas.get(parIndex).setLeft(datas.get(2 * parIndex + 1));
            if(2 *parIndex + 2 < datas.size()){
                datas.get(parIndex).setRight(datas.get(2 *parIndex + 2));
            }
        }
        BinTree3 binTree = new BinTree3();
        binTree.setRoot(datas.get(0));
        System.out.println("前序遍历：");
        binTree.preOrder();

        TreeNode3 root = invertTree(binTree.getRoot());
        System.out.println("\n翻转后，前序遍历：");
        root.preOrder();
    }
    public static TreeNode3 invertTree(TreeNode3 root) {
        if(root == null){
            return null;
        }
        invertTree(root.getLeft());
        invertTree(root.getRight());
        swap(root,root.getLeft(),root.getRight());
        
        return root;
    }

    public static void swap(TreeNode3 root,TreeNode3 left, TreeNode3 right) {
        if(root == null){
            return;
        }
        TreeNode3 tmp = null;
        tmp = root.getLeft();
        root.setLeft(right);
        root.setRight(tmp);
    }
}

class BinTree3{
    private TreeNode3 root;
    
    public TreeNode3 getRoot(){
        return this.root;
    }

    public void setRoot(TreeNode3 root){
        this.root = root;
    }

    public void preOrder(){
        if(this.root != null){
            root.preOrder();
        }
    }
    public void inOrder(){
        if(this.root != null){
            root.inOrder();
        }
    }
    public void postOrder(){
        if(this.root != null){
            root.inOrder();
        }
    }
}
class TreeNode3 {
    private Integer val;
    private TreeNode3 left;
    private TreeNode3 right;

    TreeNode3(Integer x) { val = x; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode3 getLeft() {
        return left;
    }

    public void setLeft(TreeNode3 left) {
        this.left = left;
    }

    public TreeNode3 getRight() {
        return right;
    }

    public void setRight(TreeNode3 right) {
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
