/*
 * @Author: lsd
 * @Date: 2020-02-19 10:48:32
 * @Software: vscode
 * @Description: 
 */
package cn.andios.lc;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Test144 {

    public static void main(String[] args) {
        System.out.println("111");
    }
    public List<Integer> preorderTraversal(TreeNode11 root) {
        List<Integer> list = new ArrayList<>();
        //非空判断
        if(root == null){
            return list;
        }
        //栈
        Stack<Command> stack = new Stack<>();
        //根节点放入栈中
        stack.push(new Command("go",root));

        while(!stack.isEmpty()){
            //取栈顶的command
            Command command = stack.peek();

            if("print".equals(command.str)){
                list.add(stack.pop().treeNode.val);
            }else{  
                //因为用栈，所以需要逆序，前序遍历为 右-左-根
                if(command.treeNode.left != null){
                    stack.push(new Command("go",command.treeNode.left));
                }
                if(command.treeNode.right != null){
                    stack.push(new Command("go",command.treeNode.right));
                }
                stack.push(new Command("print",command.treeNode));
            }
        }
        return list;
    }
}

class Command{
    String str;
    TreeNode11 treeNode;
    public Command(String str, TreeNode11 treeNode){
        this.str = str;
        this.treeNode = treeNode;
    }
}

class TreeNode11{
    int val;
    TreeNode11 left;
    TreeNode11 right;
    TreeNode11 (int x) { val = x; }
}