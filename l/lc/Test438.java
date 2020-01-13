package cn.andios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 209 3 438 76
 * @author LSD
 *
 * @datetime 2019��11��19������7:23:11
 *
 */
public class Test438 {

	/**
	 * ��Ϊ������ĸ˳��ֻ���ǰ�����ͬ����ĸ���������������洢��
	 * ֻ��¼������ĸ���ڵĴ�����������˳��
	 */
    public static List<Integer> findAnagrams2(String s, String p) {    	
    	 List<Integer> list = new ArrayList<>();
         if (s == null || p == null || s.length() < p.length())
             return list;
         //��¼p�е���ĸ
         int [] pArr = new int[26];
         //��¼s�е���ĸ
         int [] window = new int[26];

         for (int i=0; i<p.length(); i++){
        	 //��¼p������Щ�ַ�
        	 pArr[p.charAt(i) - 'a']++;     
        	 //��¼s�г��� Ϊp.length(),��������Ϊ[i,j]����ĸ���ж���һ�����Ƿ���pArr��ȡ�
        	 //�����ȣ���ʾ�ҵ���
        	 //������ȣ��������һλ
             window[s.charAt(i) - 'a']++;
         }

         //�̶���ȵĴ���[i,j]������Ϊp.length(),��s��0����λ�ÿ�ʼ
         int i = 0;
         int j = p.length()-1;

         //�����ұ߽绬��s�ұ߽�֮ǰ
         while (j+1 < s.length()){
        	 //���p�봰��[i,j]��Ԫ����ͬ����i����list
             if (isSame(pArr, window))
                 list.add(i);
             //���p�봰��[i,j]��Ԫ�ز�ͬ����������һλ��
             //��i��j��++����iλ��ֵҪȥ����j+1λ��ֵҪ�ӵ�window��
             window[s.charAt(i++) - 'a']--;
             window[s.charAt(++j) - 'a']++; 
         }
         //�������һ������ʱ��j�Ƶ���s��ĩβ����ʱ������ѭ����û�о���ѭ���е�if�жϣ���������Ҫ��һ��
         if (isSame(pArr, window))   // �����ĩβ�� p.length() ���ַ��Ƿ��������
             list.add(i);
         
         return list;
    }
	
    public static boolean isSame(int[] arr1, int[] arr2){
        for (int i=0; i<arr1.length; ++i)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }

	//��ʱ
    public static List<Integer> findAnagrams1(String s, String p) {
    	if(s == null || s.length() < p.length()) {
    		return new ArrayList<Integer>();
    	}
        List<Integer> list = new ArrayList<Integer>();
        
        List<Character> list2 = new ArrayList<Character>();
        
        fillList(list2, p);
        
        int l=0,r=-1;//��������[l,r]
        int len=0;//��¼����������Ԫ�صĸ���
        
        while(l < s.length()-p.length()+1) {
        	if(r+1 < s.length()) {
        		if(list2.indexOf(s.charAt(++r)) == -1){
        			if(list2.size() != p.length())
        				fillList(list2, p);
	        		l = s.indexOf(s.charAt(r), l)+1;
	        		r = l-1;
        		}else{  
	        		len = r-l+1;
	        		list2.remove(new Character(s.charAt(r)));
	        		if(len == p.length() && list2.size() == 0) {
	        			fillList(list2, p);
	        			list.add(l);
	        			l ++;
	        			r = l-1;
	        		}
	        	}        		
        	}
        	
        }
        return list;
    }
    public static void fillList(List<Character> list,String p) {
    	list.clear();
    	for (int i = 0; i < p.length(); i++) {
			list.add(p.charAt(i));
		}
    }
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abe";
		//List<Integer> list1 = findAnagrams1(s, p);
		List<Integer> list2 = findAnagrams2(s, p);
		list2.forEach(System.out::println);
		
	}
}
