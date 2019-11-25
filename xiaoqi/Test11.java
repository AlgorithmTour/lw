package algorithm;
/**
 * @date 11.25
 * @author xiaoqi
 * @题目：给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * @思路：指针碰撞
 */
public class Test11 {
	public  static int maxArea(int[] height) {
		int len = height.length - 1;// 初始化x轴的长度
		int left = 0, right = height.length -1; // 初始化左右指针
		int v = 0;// 初始化水的体积
		while(len>0 &&left < right) {
			if(height[left] <= height[right]) { // 比较左右指针所指的元素大小，v=较小元素*x轴长度，取得v最大的。
				 if(v < len*height[left]) {
					 v = len*height[left]; 
				 }
				 left++;
				 
			}else {
				if(v < len*height[right]) {
					v = len*height[right];
				}
				right--;	 
			}
			len--;// 每次减少指针len减一。
			
		}
	     return v;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {1,8,6,2,5,4,8,3,7};
		int v = maxArea(height);
		System.out.print(v);
	}

}
