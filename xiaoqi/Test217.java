package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 12/31
 * @author xiaoqi
 * @��Ŀ�� ����һ���������飬�ж��Ƿ�����ظ�Ԫ�ء�
 */
public class Test217 {
	// ������ʹ��set
	public static boolean containsDuplicate(int[] nums) {
		Set set  =  new HashSet<>();
		for(int i = 0;i< nums.length;i++) {
			if(set.contains(nums[i])) {
				return  true;
			}else {
				set.add(nums[i]);
			}
		}
		return false;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 2, 1};
		  System.out.print(containsDuplicate(nums));
	}

}
