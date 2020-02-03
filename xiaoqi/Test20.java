package algorithm;

import java.util.Stack;

/**
 * @date 2/3
 * @author xiaoqi
 * @��Ŀ������һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��
 */
public class Test20 {
	 public  static boolean isValid(String s) {
		 char[] str = s.toCharArray();
		 Stack<Character> stack = new Stack();
		 char ch ;
		 for(int i = 0;i<str.length;i++) {
			 if(str[i] == '(' || str[i] =='{' || str[i] == '[' ) {
				 // ����ջ��
				 stack.push(str[i]);
			 }else {
				  switch(str[i]) {
				  case ')': ch = '('; break;
				  case '}': ch = '{'; break;
				  case ']': ch = '['; break;
				  default: return false;  // �������ƥ�䣬˵������Ĵ����д��������ַ���ֱ�ӷ���false
				  }
				  if(stack.empty()) {
					  return false; // �����ж�ջ�Ƿ�Ϊ�գ� ��Ϊ�գ���û�п���ƥ��ġ�����false
				  } 
				  char top = stack.peek();// �ó�ջ��Ԫ��
				  
				  if(ch != top) {
					  return false; // ���ջ��Ԫ�ز�ƥ�䣬����false
				  }
				  stack.pop(); // �Ƚ���֮���Ƴ�ջ��Ԫ��
			 }
		 }
		 // ���Ҫ�ж�ջ�Ƿ�Ϊ�գ������Ϊ�գ��򷵻�false
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
