package cn.andios;

/**
 * 209 3 438 76
 * @author LSD
 *
 * @datetime 2019��11��18������18:29:39
 *
 */
public class Test3 {

	/**
	 * 	���컬������[l,r]
	 * 		lΪ��ָ�룬��0��ʼ��
	 * 		rΪ��ָ�룬��-1��ʼ
	 * 		����[l,r]�ʼΪ��Ч����
	 * len��ʾ����[l,r]�ĳ��ȣ�����l,rһֱ���ƶ�������lenһֱ�ڱ仯
	 * length��ʾ[l,r]�������󳤶ȣ�����Ŀ����
	 * 	�ȷ���3��case:
	 * 		�ַ���Ϊ��abcabc,l��a��ʼ��r�������ң�
	 * 			l������r�����ƣ�a->b->c��r���¸�ֵΪa����l�ظ�������l���¸�����ӦΪ2,��b,��ʱ��r��������
	 * 		�ַ���Ϊ��abcb,l��a��ʼ��r�������ң�
	 * 			l������r�����ƣ�a->b->c��r���¸�ֵΪb��������1λ��ֵ�ظ�������l���¸�����ӦΪ2,��c,��ʱ��r��������
	 * 		�ַ���Ϊ��abcdc,l��a��ʼ��r�������ң�
	 * 			l������r�����ƣ�a->b->c->d��r���¸�ֵΪc��������2λ��ֵ�ظ�������l���¸�����ӦΪ3,��d,��ʱ��r��������
	 * 	���ԣ��������[l,r]�в�����(r+1)λ���ַ�ʱ��r++
	 * 		�������[l,r]�д���(r+1)λ���ַ�ʱ��l�ƶ���[l,r]��������ַ�����һλ�ã�[l,r]��������ַ�������Ϊ��s.indexOf(s.charAt(r),l)
	 * 
	 */
    public static int lengthOfLongestSubstring(String s) {
    	if(s == null) {
    		return 0;
    	}
    	int l = 0, r = -1;//��������[l,r]
    	int len = 0;//�������䳤��
    	int length = 0;//����Ҫ���صĳ���
    	while(l < s.length()) {
    		//r<s.length()-1����Ϊ�������r++,Ҫ��֤r++ < s.length()
    		//s.substring(l, ++r).indexOf(s.charAt(r))== -1���ж�����[l,r]���Ƿ����(r+1)λ���ַ�
    		if(r<s.length()-1 && s.substring(l, ++r).indexOf(s.charAt(r))== -1) {
    			//�������[l,r]�ϲ�����(r+1)λ���ַ�����ǰ���䳤��Ϊ r-l+1
    			len = r-l+1;
    		//�������[l,r]�ϴ���(r+1)λ���ַ�
    		}else {
    			if(r>=s.length()-1)
    				break;
    			//lָ������
    			int index = s.indexOf(s.charAt(r), l);
    			l = index+1;
    		}
    		//�����ж�̬�仯��len��ȡ����
    		length = Math.max(len, length);
    	}
    	return length;       
    }
	public static void main(String[] args) {
		String str = "abcabc";
		int len = lengthOfLongestSubstring(str);
		System.out.println(len);
	}
}
