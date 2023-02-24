package com.lucheng.offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Offer50 {
    public static void main(String[] args) {
        String s = "itwqbtcdprfsuprkrjkausiterybzncbmdvkgljxuekizvaivszowqtmrttiihervpncztuoljftlxybpgwnjb";
        Offer50 offer50 = new Offer50();
        char c = offer50.firstUniqChar(s);
        System.out.println("第一个只出现一次的字符是:"+c);
    }
    public char firstUniqChar(String s) {
        //方法一：采用队列+哈希索引
        Queue<Pair> queue = new LinkedList<>();
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
                queue.offer(new Pair(s.charAt(i),i));
            }else{
                map.put(s.charAt(i),-1);
                if(!queue.isEmpty() && map.get(queue.element().getC()) == -1)
                    queue.poll();
            }
        }
        while(!queue.isEmpty() && map.get(queue.element().getC()) == -1){
                queue.poll();
        }
        return queue.isEmpty() ? ' ':queue.poll().getC();
    }

    class Pair{
        char c;
        int index;
        public Pair(char c,int index){
            this.c = c;
            this.index = index;
        }
        public char getC(){
            return this.c;
        }
        public int getIndex(){
            return this.index;
        }
    }
}
