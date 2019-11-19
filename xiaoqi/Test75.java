package algorithm;
/**
 * @date 11.17
 * @author xiaoqi
 * @题目：
 *	给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */
public class Test75 {
	/*
	 * 思路：三路快排，大于1的放在右边，小于1的放在左边，等于1的不动。
	 * 设置三个指针 zero、two、i
	 */
	public static void sortColors(int[] nums) {
        int zero = -1; // zero从-1开始,保证初始化时，没有值
        int two = nums.length;// two从nums.length开始，保证初始化时，没有值
        int temp;
        for(int i = 0;i< two;) {
            temp = nums[i];
             // 如果等于1,i++;
            if(nums[i] == 1) {
                i++;
            }else if(nums[i] == 2) {  // 等于2时，将two指针前一个元素与nums[i]交换位置，且two--           
                nums[i] = nums[two - 1];
                nums[two - 1] = temp;
                two--;
            }else {// 等于0时，将zero指针后一个元素与nums[i]交换位置，且zero++,i++;
                nums[i] = nums[zero + 1];
                zero++;
                nums[zero] = temp;
                i++;
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array [] = {2,0,1,0,2,1};
		sortColors(array);
		for(int i = 0;i<array.length;i++) {
			System.out.print(array[i]);
		}
	}

}
