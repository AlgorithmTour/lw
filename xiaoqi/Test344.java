package algorithm;
/**
 * @date 11.23
 * @author xiaoqi
 * @��Ŀ����дһ���������������ǽ�������ַ�����ת�����������ַ������ַ����� char[] ����ʽ������
 * @˼·��ָ����ײ
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
