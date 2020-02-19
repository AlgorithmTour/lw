/*
 * @Author: lsd
 * @Date: 2020-02-19 13:08:58
 * @Software: vscode
 * @Description: 
 */
package cn.andios.lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test102 {
    
    //方法一，非递归
    public List<List<Integer>> levelOrder1(TreeNode14 root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Queue<TreeNode14> linkList = new LinkedList<>();
        linkList.add(root);
        while (!linkList.isEmpty()){
            //count表示每一层的节点数
            int count = linkList.size();
            List<Integer> listTmp = new ArrayList<>();
            while (count >0) {
                TreeNode14 treeNode = linkList.poll();
                listTmp.add(treeNode.val);
                if(treeNode.left != null){
                    linkList.add(treeNode.left);
                }
                if(treeNode.right != null){
                    linkList.add(treeNode.right);
                }
                count --;
            }
            list.add(listTmp);
        }
        return list;
    }

    //方法二，递归
    public List<List<Integer>> levelOrder2(TreeNode14 root) {
        List<List<Integer>> list = new ArrayList<>();
        //结果集  开始遍历的节点  第几层
        helper(list, root, 0);
        return list;
    }
    private void helper(List<List<Integer>> list,TreeNode14 root,Integer depth){
        if(root == null){
            return;
        }
        if(list.size() == depth){
            list.add(new ArrayList<Integer>());
        }
        list.get(depth).add(root.val);
        helper(list, root.left, depth + 1);                              
        helper(list, root.right, depth + 1);                              
    }
    

}

class TreeNode14{
    int val;
    TreeNode14 left;
    TreeNode14 right;
    TreeNode14 (int x) { val = x; }
}