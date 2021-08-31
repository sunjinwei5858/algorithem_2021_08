package com.sunjinwei.sliding_window;

import java.util.HashMap;

/**
 * 无重复字符的最长子串 字节面试题 力扣3
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                // 情况1：abcabc 相同元素在第一个位置
                // 情况2：abcbac 相同元素在第二个位置
                // 所以逻辑都可以统一为 hashMap.get(c)+1
                left = Math.max(left, hashMap.get(c) + 1);
            }
            // 每次都需要更新hashmap
            hashMap.put(c, i);
            // 不断更新max
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
