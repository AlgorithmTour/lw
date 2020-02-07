/*
 * @Author: lsd
 * @Date: 2020-02-07 17:49:53
 * @Software: vscode
 * @Description: 
 */
package cn.andios.lc;

public class Test101 {
    public static void main(String[] args) {
        
    }

    public boolean isSymmetric(TreeNode5 root) {
        return isMirror(root,root);
    }
    public boolean isMirror(TreeNode5 node1,TreeNode5 node2){
        //都为null
        if(node1 == null && node2 == null){
            return true;
        }
        //都不为null
        if(node1 != null && node2 != null){
            if(node1.val != node2.val){
                return false;
            }
            return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
        }
        //一个为null，一个不为null
        return false;
    }
}

class TreeNode5 {
    int val;
    TreeNode5 left;
    TreeNode5 right;
    TreeNode5(int x) { val = x; }
}