/*
 * @Author: lsd
 * @Date: 2020-02-07 12:00:57
 * @Software: vscode
 * @Description: 
 */
package cn.andios.lc;

import java.util.List;
import java.util.ArrayList;

public class Test111 {
    public static void main(String[] args) {
        //数据
        Integer[] arr = new Integer [] {1,2};
        //节点
        List<TreeNode2> datas = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != null){
                datas.add(new TreeNode2(arr[i]));
            }else{
                datas.add(null);
            }
            
        }
        //构建树
        for (int parIndex = 0; parIndex < datas.size() / 2;parIndex++) {
            if(datas.get(parIndex) == null){
                continue;
            } 
            datas.get(parIndex).setLeft(datas.get(2 * parIndex +1));
            if(2 * parIndex + 2 < datas.size()){
                datas.get(parIndex).setRight(datas.get(2 * parIndex +2));
            }
        }

        BinTree2 binTree = new BinTree2();
        binTree.setRoot(datas.get(0));

        System.out.println("前序遍历：");
        binTree.preOrder();

        System.out.println("最小深度："  + minDepth(datas.get(0)));
    }
    // 求最小深度
    // 坑：比如节点为[1,2]，即有左子树，没右子树，leftDepth为1，rightDepth为0
    // 如果直接用 Math.min(leftDepth, rightDepth)，会取0，以致左子树被忽略
    // 又如节点为[1,null,2]，即有右子树，没左子树，同理...
    public static int minDepth(TreeNode2 root) {
        if(root == null){
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if(rightDepth == 0 || leftDepth == 0){
            return Math.max(leftDepth, rightDepth) + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
        
    }
    
}
class BinTree2{
    private TreeNode2 root;

    public void setRoot(TreeNode2 root){
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
            root.postOrder();
        }
    }
}

class TreeNode2 {
    Integer val;
    TreeNode2 left;
    TreeNode2 right;
    
    TreeNode2(Integer x) { val = x; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode2 getLeft() {
        return left;
    }

    public void setLeft(TreeNode2 left) {
        this.left = left;
    }

    public TreeNode2 getRight() {
        return right;
    }

    public void setRight(TreeNode2 right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode["+ val+"]";
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