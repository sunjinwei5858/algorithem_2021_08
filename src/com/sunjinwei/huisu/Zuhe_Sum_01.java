package com.sunjinwei.huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和39
 * 给定一个无重复元素的正整数数组candidates和一个正整数target，
 * 找出candidates中所有可以使数字和为目标数target的唯一组合。
 * candidates中的数字可以无限制重复被选取。
 * 如果至少一个所选数字数量不同，则两种组合是唯一的。 
 * 对于给定的输入，保证和为target的唯一组合数少于150 个。
 */
public class Zuhe_Sum_01 {

    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return res;
        }
        backTrack(candidates, target, 0, new LinkedList<>());
        return res;
    }

    /**
     * 因为这里是重复选取 所以每次递归传入i 那么终止条件 startIndex 永远不会等于candidates的length，该终止条件可以不需要
     *
     * @param candidates
     * @param target
     * @param startIndex
     * @param path
     */
    private void backTrack(int[] candidates, int target, int startIndex, LinkedList<Integer> path) {
        // 终止条件1
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 终止条件2
        if (target < 0) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            // 可以无限制重复选取
            backTrack(candidates, target - candidates[i], i, path);
            path.removeLast();
        }
    }

    /**
     * 剪枝
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return res;
        }
        backTrack2(candidates, target, 0, new LinkedList<>());
        return res;
    }

    private void backTrack2(int[] candidates, int target, int startIndex, LinkedList<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            // 这里进行剪枝!!!!! 效率非常明显
            if (candidates[i] > target) {
                continue;
            }
            path.add(candidates[i]);
            backTrack2(candidates, target - candidates[i], i, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Zuhe_Sum_01 zuhe02 = new Zuhe_Sum_01();
        int[] arr = new int[]{2, 3, 5};
        List<List<Integer>> res = zuhe02.combinationSum(arr, 8);
        for (List<Integer> re : res) {
            System.out.println(re.toString());
        }
    }

}
