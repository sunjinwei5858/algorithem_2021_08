package com.sunjinwei.huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合77：https://leetcode-cn.com/problems/combinations/
 * <p>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 *
 * 进阶：如何剪枝？？？ 自己还不是很懂 不是很理解 所以导致没做出来
 */
public class Zuhe_01 {

    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // 鲁棒性
        if (n < 0 || k < 0) {
            return res;
        }
        backTrack(n, k, 1, new LinkedList<Integer>());
        return res;
    }

    private void backTrack(int n, int k, int startIndex, LinkedList<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backTrack(n, k, i + 1, path);
            path.removeLast();
        }
    }

    public List<List<Integer>> combine2(int n, int k) {
        // 鲁棒性
        if (n < 0 || k < 0) {
            return res;
        }
        backTrack2(n, k, 1, new LinkedList<Integer>());
        return res;
    }

    /**
     * 进阶：剪枝
     *
     * @param n
     * @param k
     * @param startIndex
     * @param path
     */
    private void backTrack2(int n, int k, int startIndex, LinkedList<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 剪枝: n-k+1+path.size()
        for (int i = startIndex; i <= n - k + 1 + path.size(); i++) {
            path.add(i);
            backTrack2(n, k, i + 1, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Zuhe_01 zuhe01 = new Zuhe_01();
        List<List<Integer>> combine = zuhe01.combine2(4, 3);
        for (List<Integer> integers : combine) {
            System.out.println(integers.toString());
        }
    }

}
