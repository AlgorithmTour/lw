package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 12/16
 * @author xiaoqi
 * @��Ŀ ��дһ���㷨���ж�һ�����ǲ��ǡ�����������
 * һ����������������Ϊ������һ����������ÿһ�ν������滻Ϊ��ÿ��λ���ϵ����ֵ�ƽ���ͣ�Ȼ���ظ��������ֱ���������Ϊ 1��Ҳ����������ѭ����ʼ�ձ䲻�� 1��
 * ������Ա�Ϊ 1����ô��������ǿ�������
 * @˼·�� �����������ǻ����ѭ��������20��  ʹ��hashset
 * ʧ�ܵ�����(20)
	20 => 4 + 0
	4 => 16
	16 => 1 + 36
	37 => 9 + 49
	58 => 25 + 64
	89 => 64 + 81
	145 => 1 + 16 + 25
	42 => 16 + 4
	20 ���Կ���, 20�ٴ��ظ�������, ������Զ�����ܵ���1
 * @˼·������������һ�������һ��ѭ������ʹ�ø������»�����㷨�ж��Ƿ����ѭ����������Ƿ��ǿ�����
 */
public class Test202 {
    public static boolean isHappy1(int n) {
    	Set<Integer> set = new HashSet<>();
    	int m =0;
    	while(true) {
    	// ֻҪn ��Ϊ0��һֱѭ��
    	while(n !=0) {
    		m += Math.pow(n%10,2);// ȡ����λ�ϵ���
    		n = n/10;
    	}
    	// ���m = 1,�ͷ���true
    	if(m==1) {
    		return true;
    	} 
    	// ���set�а���m��˵��������ѭ�����򷵻�false
    	if(set.contains(m)) {
    		return false;
    	}
    	// ���� ���m��set��ȥ
    	set.add(m);
    	n = m;
    	m = 0;
    	}	 
    }
     // ��������ʹ�ø������»�����㷨������ָ�룬��ļ������Σ����ļ���һ�Σ��жϿ����������������ض����ֻ���������ǿ�����
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
    	// ����fast = slow,�����ѭ��
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
