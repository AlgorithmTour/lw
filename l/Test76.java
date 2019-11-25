package cn.andios;

/**
 * 209 3 438 76
 * @author LSD
 *
 * @datetime 2019年11月20日下午7:58:05
 *
 */
public class Test76 {
	
	/**
	 * 3ms
	 */
	public static String minWindow3(String s, String t) {
		int m=s.length(),n=t.length();
        if(m<n){
            return "";
        }
        //转化成数组，提升查找速度
        char[] S=s.toCharArray();
        char[] T=t.toCharArray();
        int[] map=new int[256];//利用ASSII码做映射，比hashmap效率高
        for(int i=0;i<n;i++){
            map[T[i]]++;
        }
        int start=-1;
        int L=0,R=0;//滑动窗口[L,R]
        int count=0;//保存窗口里已经找到了多少字符
        int min=m+1;
        while(L<=m-n&&R<m){
            map[S[R]]--;
            if(map[S[R]]>=0){
                count++;
            }
            if(count==n){
                while(map[S[L]]<0){//L尽量往左移动
                    map[S[L]]++;
                    L++;
                }
                if(R-L<min){//记录位置
                    min=R-L;
                    start=L;
                }
	            map[S[L++]]++;//L继续右移一位，进行下次寻找
	            count--;
            }
            R++;
        }
        if(min<m+1){
            return s.substring(start,start+min+1);
        }
        return "";
	}
	/**
	 * 164ms
	 * 
	 * 1.如果s的窗口中包含t所有元素，那么窗口最小长度为t.length(),所以初始时，i为0，j为t.length()-1,而不是i为0，j为-1。
	 * 2.与438一样，还是用数组来记录t和窗口内的元素。同时解决了顺序和重复的问题。
	 * 3.如果窗口中包含t,那么i右移，缩小窗口范围
	 * 	  如果窗口中不包含t,那么j右移，增大窗口范围
	 * 
	 */
	public static String minWindow2(String s, String t) {
		if (s == null || s.length() < t.length() || t.length() == 0) {
			return "";
		}
		int i = 0, j = t.length()-1;
		String string = new String(s + "a");
		int[] tArr = new int[58];
		int[] sArr = new int[58];
		for (int k = 0; k < t.length(); k++) {
			tArr[t.charAt(k) - 'A']++;
			sArr[s.charAt(k) - 'A']++;
		}
		while (i < s.length() - t.length() + 1) {
			//如果t中没有窗口左边界i索引对应的值，i直接++即可
			if (t.indexOf(s.charAt(i)) == -1) {
				sArr[s.charAt(i)- 'A']--;
				i++;
				//i++后，如果窗口长度小于t.length()，则窗口元素一定不包含t,那么j也++，
				if(j < s.length()-1 && j-i+1<t.length()){
					j++;
					sArr[s.charAt(j)- 'A']++;
				}
			} else {
				//窗口中包含t
				if (isContain(tArr, sArr)) {
					//更新string
					string = s.substring(i, j+1).length() < string.length() ? s.substring(i, j+1) : string;
					//i右移，缩小窗口
					sArr[s.charAt(i)- 'A']--;
					i++;				
				}else{
					//窗口中不包含t时，在保证j不越界的前提下，j右移
					if (j < s.length()-1){
						j++;
						sArr[s.charAt(j)- 'A']++;
					//j越界时，直接退出循环
					}else {
						break;
					}	
				}					
			}

		}
		if (string.length() == s.length() + 1) {
			string = "";
		}
		return string;
	}

	public static boolean isContain(int[] t,int[] s) {
		for (int i = 0; i < t.length; i++) {
			if (t[i] != 0 && t[i] > s[i])
				return false;
		}
		return true;
	}
	/**
	 * 超时
	 */
    public static String minWindow1(String s, String t) {
    	if(s == null || s.length() < t.length()|| t.length() == 0) {
    		return "";
    	}
    	int i=0,j=0;
    	String string = new String(s+"a");
    	String str = null;
    	int [] tArr = new int[58];
    	for (int k = 0; k < t.length(); k++) {			
			tArr[t.charAt(k)-'A']++;			
		}
    	while(i<s.length()-t.length()+1) {
    		if(j < s.length()) {   			
    			if(t.indexOf(s.charAt(i)) == -1) {
    				i++;
    				j = i-1;
    			}else {
    				str = s.substring(i,++j);
	    			if(isContain(tArr,str)) {
		    			i ++;
		    			j = i -1;
		    			string = str.length() < string.length()?str:string;
	    			}	
    			}	
    		}else {
    			i++;
    			j=i-1;
    		}		
    	}
    	if(string.length() == s.length()+1) {
    		string = "";
    	}
        return string;
    }
    //s中是否包含t
    public static boolean isContain(int [] t,String s) {
    	int [] sArr = new int[58];
    	for (int k = 0; k < s.length(); k++) {
			sArr[s.charAt(k)-'A']++;
		}
    	for (int i = 0; i < t.length; i++) {
			if(t[i] !=0 && t[i] > sArr[i])
				return false;
		}
    	return true;
    }
	public static void main(String[] args) {
 		System.out.println(minWindow1("ADOBECODEBANC", "BANC"));
 		System.out.println(minWindow2("ADOBECODEBANC", "BANC"));
 		System.out.println(minWindow3("ADOBECODEBANC", "BANC"));
	}
}
