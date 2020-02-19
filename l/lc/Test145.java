package cn.andios.lc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test145 {
    public static void main(String[] args) {
        
    }
    public List<Integer> postorderTraversal(TreeNode13 root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<Command1> stack = new Stack<>();
        stack.push(new Command1("go", root));
        while(!stack.isEmpty()){
            Command1 command = stack.pop();
            if("print".equals(command.str)){
                list.add(command.treeNode.val);
            }else{
                stack.push(new Command1("print", command.treeNode));
                if(command.treeNode.right != null){
                    stack.push(new Command1("go", command.treeNode.right));
                }
                if(command.treeNode.left != null){
                    stack.push(new Command1("go", command.treeNode.left));
                }
            }
        }
        return list;
    }
}

class TreeNode13{
    int val;
    TreeNode13 left;
    TreeNode13 right;
    TreeNode13 (int x) { val = x; }
}

class Command1{
    String str;
    TreeNode13 treeNode;
    public Command1(String str,TreeNode13 treeNode){
        this.str = str;
        this.treeNode = treeNode;
    }
}