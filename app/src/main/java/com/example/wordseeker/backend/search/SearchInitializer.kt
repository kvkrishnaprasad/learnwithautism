package com.example.wordseeker.backend.search

object SearchInitializer {

    fun init() {
        WordIndex.insert("apple", 10);
        WordIndex.insert("banana", 5);
        WordIndex.insert("ball", 2);
    }
}