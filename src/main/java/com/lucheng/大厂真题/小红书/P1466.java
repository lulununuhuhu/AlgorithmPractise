package com.lucheng.大厂真题.小红书;

import java.util.*;

/**
 * 基本思路：DFS
 *  以每个景点为起点，进行两次DFS。如果超过时间，则剪枝；如果不能进行两次DFS，也返回
 */
public class P1466 {
    private static long ans = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//景点数
        int m = scanner.nextInt();//路径数
        int k = scanner.nextInt();//最大交通时间
        int[] Happy = new int[n+1];
        int[] Time = new int[n+1];
        List<Map<Integer,Integer>> graph = new ArrayList<>(n+1);
        for (int i = 0; i < n + 1; i++) {
            graph.add(i,new HashMap<>());
        }
        for (int i = 1; i <= n; i++) {
            Happy[i] = scanner.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            Time[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.get(u).put(v,w);
            graph.get(v).put(u,w);
        }
        for (int i = 1; i <n+1; i++) {
//            dfs(graph,Happy,Time,i,-1,1,k,Time[i],Happy[i]);
        }

        System.out.println(ans);
    }

    /**
     * 方法一：dfs 但是会超时
     * @param graph
     * @param happy
     * @param time   每个景点游览所需时间
     * @param i      当前游览的景点
     * @param fa     当前景点的上一个景点
     * @param counts 当前已遍历的景点个数
     * @param k      最大交通时间
     * @param t      到当前景点并参观需要花的时间
     * @param h   到达当前景点将获得的快乐值
     */
    private static void dfs(List<Map<Integer, Integer>> graph, int[] happy, int[] time, int i, int fa, int counts, int k, int t, long h) {
        if(k <= t)  {
            return;
        }
        if(counts == 3) {
            ans = Math.max(ans,h);
            return;
        }
        for (Map.Entry<Integer, Integer> edge : graph.get(i).entrySet()) {
            int nextPoint = edge.getKey();
            if(nextPoint == fa) continue;
            int timeValue = edge.getValue();
            dfs(graph,happy,time, nextPoint, i,counts+1,k,t+time[nextPoint]+timeValue,h+happy[nextPoint]);
        }
        ans = Math.max(ans,h);
    }

    /**
     * 枚举+二分
     * @param graph
     * @param happy
     * @param time
     */
    private static void EnumerationBinary(List<Map<Integer, Integer>> graph,int[] happy, int[] time,int k){
        //先枚举只浏览一个景点
        for (int i = 1; i <= happy.length; i++) {
            if(time[i] <= k)
                ans = Math.max(ans,happy[i]);
        }

        //再枚举浏览两个景点
        for (int i = 1; i <= graph.size(); i++) {
            for (Map.Entry<Integer, Integer> entry : graph.get(i).entrySet()) {
                int times = time[i]+time[entry.getKey()]+ entry.getValue();//两个景点所花时间=两个景点的浏览时间+景点之间的道路所花时间
                if(times <= k)
                    ans = Math.max(ans,times);
            }
        }

        //最后枚举三个景点
        // 1. 枚举每个点，列出去相邻景点的景点名称和所花时间（道路时间+景点浏览时间之和）的键值对,按所花时间由小到大排列
        // 2. 在键值对中枚举第二个景点，保证第二个和第一个加起来所花时间不超过k。两个之和为sum
        // 3. 在剩余键值对中采用二分法找到找到所花时间不超过k-sum的最大位置j，然后依次遍历j及之前的键值对，找出最大happy值

    }
}
