package algorithm;
/**
 * @date 11.21
 * @author xiaoqi
 * @题目：给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 */
public class Test125 {
	/*
	 * 指针碰撞
	 */
	  public static boolean isPalindrome(String s) {
	        int n = 0, m = 0;
	        // 先转小写
	        s = s.toLowerCase();
	        // 转为字符数组
	        char[] ch = s.toCharArray();
	        // 过滤其他字符
	        for(int i = 0;i<ch.length;i++) {
	        	if( ('0' <= ch[i] && ch[i] <='9') || ('a'<=ch[i]&& ch[i] <= 'z')) {
	        		ch[n++] = ch[i];
	        	}
	        }
	        n--;
	        // 移动两指针，不相等就是false
	        while(m<n) {
	        	 if(ch[m++] != ch[n--]) {
	        		 return false;
	        	 }
	        }
	        return true;
	        
	       

	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "A man, a plan, a canal: Panama";
		boolean bool = isPalindrome(str);
		System.out.print(bool);
	}

}
