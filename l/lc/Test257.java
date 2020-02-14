/*
 * @Author: lsd
 * @Date: 2020-02-14 13:53:55
 * @Software: vscode
 * @Description: 
 */


package cn.andios.lc;

import java.util.List;
import java.util.ArrayList;

public class Test257 {
    public static void main(String[] args) {
        //数据
        Integer[] arr = new Integer[]{1,2,3,null,5};
        List<TreeNode10> datas = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != null){
                datas.add(new TreeNode10(arr[i]));
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
        BinTree10 binTree = new BinTree10();
        binTree.setRoot(datas.get(0));
        System.out.println("前序遍历:");
        binTree.preOrder();
        binaryTreePaths(datas.get(0)).forEach(System.out::print);
    }
    public static List<String> binaryTreePaths(TreeNode10 root) {
        List<String> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        if(root.left == null && root.right == null){
            list.add(root.val.toString());
            return list;
        }
        
        List<String> listL = binaryTreePaths(root.left);
        for (int i = 0; i < listL.size(); i++) {
            list.add(root.val.toString() + "->" + listL.get(i));
        };

        List<String> listR = binaryTreePaths(root.right);
        for (int i = 0; i < listR.size(); i++) {
            list.add(root.val.toString() + "->" + listR.get(i));
        };
        return list;
    }
}


class BinTree10{
    TreeNode10 root;

    public void setRoot(TreeNode10 root){
        this.root = root;
    }
    
    public TreeNode10 getRoot(){
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

class TreeNode10 {
    Integer val;
    TreeNode10 left;
    TreeNode10 right;

    TreeNode10(Integer x) { val = x; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode10 getLeft() {
        return left;
    }

    public void setLeft(TreeNode10 left) {
        this.left = left;
    }

    public TreeNode10 getRight() {
        return right;
    }

    public void setRight(TreeNode10 right) {
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