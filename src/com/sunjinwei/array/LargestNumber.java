package com.sunjinwei.array;

import java.util.Arrays;

/**
 * 最大数 179 虾皮面试题
 * ps：核心解法 利用字符编码 ASCII，利用string类的compareTo方法
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        // 进行排序
        Arrays.sort(strArr, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        if (strArr[0].equals("0")) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            builder.append(strArr[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 30, 34, 5, 9};
        LargestNumber largestNumber = new LargestNumber();

        String s = largestNumber.largestNumber(arr);
        System.out.println(s);

        String s1 = "3";
        String s2 = "10";

        String[] strArr = new String[]{s1, s2};
        Arrays.sort(strArr, (a, b) -> {
                    return a.compareTo(b);
                }
        );

        System.out.println(Arrays.toString(strArr));


    }
}
