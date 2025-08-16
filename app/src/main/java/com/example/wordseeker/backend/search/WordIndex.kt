package com.example.wordseeker.backend.search

data class WordEntry(val word: String, val score: Int)

class TrieNode {
    val children: MutableMap<Char, TrieNode> = mutableMapOf()
    val words: MutableList<WordEntry> = mutableListOf()
}

object WordIndex {
    private val root = TrieNode()

    // Insert a word with its score
    fun insert(word: String, score: Int) {
        var node = root
        val lower = word.lowercase()
        for (ch in lower) {
            node = node.children.getOrPut(ch) { TrieNode() }
            node.words.add(WordEntry(lower, score)) // store reference at each prefix
        }
    }

    // Insert multiple words
    fun insertAll(entries: List<WordEntry>) {
        for (entry in entries) {
            insert(entry.word, entry.score)
        }
    }

    // Search by prefix -> sorted by score descending
    fun searchByPrefix(prefix: String, limit: Int = 10): List<WordEntry> {
        var node = root
        for (ch in prefix.lowercase()) {
            node = node.children[ch] ?: return emptyList()
        }
        return node.words
            .distinctBy { it.word } // avoid duplicates if inserted multiple times
            .sortedByDescending { it.score }
            .take(limit)
    }
}