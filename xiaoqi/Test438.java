package algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @date 12/1
 * @author xiaoqi
 * @��Ŀ������һ���ַ��� s ��һ���ǿ��ַ��� p���ҵ� s �������� p ����ĸ��λ�ʵ��Ӵ���������Щ�Ӵ�����ʼ������
 * @˼·���������� 
 */
public class Test438 {
     // ����һ��
	 public static List<Integer> findAnagrams(String s, String p) {
		 List<Integer> list1 = new ArrayList<>();// �洢���յĽ����list����
		 // �ж����sС��p�ĳ���ֱ�ӷ���
		  if (s == null || p == null || s.length() < p.length())
	             return list1;
		 // ��������[left, right]
		 int left  = 0,right = p.length() - 1;
		 char[] ch = p.toCharArray();
		 // ����p�ַ�����Ƶ��
		 int arr[] = new int[26]; 
		 int n = 0;
		 while( n  < p.length()) { 
			 arr[ch[n]-'a']++;
			 n++;	 
		 }
		 
	while(right < s.length()) {
		     //����Ƶ��
		     char[] ss = s.substring(left, right+1).toCharArray();
			 int brr[] = new int[26]; 
			 int i= 0;
			 while( i  < p.length()) { 
				 brr[ss[i]-'a']++;
				 i++;	 
			 }
			 
			 // �Ƚ�����������Ƿ���ȣ�������list1�����left.
			 boolean com = compare(arr, brr);
			 if(com) {
				 list1.add(left);
			 }
			 left++;
			 right++;
			  	 
		}
	    	 
		 return list1;   
}
	// ����2  �Ż� ����ʹ���ַ����Ľ�ȡ����
	 public static List<Integer> findAnagrams1(String s, String p) {
		 List<Integer> list1 = new ArrayList<>();// �洢���յĽ����list����
		 // �ж����sС��p�ĳ���ֱ�ӷ���
		  if (s == null || p == null || s.length() < p.length())
	             return list1;
		 // ��������[left, right]
		 int left  = 0,right = p.length() - 1;
		 char[] ch = p.toCharArray();
		 char[] ss = s.toCharArray();
		 // ����p�ַ�����Ƶ�� �� ��p������ͬ��s�е��ַ���Ƶ�� 
		 int arr[] = new int[26]; 
		 int brr[] = new int[26]; 
		 int n = 0;
		 while( n  < p.length()) { 
			 arr[ch[n]-'a']++;
			 brr[ss[n]-'a']++;
			 n++;	 
		 }
		 
		 while(right+1 < s.length()) {
			 // �Ƚ�����������Ƿ���ȣ�������list1�����left.
			 boolean com = compare(arr, brr);
			 if(com) {
				 list1.add(left);
			 }
			 brr[ss[left++] - 'a']--;	 
			 brr[ss[++right] - 'a']++;  	 
		 }
		 // Ҫ�ж����һ�εĴ���ֵ�Ƿ�����
		 if(compare(arr, brr)) {
			 list1.add(left);
		 }
	    	 
		 return list1;   
}
	 public static boolean compare(int[] arr, int[] brr) {
		  for(int i = 0;i<arr.length;i++) {
			  if(arr[i] != brr[i]) {
				  return false;
			  }
		  }
		  return true;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> list = new ArrayList<>();
		list = findAnagrams1(s, p);
		System.out.print(list);
	}

}
