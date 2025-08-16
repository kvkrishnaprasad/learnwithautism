package com.example.wordseeker.backend.store

object PecsCategoryStore {

    private val categories: MutableMap<String, PecsCategory> = mutableMapOf()

    fun addCategory(categoryName: String, image: Int) {
        categories[categoryName] = PecsCategory(categoryName, image, mutableListOf())
    }

    fun addItemToCategory(categoryName: String, pecsItemId: String) {
        categories[categoryName]?.items?.add(pecsItemId)
    }

    fun getCategory(categoryName: String) : PecsCategory? {
        return categories[categoryName]
    }

    fun fetchCategories() : MutableCollection<PecsCategory> {
        return categories.values
    }
}