/*
 * @Author: lsd
 * @Date: 2020-02-07 17:33:20
 * @Software: vscode
 * @Description: 
 */
package cn.andios.lc;

public class Test100 {

    public static void main(String[] args) {
        
    }
    public static boolean isSameTree(TreeNode4 p, TreeNode4 q) {
        //都为null
        if(p == null && q == null){
            return true;
        }
        //都不为null
        if(p != null && q != null){
            if(p.val != q.val){
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        //一个为null一个不为null
        return false;
    }
}

class TreeNode4 {
     int val;
     TreeNode4 left;
     TreeNode4 right;
     TreeNode4(int x) { val = x; }
}