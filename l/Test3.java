package cn.andios;

/**
 * 209 3 438 76
 * @author LSD
 *
 * @datetime 2019年11月18日下午18:29:39
 *
 */
public class Test3 {

	/**
	 * 	构造滑动区间[l,r]
	 * 		l为左指针，从0开始，
	 * 		r为右指针，从-1开始
	 * 		所以[l,r]最开始为无效区间
	 * len表示区间[l,r]的长度，由于l,r一直在移动，所以len一直在变化
	 * length表示[l,r]区间的最大长度，即题目所求
	 * 	先分析3个case:
	 * 		字符串为：abcabc,l从a开始，r从左向右，
	 * 			l不动，r向右移：a->b->c，r的下个值为a，与l重复，所以l的下个索引应为2,即b,此时，r接着右移
	 * 		字符串为：abcb,l从a开始，r从左向右，
	 * 			l不动，r向右移：a->b->c，r的下个值为b，与索引1位置值重复，所以l的下个索引应为2,即c,此时，r接着右移
	 * 		字符串为：abcdc,l从a开始，r从左向右，
	 * 			l不动，r向右移：a->b->c->d，r的下个值为c，与索引2位置值重复，所以l的下个索引应为3,即d,此时，r接着右移
	 * 	所以，如果区间[l,r]中不存在(r+1)位置字符时，r++
	 * 		如果区间[l,r]中存在(r+1)位置字符时，l移动到[l,r]区间这个字符的下一位置，[l,r]区间这个字符的索引为：s.indexOf(s.charAt(r),l)
	 * 
	 */
    public static int lengthOfLongestSubstring(String s) {
    	if(s == null) {
    		return 0;
    	}
    	int l = 0, r = -1;//滑动区间[l,r]
    	int len = 0;//滑动区间长度
    	int length = 0;//最终要返回的长度
    	while(l < s.length()) {
    		//r<s.length()-1：因为后面进行r++,要保证r++ < s.length()
    		//s.substring(l, ++r).indexOf(s.charAt(r))== -1：判断区间[l,r]上是否存在(r+1)位置字符
    		if(r<s.length()-1 && s.substring(l, ++r).indexOf(s.charAt(r))== -1) {
    			//如果区间[l,r]上不存在(r+1)位置字符，当前区间长度为 r-l+1
    			len = r-l+1;
    		//如果区间[l,r]上存在(r+1)位置字符
    		}else {
    			if(r>=s.length()-1)
    				break;
    			//l指针右移
    			int index = s.indexOf(s.charAt(r), l);
    			l = index+1;
    		}
    		//在所有动态变化的len中取最大的
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
