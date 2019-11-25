package algorithm;
/**
 * @date 11.23
 * @author xiaoqi
 * @题目：编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 思路：指针碰撞
 */
public class Test345 {
	 public static String reverseVowels(String s) {
		 // a、e、i、o、u
		 char[] ch = s.toCharArray();
		 int left = 0,right =  ch.length -1;
		 while(left < right) {
		   int a = 	check(ch[left]);
		   int b = check(ch[right]);
		   System.out.println(a+ " " + b);
			 if(a == 1 && b == 1) {
				 char temp  = ch[left];
				 ch[left++] = ch[right];
				 ch[right--] = temp;		 
			 }else if(a == -1 && b == -1) {
				 left ++;
				 right --;
			 }else if((a ==1) && (b == -1)) {
				 right --;
			 }
			 else {
				 left ++;
			 }
			 System.out.println(left + " " + right);
		 }
		  s =  String.valueOf(ch);
		 
	        return s;
	    }
	 public static int check(char ch1) {
		 if(ch1 == 'a'|| ch1 == 'e'||ch1 == 'i'|| ch1 == 'o'||ch1 =='u' || ch1 == 'A'|| ch1 == 'E'||ch1 == 'I'|| ch1 == 'O'||ch1 =='U' ) {
			 return 1;
		 }
		return -1;
		 
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aA";
		String s2 = reverseVowels(s1);
		System.out.print(s2);
	}

}
