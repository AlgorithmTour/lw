package algorithm;
/**
 * @date 11/27
 * @author xiaoqi
 * @��Ŀ:����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
 * ˼·����������
 */
public class Test03 {
	public static int lengthOfLongestSubstring1(String s) {
		char[] ch = s.toCharArray();
		int l = 0,r = -1;// ��������[l...r];
		int len = 0;
		while(l < ch.length && r+1<ch.length) {
			int index = l; 
			// ����Ƿ����ظ���
			 for(int i = l;i<=r; i++) {	 
				 if(ch[i] == ch[r+1]) {
					index = i;// ��¼�ظ�Ԫ�ص�����
					l = index +1;// ��ָ��Lָ���ظ�Ԫ������+1��λ��
				 }
			 }
			 
			 // ���û���ظ��ľ�r++
			 if(index == l) {
				 r++;
				 len = Math.max(len,r-l+1);
			 }
		}
	 
        return len;
    }
	// �Ż� ��ʹ��һ��Ƶ�ʵ��������ж��Ƿ����ظ���
	public static int lengthOfLongestSubstring2(String s) {
		char[] ch = s.toCharArray();
		int ref[]  = new int[256]; // ��¼ÿ���ַ����ֵ�Ƶ��
		int len = 0;
		int l = 0 ,r = -1; // ��ʼ����������[l...r]
		while(l < ch.length && r+1 < ch.length) { 
			if(ref[ch[r+1]] == 0) { // ���ֵ�Ƶ��Ϊ0��r��++
				r++;
				ref[ch[r]]++;
			}else {// �������������ͬ���ַ�,��lλ���ַ���Ƶ�ʼ�һ������l++
				ref[ch[l]]--;
				l++;
			}
			len = Math.max(len, r-l+1);
		}
		
		return len;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "pwwkew";
		int len = lengthOfLongestSubstring2(s);
		System.out.print(len);
	}

}
