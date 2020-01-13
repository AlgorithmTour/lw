package cn.andios;
/**
 * 26,27,80,283
 * @author LSD
 *
 * @datetime 2019年10月8日下午8:24:11
 *
 */
public class Test283 {
	public static void moveZeroesDoublePointIfAllElementIs0(int[] nums) {
		/**
		 * 	利用双指针i,j，开始都指向nums[0]，
		 * i从0到nums.length-1遍历nums,
		 * j从0开始，记录nums中不为0的元素，因此j一定<=i
		 * 
		 * 	如果nums[i] == 0 
		 * 		i后移,j不动
		 * 	如果nums[i] != 0
		 * 		将nums[i]与nums[j]交换(这样做就不用专门把后面的元素赋为0)
		 * 		j ++;i ++
		 * 	
		 * 	但还需考虑特殊情况，如果nums中所有元素都不为0，那么nums[i]与nums[j]就不需要交换
		 *	 直到i的位置到数组末尾：i == nums.length-1,nums[j,i)全为0 
		 */
		int i=0,j=0;
		while(i<nums.length) {
			if(nums[i] == 0) {
				i ++;
			}else {
				//如果所有元素都不为0，那么i,j就不需要交换，此时直接++
				if(nums[j] == nums[i]) {
					j ++;
					i ++;
				}else {
					int temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
					j ++;
					i ++;
				}	
			}
		}
	}
	public static void moveZeroesDoublePointWithOutAssign0(int[] nums) {
		/**
		 * 	利用双指针i,j，开始都指向nums[0]，
		 * 
		 * nums[i] == 0 
		 * 	i后移,j不动
		 * nums[i] != 0
		 * 	将nums[i]与nums[j]交换,这样做就不用专门把后面的元素赋为0
		 * 	j ++;i ++
		 * 	直到i的位置到数组末尾：i == nums.length-1,nums[j,i)全为0 
		 */
		int i=0,j=0;
		while(i<nums.length) {
			if(nums[i] == 0) {
				i ++;
			}else {
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				
				j ++;
				i ++;
			}
		}
	}
	public static void moveZeroesDoublePoint(int[] nums) {
		/**
		 * 利用双指针i,j，开始都指向nums[0]，
		 * 
		 * nums[i] == 0 
		 * 	i后移,j不动
		 * nums[i] != 0
		 * 	nums[j] = nums[i]
		 * 	j ++;i ++
		 * 直到i的位置到数组末尾：i == nums.length-1,nums[j,i)全赋值为0
		 * 
		 * 
		 * nums[0]是否为0没有影响
		 * 	nums[0]为0
		 * 		i后移，如果i指向的元素为0，i后移，j不动
		 * 			    如果i指向的元素不为0，该元素移到j的位置，j后移；i继续后移...
		 * 	nums[0]不为0
		 * 		i后移，j也后移，如果i指向的元素为0，i后移，j不动
		 * 			    如果i指向的元素不为0，i后移，j也后移；
		 * 直到i的位置到数组末尾：i == nums.length-1,nums[j,i)全赋值为0
		 */
		int i=0,j=0;
		while(i<nums.length) {
			if(nums[i] == 0) {
				i ++;
			}else {
				nums[j] = nums[i];
				j ++;
				i ++;
			}
		}
		//非0元素移到前面后，后面的元素全置为0
		for(int k = j; k<nums.length;k ++) {
			nums[k] = 0;
		}
	}
	
	public static void moveZeroes(int[] nums) {
        int count = 0;
        //先遍历，计数有多少个元素不是0
        for(int i =0;i < nums.length;i ++){
            if(nums[i] != 0){
                count ++;
            }
        }
        int index = 0;
        //不是0的元素都要往前移，全部移到0的前面，所以[0,count)存放不是0的元素，[count,nums.length)放0
        for(int j = 0;j< count;j++){
        	//index起始为0，即第一次从nums中第一个元素开始遍历，看它是不是0，是0不用管，不是0，就要赋给nums[0]
            for(int i =index;i < nums.length;i ++){
                if(nums[i] != 0){
                    nums[j] = nums[i];
                    //在nums[i]中找到一个不是0的元素后，下次就要接着这次的下一个元素开始找，所以index要++
                    index = i;
                    index ++;
                    //nums[j]被赋值后，就要换下一个j值再赋值nums[j]，即i的这次循环要终止，因为它已经赋给了当前j的nums[j]
                    break;
                }   
            }
        }
        for(int k =count;k < nums.length;k ++){
            nums[k] = 0;
        }
    }
	//测试
	public static void main(String[] args) {
		int []array = {0,1,0,3,12};
//		moveZeroes(array);
//		moveZeroesDoublePoint(array);
//		moveZeroesDoublePointWithOutAssign0(array);
		moveZeroesDoublePointIfAllElementIs0(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
	}
}
