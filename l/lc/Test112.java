/*
 * @Author: lsd
 * @Date: 2020-02-08 13:28:40
 * @Software: vscode
 * @Description: 
 * 
 *  注意：必须是从根节点到叶子结点的路径
 */
package cn.andios.lc;

public class Test112 {
    public static void main(String[] args) {
        
    }
    public boolean hasPathSum(TreeNode8 root, int sum) {
        if(root == null){
            return false;
        }
        //叶子结点
        if( root.left == null && root.right == null){
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

class TreeNode8 {
    int val;
    TreeNode8 left;
    TreeNode8 right;
    TreeNode8(int x) { val = x; }
}