package com.sunjinwei.heap;

import java.util.PriorityQueue;

/**
 * 1046. 最后一块石头的重量
 * <p>
 * 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * <p>
 * ps:
 * 1.每次都跳出最重的两块石头 然后粉碎，如果还有差值 那么将差值继续放入
 * 2.可以使用最大堆来处理,java的优先级队列
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        // 默认是最小堆 堆顶是最小值
        // 此时要变成最大堆 堆顶是最大值 那么传入比较器 (a,b)->b-a
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() > 1) {
            Integer a = queue.poll();
            Integer b = queue.poll();
            int c = Math.abs(a - b);
            if (c != 0) {
                queue.offer(c);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
