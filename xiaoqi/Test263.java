package algorithm;
/**
 * @date 12/4
 * @author xiaoqi
 * @题目：编写一个程序判断给定的数是否为丑数。丑数就是只包含质因数 2, 3, 5 的正整数。
 * 思路：递归、循环
 */
public class Test263 {
	// 方法一：递归法
	public static boolean isUgly1(int num) {		
			 if(num == 0) {
				 return false;
			 }
			 if(num == 1) {
				  return true;
			 }
			 if(num % 2 == 0) {
				  
				 return isUgly1(num/2);
			 } else if(num % 3 == 0) {
				  return isUgly1(num/3);
			 }else if(num % 5 == 0) {
				  return  isUgly1(num/5);
			 }else {
				 return false;
			 }			 
    }
	// 方法二：循环法
	public static boolean isUgly2(int num) {	
		 if(num == 0) {
			 return false;
		 }
		 if(num == 1) {
			  return true;
		 }
		 while(num != 1 ) {
			 if(num % 2 == 0) {
				 num = num / 2;
			 }else if(num % 3 == 0) {
				 num = num /3;
			 }else if(num % 5 == 0) {
				 num = num /5;
			 }else {
				 return false;
			 }
		 }
		return true;
		 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 14;
		boolean y = isUgly2(x);
		
		System.out.print(y);
		 
	}

}
