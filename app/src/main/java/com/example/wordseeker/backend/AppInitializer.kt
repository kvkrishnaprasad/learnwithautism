package com.example.wordseeker.backend

import com.example.wordseeker.backend.search.SearchInitializer
import com.example.wordseeker.backend.store.PecsStoreInitializer

object AppInitializer {

    fun initialize() {
        PecsStoreInitializer.init()
        SearchInitializer.init()
    }
}