/*
 * @Author: lsd
 * @Date: 2020-02-15 17:52:27
 * @Software: vscode
 * @Description: 
 */
package cn.andios.lc;

public class Test70 {
    
    public static void main(String[] args) {
        System.out.println(climbStairs4(10));;
    }

    //无优化，timeout
    public static int climbStairs1(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return climbStairs1(n - 1) + climbStairs1(n -2 ) ;
    }

    //自底向上
    //比如输入10，会先计算sum[3],sum[4]...sum[8],sum[9]，每次计算的结果保存在数组里
    public static int climbStairs2(int n) {
        int[] sum = new int[n + 1];
        sum[1] = 1;
        if(n == 1){
            return sum[1];
        }
        sum[2] = 2;
        if(n == 2){
            return sum[2];
        }
        for (int i = 3; i <= n; i++) {
            sum[i] = sum[i - 1] + sum[i-2];
        }
        return sum[n];
    }

    //自顶向下
    //比如输入10，根据10计算sum[9],sum[8]....sum[2],sum[1]，每次计算的结果保存在数组里
    public int climbStairs3(int n) {
        int[] sum = new int[n + 1];
        
        return climbStairs3_(n,sum);
    }
    
    private int climbStairs3_(int n,int[] sum){
        sum[1] = 1;
        if(n == 1){
            return sum[1];
        }
        sum[2] = 2;
        if(n == 2){
            return sum[2];
        }
        if(sum[n] == 0){
            sum[n] = climbStairs3_(n - 1,sum) + climbStairs3_(n - 2,sum);
        }
        return sum[n];
    }

    //减少消耗空间
    public static int climbStairs4(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int one = 1,two = 2,sum = 0;
        for(int i = 3;i <= n; i ++){
            sum = one + two;
            one = two;
            two  =sum;
        }
        return sum;
    }

    //2个变量
    public static int climbStairs5(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int one = 1,sum = 2;
        for(int i = 3;i <= n; i ++){
            sum = one + sum;
            one = sum - one;
        }
        return sum;
    }
}