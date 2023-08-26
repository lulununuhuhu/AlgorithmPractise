package com.lucheng.leetcode;

public class Leetcode208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.search("app");     // 返回 False
        trie.startsWith("app"); // 返回 True
        trie.insert("app");
        trie.search("app");     // 返回 True
    }


    static class Trie{
        private Trie[] preTree;

        private boolean isEnd;//是否是单词中最后一个字符
        public Trie(){
            preTree = new Trie[26];
            isEnd = false;
        }
        void insert(String word){
            int len = word.length();
            Trie node = this;
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                //如果树中没有这节点则新建这个节点
                if(node.preTree[c-'a'] == null){
                    node.preTree[c-'a'] = new Trie();
                }
                //节点指针指向最新的这个节点
                node = node.preTree[c-'a'];
            }
            node.isEnd = true;
        }

        void insert(String word,int index,Trie node){
            if(index == word.length())
                return;
            if(preTree[word.charAt(index)-'a'] == null){
                preTree[word.charAt(index)-'a'] = new Trie();
            }
            insert(word,index+1,preTree[word.charAt(index)-'a']);
        }

        boolean startsWith(String word){
            Trie node = this;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                if(node.preTree[word.charAt(i)-'a'] == null)
                    return false;
                node = node.preTree[word.charAt(i)-'a'];
            }
            return true;
        }

        boolean search(String word){
            Trie node = this;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                if(node.preTree[word.charAt(i)-'a'] == null)
                    return false;
                node = node.preTree[word.charAt(i)-'a'];
            }
            return node.isEnd == true?true:false;
        }
        private boolean startsWith(String word,int index){
            if(preTree[word.charAt(index)-'a'] == null )
                return false;
            return index < word.length()? startsWith(word,index+1):true;
        }

        private boolean search(String word,int index){
            if(preTree[word.charAt(index)-'a'] == null )
                return false;
            if(index == word.length()-1){
                for(int i = 0;i< 26;i++){
                    if(preTree[i] != null) return false;
                }
                return true;
            }
            return search(word,index+1);
        }
    }

}
