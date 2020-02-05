package algorithm;

import java.util.Stack;
import java.util.regex.Pattern;

public class Test150 {
	public static int evalRPN(String[] tokens) {
		// 创建栈
		Stack<Integer> stack = new Stack<>();
		// 遍历
		Integer num1,num2;
		for(int i = 0; i < tokens.length; i++) {
				switch(tokens[i]) {
				case"+": 
					   num1 = stack.pop();
					   num2 = stack.pop();
					   stack.push( num2+num1);break;
				case"-": 
					   num1 = stack.pop();
					   num2 = stack.pop();
					   stack.push( num2-num1);break;
				case"*":
					   num1 = stack.pop();
					   num2 = stack.pop();
					   stack.push( num2*num1);break;
				case"/":
					   num1 = stack.pop();
					   num2 = stack.pop();
					   stack.push( num2/num1);break;
				default: Integer temp = Integer.valueOf(tokens[i]);;
						// 压入栈
						stack.push(temp);
						break;			
			}		 

		}
		
		return stack.pop();
    }
	// 使用正则表达式判断字符串是否能转为数字
//	public static boolean isInteger(String str) { 
//		Pattern pattern = Pattern.compile("-?[0-9]+(.[0-9]+)?");
//        return pattern.matcher(str).matches(); 
//}
	
	    public static int evalRPN2(String[] tokens) {
			// 创建栈
			Stack<Integer> stack = new Stack<>();
			// 遍历
			for(int i = 0; i < tokens.length; i++) {
				//判断是否能转为数字
				if(isInteger(tokens[i])) {
					int temp = Integer.valueOf(tokens[i]);;
					// 压入栈
					stack.push(temp);
					 
				}else {
					int num1 = stack.peek();
					stack.pop();
					int num2 = stack.peek();
					stack.pop();
					int count = 0;
					switch(tokens[i]) {
					case"+": count = num2+num1;break;
					case"-":  count = num2-num1; break;
					case"*": count = num2*num1;break;
					case"/":count = num2/num1; break;
					default: break;
					}
					stack.push(count);
				}		 

			}
			
			return stack.peek();
	    }
		// 使用正则表达式判断字符串是否能转为数字
		public static boolean isInteger(String str) { 
			Pattern pattern = Pattern.compile("-?[0-9]+(.[0-9]+)?");
	        return pattern.matcher(str).matches(); 
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  String[] str = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
	  
	   System.out.println(evalRPN(str));
	}

}
