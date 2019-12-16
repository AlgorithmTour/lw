package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 12/16
 * @author xiaoqi
 * @题目 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
 * 如果可以变为 1，那么这个数就是快乐数。
 * @思路： 不快乐数就是会出现循环，例如20：  使用hashset
 * 失败的例子(20)
	20 => 4 + 0
	4 => 16
	16 => 1 + 36
	37 => 9 + 49
	58 => 25 + 64
	89 => 64 + 81
	145 => 1 + 16 + 25
	42 => 16 + 4
	20 可以看到, 20再次重复出现了, 所以永远不可能等于1
 * @思路二：不快乐数一定会进入一个循环，则使用弗洛伊德环检测算法判断是否存在循环，来检测是否是快乐数
 */
public class Test202 {
    public static boolean isHappy1(int n) {
    	Set<Integer> set = new HashSet<>();
    	int m =0;
    	while(true) {
    	// 只要n 不为0就一直循环
    	while(n !=0) {
    		m += Math.pow(n%10,2);// 取出个位上的数
    		n = n/10;
    	}
    	// 如果m = 1,就返回true
    	if(m==1) {
    		return true;
    	} 
    	// 如果set中包含m，说明进入了循环，则返回false
    	if(set.contains(m)) {
    		return false;
    	}
    	// 否则 添加m到set中去
    	set.add(m);
    	n = m;
    	m = 0;
    	}	 
    }
     // 方法二：使用弗洛伊德环检测算法，快慢指针，快的计算两次，慢的计算一次，判断快慢结果，如果相等则必定出现环，否则就是快乐数
    public static boolean isHappy2(int n) {
    	int fast = n,slow = n;
    	do {
    		slow = compute(slow);
    		fast = compute(fast);
    		fast = compute(fast);
    		if(fast == 1) {
    			return true;
    		}	
    	}while(fast!= slow);
    	// 否则fast = slow,则存在循环
    	return false;
    }
    public static int compute(int n) {
    	int m = 0;
    	while(n!=0) {
    		m += Math.pow(n%10,2);
    		n = n/10;
    	}
    	return m;	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int a = 20;
		 System.out.print(isHappy2(a));
	}

}
