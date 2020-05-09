package study.tree.ImplementTrie

import org.junit.Test

import org.junit.Assert.*

class TrieTest {

    @Test
    fun test() {
        val trie = Trie()
        trie.insert("geek")
        assertTrue(trie.startsWith("g"))
        assertTrue(trie.startsWith("ge"))
        assertTrue(trie.startsWith("gee"))
        assertFalse(trie.startsWith("geek"))
        assertTrue(trie.search("geek"))
    }

    @Test
    fun test1() {
        val trie = Trie()

        trie.insert("apple")
        trie.search("apple")   // returns true
        trie.search("app")     // returns false
        trie.startsWith("app") // returns true
        trie.insert("app")
        trie.search("app")     // returns true
    }
}