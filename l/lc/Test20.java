/*
 * @Author: lsd
 * @Date: 2020-01-30 09:46:42
 * @Software: vscode
 * @Description: 
 */
package cn.andios.lc;

import java.util.Stack;

public class Test20 {
    public static void main(String[] args) {
       String s = "](";
       System.out.println(isValid1(s));
    }
    public static boolean isValid1(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        if(s.length() == 1){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        boolean match = false;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else{        
                if(s.charAt(i) == '}' && (stack.size() == 0 || stack.peek() != '{')){
                    return false;
                }
                if(s.charAt(i) == ']' && (stack.size() == 0 || stack.peek() != '[')){
                    return false;  
                }
                if(s.charAt(i) == ')' && (stack.size() == 0 || stack.peek() != '(')){
                    return false;                                          
                }
                stack.pop();
                match = true;
            }
        }
        if(stack.size() != 0){
            match = false;
        }
        return match;
    }
    public static boolean isValid2(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        if(s.length() == 1){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        boolean match = false;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else{    
                if(stack.size() == 0){
                    return false;
                }
                char ch = stack.pop();    
                if(s.charAt(i) == '}' && ch != '{'){
                    return false;
                }
                if(s.charAt(i) == ']' && ch != '['){
                    return false;  
                }
                if(s.charAt(i) == ')' && ch != '('){
                    return false;                                          
                }
                match = true;
            }
        }
        if(stack.size() != 0){
            return false;
        }
        return match;
    }

}