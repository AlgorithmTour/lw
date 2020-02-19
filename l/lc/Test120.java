/*
 * @Author: lsd
 * @Date: 2020-02-15 20:35:34
 * @Software: vscode
 * @Description: 
 */
package cn.andios.lc;

import java.util.List;
public class Test120 {

    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        int rows=triangle.size();
        int[] [] dp = new int [rows + 1][rows + 1];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i] [j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
    
}