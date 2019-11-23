package algorithm;
/**
 * @date 11.21
 * @author xiaoqi
 * @��Ŀ������һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��
 */
public class Test125 {
	/*
	 * ָ����ײ
	 */
	  public static boolean isPalindrome(String s) {
	        int n = 0, m = 0;
	        // ��תСд
	        s = s.toLowerCase();
	        // תΪ�ַ�����
	        char[] ch = s.toCharArray();
	        // ���������ַ�
	        for(int i = 0;i<ch.length;i++) {
	        	if( ('0' <= ch[i] && ch[i] <='9') || ('a'<=ch[i]&& ch[i] <= 'z')) {
	        		ch[n++] = ch[i];
	        	}
	        }
	        n--;
	        // �ƶ���ָ�룬����Ⱦ���false
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
