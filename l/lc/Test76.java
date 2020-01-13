package cn.andios;

/**
 * 209 3 438 76
 * @author LSD
 *
 * @datetime 2019��11��20������7:58:05
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
        //ת�������飬���������ٶ�
        char[] S=s.toCharArray();
        char[] T=t.toCharArray();
        int[] map=new int[256];//����ASSII����ӳ�䣬��hashmapЧ�ʸ�
        for(int i=0;i<n;i++){
            map[T[i]]++;
        }
        int start=-1;
        int L=0,R=0;//��������[L,R]
        int count=0;//���洰�����Ѿ��ҵ��˶����ַ�
        int min=m+1;
        while(L<=m-n&&R<m){
            map[S[R]]--;
            if(map[S[R]]>=0){
                count++;
            }
            if(count==n){
                while(map[S[L]]<0){//L���������ƶ�
                    map[S[L]]++;
                    L++;
                }
                if(R-L<min){//��¼λ��
                    min=R-L;
                    start=L;
                }
	            map[S[L++]]++;//L��������һλ�������´�Ѱ��
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
	 * 1.���s�Ĵ����а���t����Ԫ�أ���ô������С����Ϊt.length(),���Գ�ʼʱ��iΪ0��jΪt.length()-1,������iΪ0��jΪ-1��
	 * 2.��438һ������������������¼t�ʹ����ڵ�Ԫ�ء�ͬʱ�����˳����ظ������⡣
	 * 3.��������а���t,��ôi���ƣ���С���ڷ�Χ
	 * 	  ��������в�����t,��ôj���ƣ����󴰿ڷ�Χ
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
			//���t��û�д�����߽�i������Ӧ��ֵ��iֱ��++����
			if (t.indexOf(s.charAt(i)) == -1) {
				sArr[s.charAt(i)- 'A']--;
				i++;
				//i++��������ڳ���С��t.length()���򴰿�Ԫ��һ��������t,��ôjҲ++��
				if(j < s.length()-1 && j-i+1<t.length()){
					j++;
					sArr[s.charAt(j)- 'A']++;
				}
			} else {
				//�����а���t
				if (isContain(tArr, sArr)) {
					//����string
					string = s.substring(i, j+1).length() < string.length() ? s.substring(i, j+1) : string;
					//i���ƣ���С����
					sArr[s.charAt(i)- 'A']--;
					i++;				
				}else{
					//�����в�����tʱ���ڱ�֤j��Խ���ǰ���£�j����
					if (j < s.length()-1){
						j++;
						sArr[s.charAt(j)- 'A']++;
					//jԽ��ʱ��ֱ���˳�ѭ��
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
	 * ��ʱ
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
    //s���Ƿ����t
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
