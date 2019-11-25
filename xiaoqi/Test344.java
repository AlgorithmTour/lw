package algorithm;
/**
 * @date 11.23
 * @author xiaoqi
 * @题目：编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * @思路：指针碰撞
 */
public class Test344 {
	   public static char[]  reverseString(char[] s) {
	        int left = 0,right = s.length - 1;
	        while(left < right) {
	        	char temp = s[left];
	        	s[left++] = s[right];
	        	s[right--] = temp;
	         
	        }
	        return s;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] s = {'h','e','l','l','o'};
		char[] news = reverseString(s);
		for(int i = 0;i<news.length;i++) {
			System.out.print(news[i]);
		}
	}

}
