package cn.andios;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 
 * @author LSD
 *
 * @datetime 2019��12��16������8:22:00
 *
 */
public class Test220 {
	/**
	 * i��j��ֵ���Ϊk
	 * nums[i]��nums[j]��ֵ���Ϊt 
	 */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	if(t<0 || k<1 ||nums== null || nums.length == 0)
    		return false;
    	//	����������
    	TreeSet<Long> set = new TreeSet<Long>();
    	
    	//	��������
        for (int i = 0; i < nums.length; i++) {
        	//	ceiling(key)���ҵ�>=key����СԪ��
        	//	�����nums[i]����ҵ����� nums [i] �Ĳ�ľ���ֵС��t��ֵ���ͷ���true
        	Long ceiling = set.ceiling((long)nums[i]-t);
			if(ceiling != null && ceiling <= nums[i]) {
				return true;
			}
			
			//	floor������<=key�����Ԫ��
        	//	�����nums[i]�Ҳ��ҵ����� nums [j] �Ĳ�ľ���ֵС��t��ֵ���ͷ���true
			Long floor = set.floor((long)nums[i]+t);
			if(floor != null && floor >= nums[i]) {
				return true;
			}
			
			//	Ԫ����ӵ�set��
			set.add((long)nums[i]);
			
			//	��ΪҪ��֤����������ֵ���Ϊk��
			//	����k=4,��numsΪ[1,2,4,5,8,10��15],
			//	��i=3ʱ��setΪ[1,2,4,5]����һ��ѭ���ж���i=4���������������Ϊk
			//	��i=4ʱ��setΪ[1,2,4,5,8]����һ��ѭ���ж���i=5�����������������Ϊk�����Ծ�Ҫ��nums�ĵ�1��Ԫ�ش�set��ɾ��
			//	��i=5ʱ��setΪ[2,4,5,8,10]����һ��ѭ���ж���i=6�����������������Ϊk�����Ծ�Ҫ��nums�ĵ�2��Ԫ�ش�set��ɾ��

			if (i >= k) {
	            set.remove((long)nums[i - k]);
	        }
        }
        
        return false;
    }
	public static void main(String[] args) {
		boolean bool = containsNearbyAlmostDuplicate(new int [] {1,5,9,1,5,9}, 2, 3);
		System.out.println(bool);
	}
}
