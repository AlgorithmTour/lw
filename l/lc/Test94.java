/*
 * @Author: lsd
 * @Date: 2020-02-19 11:48:55
 * @Software: vscode
 * @Description: 
 */
package cn.andios.lc;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Test145 {
    public List<Integer> preorderTraversal(TreeNode12 root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode12> stack = new Stack<>();
        TreeNode12 cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            
            cur = cur.right;
        }
        return list;
    }
}


class TreeNode12{
    int val;
    TreeNode12 left;
    TreeNode12 right;
    TreeNode12 (int x) { val = x; }
}