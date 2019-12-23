package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @date 12/23
 * @author xiaoqi
 * @��Ŀ�� ����һ���ַ������뽫�ַ�������ַ����ճ��ֵ�Ƶ�ʽ������С�
	ʾ�� 1:
	����:
	"tree"
	���:
	"eert"
	����:
	'e'�������Σ�'r'��'t'��ֻ����һ�Ρ����'e'���������'r'��'t'֮ǰ�����⣬"eetr"Ҳ��һ����Ч�Ĵ𰸡�
 */
public class Test451 {
	 public static String frequencySort(String s) {
		 char[] sh = s.toCharArray();
		 // ʹ��int�����������ַ����ֵ�Ƶ��
		 int[] freq = new int[256];
	     for (int i = 0;i < sh.length;i++) {
	            freq[sh[i]]++;
	        }
	    
		 Map<Integer, String> map = new HashMap<>();
		 for(int i = 0; i< freq.length;i++) {
			 if(freq[i]!=0) {
				 // ������תΪ�ַ�
				 char ch = (char) i;
				 String str = map.get(freq[i]);
				 // ��Ƶ�ʳ�����ͬ���ַ�ƴ����һ���ڷ���
				 if(str != null) {
					 String strNew = str.concat(build(ch, freq[i]));
					 map.put(freq[i], strNew);
				 }else {
					 map.put(freq[i], build(ch, freq[i]));
				 }
			 }
		 }
		 // ��map��key���� 
		 Integer[] keys = map.keySet().toArray(new Integer[] {});
		 Arrays.sort(keys);
		 StringBuffer sb1 = new StringBuffer();
		 // �������
		 for(int i = keys.length -1; i>=0;i-- ) {
			 sb1.append(map.get(keys[i]));
		 }
		 
		  
		return sb1.toString();
	        
	    }
	 // �õ�һ���ַ����� ���ַ�����ͬһ���ַ���ɣ����ּ��Σ����м�����ͬ���ַ�
	 private static String build(char ch, int times) {
		 String string = Character.toString(ch);
		 StringBuffer res = new StringBuffer(string);
		 int t = 1;
		 while(t < times) {
			 res.append(string);
			 t++;
		 }
		 return res.toString();
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "tree";
		System.out.print(frequencySort(s));
	}

}
