package algorithm;
/**
 * @date 11/27
 * @author xiaoqi
 * @题目:给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 思路：滑动窗口
 */
public class Test03 {
	public static int lengthOfLongestSubstring1(String s) {
		char[] ch = s.toCharArray();
		int l = 0,r = -1;// 滑动窗口[l...r];
		int len = 0;
		while(l < ch.length && r+1<ch.length) {
			int index = l; 
			// 检查是否有重复的
			 for(int i = l;i<=r; i++) {	 
				 if(ch[i] == ch[r+1]) {
					index = i;// 记录重复元素的索引
					l = index +1;// 将指针L指向重复元素索引+1的位置
				 }
			 }
			 
			 // 如果没有重复的就r++
			 if(index == l) {
				 r++;
				 len = Math.max(len,r-l+1);
			 }
		}
	 
        return len;
    }
	// 优化 ：使用一个频率的数组来判断是否有重复的
	public static int lengthOfLongestSubstring2(String s) {
		char[] ch = s.toCharArray();
		int ref[]  = new int[256]; // 记录每个字符出现的频率
		int len = 0;
		int l = 0 ,r = -1; // 初始化滑动窗口[l...r]
		while(l < ch.length && r+1 < ch.length) { 
			if(ref[ch[r+1]] == 0) { // 出现的频率为0，r就++
				r++;
				ref[ch[r]]++;
			}else {// 否则就是遇到相同的字符,将l位置字符的频率减一，并且l++
				ref[ch[l]]--;
				l++;
			}
			len = Math.max(len, r-l+1);
		}
		
		return len;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "pwwkew";
		int len = lengthOfLongestSubstring2(s);
		System.out.print(len);
	}

}
