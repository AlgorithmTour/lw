package cn.andios;

import java.util.Arrays;

/**
 * 167 125 344 345 11
 * 
 * @author LSD
 *
 * @datetime 2019年10月20日下午3:26:57
 *
 */
public class Test125 {
    public static boolean isPalindrome1(String s) {
		s = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
		if (s == null || s.length() == 0) {
			return true;
		}
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (!Character.toString(s.charAt(i)).equalsIgnoreCase(Character.toString(s.charAt(j)))) {
				return false;
			}

			i++;
			j--;
		}
		return true;
    }
    
    public static boolean isPalindrome2(String s) {
    	if(s == null) {
    		return false;
    	}
        int i=0,j=s.length()-1;
        while(i < j ) {
        	if(!Character.isLetterOrDigit(s.charAt(i))){
        		i ++;
        	}else if(!Character.isLetterOrDigit(s.charAt(j))){
        		j --;
        	}else { 
        		if(!Character.toString(s.charAt(i)).equalsIgnoreCase(Character.toString(s.charAt(j))))       		
        			return false; 
        		else{
        			i++;
                	j--;
        		}        	
        	}       	               	
        }
        return true;
    }
	public static void main(String[] args) {
		String str = "**";
		//boolean isPalindrome = isPalindrome1(str);
		boolean isPalindrome = isPalindrome2(str);
		System.out.println(isPalindrome);
	}
}
