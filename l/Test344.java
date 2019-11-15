package cn.andios;

/**
 * 167 125 344 345 11
 * @author LSD
 *
 * @datetime 2019年11月15日下午6:53:00
 *
 */
public class Test344 {
	
	/**
	 * 	假设 a^b=c
	 * 	则 a^c=b,b^c=a
	 */
	private static void reverseString2(char[] s) {
		int n = s.length;
		int temp;
        for (int i = 0; i < n / 2; i++ ) {
            int j = n - 1 - i;
            //s[i] ^= s[j];
            //s[j] ^= s[i];
            //s[i] ^= s[j];
            temp = s[i] ^ s[j];
            s[i] = (char) (s[i] ^ temp);
            s[j] = (char) (s[j] ^ temp);
        }
        System.out.println(s);
	}

	/**
	 * 	低级做法，记得加非空判断
	 */
    public static void reverseString1(char[] s) {
    	if(s == null || s.length == 0) {
    		return;
    	}
        int i=0,j=s.length-1;
        char temp = 0;
        while(i <=j) {
        	swap(s,i,j,temp);
        	i++;
        	j--;
        }
        System.out.println(s);
    }
	private static void swap(char[] s, int i, int j,char temp) {
		temp = s[i];
		s[i]=s[j];
		s[j]=temp;
		
	}
	public static void main(String[] args) {
		//reverseString1(new char []{'h','e','l','l','o'});
		reverseString2(new char []{'h','e','l','l','o'});
	}
}
