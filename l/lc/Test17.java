/*
 * @Author: lsd
 * @Date: 2020-02-12 11:04:53
 * @Software: vscode
 * @Description: 
 */
package cn.andios.lc;

import java.util.List;
import java.util.ArrayList;

public class Test17 {
    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        list.forEach(System.out::println);
    }
    private static String[] digitMap= new String []{
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };

    private static List<String> list;

    public static List<String> letterCombinations(String digits) {
        //非空判断
        if(digits == null || digits.length() == 0){
            return null;
        }
        //结果集
        list = new ArrayList<>();
        //
        findCombination(digits, 0, "");
        return list;
    }

    private static void findCombination(String digits,int index,String s){
        if(index == digits.length()){
            list.add(s);
            return ;
        }
        char c = digits.charAt(index);
        //c-'0'：字符型转整型
        String letters = digitMap[c - '0'];
        for(int i = 0;i < letters.length();i ++){
            findCombination(digits,index + 1,s + letters.charAt(i));
        }
        return;
    } 
}