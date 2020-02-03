package algorithm;

import java.util.Stack;

/**
 * @date 2/3
 * @author xiaoqi
 * @题目：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 */
public class Test20 {
	 public  static boolean isValid(String s) {
		 char[] str = s.toCharArray();
		 Stack<Character> stack = new Stack();
		 char ch ;
		 for(int i = 0;i<str.length;i++) {
			 if(str[i] == '(' || str[i] =='{' || str[i] == '[' ) {
				 // 推入栈中
				 stack.push(str[i]);
			 }else {
				  switch(str[i]) {
				  case ')': ch = '('; break;
				  case '}': ch = '{'; break;
				  case ']': ch = '['; break;
				  default: return false;  // 如果都不匹配，说明输入的代码中存在其他字符，直接返回false
				  }
				  if(stack.empty()) {
					  return false; // 首先判断栈是否为空， 若为空，则没有可以匹配的。返回false
				  } 
				  char top = stack.peek();// 拿出栈顶元素
				  
				  if(ch != top) {
					  return false; // 如果栈顶元素不匹配，返回false
				  }
				  stack.pop(); // 比较完之后，移除栈顶元素
			 }
		 }
		 // 最后要判断栈是否为空，如果不为空，则返回false
		if(stack.empty()) {
			return true;
		}
		return false;  
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "([";
		System.out.print(isValid(s));
	}

}
