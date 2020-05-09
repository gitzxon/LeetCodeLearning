package study.tree.ImplementTrie;

import java.util.*;

class Trie {

    private static class TrieNode {
        boolean isEndOfWord = false;
        HashMap<Character, TrieNode> map = new HashMap<>();
    }

    TrieNode root = new TrieNode();


    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {

        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!cur.map.containsKey(c)) {
                cur.map.put(c, new TrieNode());
            }

            cur = cur.map.get(c);
        }
        cur.isEndOfWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode trieNode = find(root, word);

        return trieNode != null && trieNode.isEndOfWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode trieNode = find(root, prefix);
        return trieNode != null;
    }

    private TrieNode find(TrieNode node, String s) {
        TrieNode cur = node;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cur.map.containsKey(c)) {
                cur = cur.map.get(c);
            } else {
                return null;
            }
        }
        return cur;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */