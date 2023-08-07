package com.lucheng.大厂真题.华为OD;

import java.util.*;

public class P1309 {
    private static int N;
    private static int M;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //声明一个TreeMap，遍历方式根据key的大小由大到小遍历.key:正整数 value：该正整数重复的次数
        TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        N = scanner.nextInt();
        M = scanner.nextInt();
        for (int i = 0; i < M; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            map.put(B,A+map.getOrDefault(B,0));
            int curCount = 0;
            StringBuilder res = new StringBuilder();
            //遍历map
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(curCount+entry.getValue() < N){
                    for (int j = 0; j < entry.getValue(); j++) {
                        res.append(entry.getKey());
                    }
                    curCount += entry.getValue();
                }else{
                    for (int j = 0; j < N - curCount; j++) {
                        res.append(entry.getKey());
                    }
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
