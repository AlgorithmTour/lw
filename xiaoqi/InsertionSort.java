package algorithm;
/**
 * @date 11.20
 * @author xiaoqi
 * @插入排序
 * 思想：从第二个元素开始，找到其正确的位置（只要前面的元素大于自己，前面的元素就向后移一位）
 */
public class InsertionSort {
	public static int[] insertionSort(int[] arr) {
		for(int i = 1;i<arr.length;i++) {
			 int current = arr[i]; // 注意保存要插入的元素，否则后面的 arr[preIndex+1] = arr[preIndex]会覆盖该值
			 int preIndex = i -1;// 当前元素的前一个元素的指针
			 // 只要当前的元素小于前面的元素，就将前面的元素后移一位，并且preIndex指针--,
			 while(preIndex >= 0 && arr[preIndex] >  current) {
				 arr[preIndex+1] = arr[preIndex]; 
				 preIndex--;
			 }
			 arr[preIndex + 1] = current;
		}
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9,4,2,4,6,7,2};
		int[] newArr = insertionSort(arr);
		for(int i = 0;i<newArr.length;i++) {
			System.out.print(newArr[i] + " ");
		}
		

	}

}
