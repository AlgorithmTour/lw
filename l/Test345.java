package cn.andios;

public class Test345 {

	/**
	 * 	注意：非空判断不是返回null,而是""
	 * 	元音：aeiouAEIOU而不是aeiou
	 * @param s
	 * @return
	 */
    public static String reverseVowels(String s) {
        if(s == null || s.length() == 0)
        	return "";
        String str = "aeiouAEIOU";
        char [] str1 = s.toCharArray();
    	
        int i=0,j=str1.length -1;
        
        while(i <j) {
        	if(str.indexOf(str1[i])== -1) {
        		i++;
        	}else if(str.indexOf(str1[j])== -1) {
        		j --;
        	}else {
        		str1[i] ^=str1[j];
        		str1[j] ^=str1[i];
        		str1[i] ^=str1[j];
       		
        		i++;
        		j--;
        	}
        }

        return new String(str1);
    }
	public static void main(String[] args) {
		String s = "leetcode";
		String str = reverseVowels(s);
		System.out.println(str);
	}
}
