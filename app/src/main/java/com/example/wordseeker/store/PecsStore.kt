package com.example.wordseeker.store

import com.example.wordseeker.R

object PecsStore {

    private val categories: MutableSet<Category> = mutableSetOf()
    private val categoryToItems: MutableMap<String, MutableList<Pecs>> = mutableMapOf()


    fun addCategory(categoryName: String, image: Int) {
        categories.add(Category(categoryName, image))
    }

    fun fetchCategories(): MutableSet<Category> {
        return categories
    }

    fun addItem(key: String, item: Pecs) {
        categoryToItems.computeIfAbsent(key) {
            mutableListOf()
        }.add(item)
    }


    fun populate() {
        addCategory("fruits", R.drawable.fruit_infused)
        addCategory("professions", R.drawable.professions)
        addCategory("rooms", R.drawable.house)
        addCategory("animals", R.drawable.house)
        addCategory("birds", R.drawable.house)
        addCategory("birds1", R.drawable.house)
        addCategory("birds2", R.drawable.house)
        addCategory("birds3", R.drawable.house)
        addCategory("birds4", R.drawable.house)
        addCategory("birds5", R.drawable.house)
        addCategory("birds6", R.drawable.house)
        addCategory("birds7", R.drawable.house)
        addCategory("birds8", R.drawable.house)
        addCategory("birds9", R.drawable.house)
        addCategory("birds10", R.drawable.house)
        addCategory("birds11", R.drawable.house)


        addItem("fruits", Pecs("banana", R.drawable.bananas_1000x, R.raw.banana01))
        addItem("fruits", Pecs("apple", R.drawable.apple, R.raw.apple001))
        addItem("professions", Pecs("teacher", R.drawable.teacher, R.raw.teache01))
        addItem("professions", Pecs("doctor", R.drawable.doctor, R.raw.doctor01))
        addItem("rooms", Pecs("Bedroom", R.drawable.bananas_1000x, R.raw.bedroo01))
        addItem("rooms", Pecs("Living room", R.drawable.bananas_1000x, R.raw.banana01))
        addItem("rooms", Pecs("Bathroom", R.drawable.bananas_1000x, R.raw.bathro02))
    }



    fun fetchPecs(categoryId: String): MutableList<Pecs> {
        return categoryToItems[categoryId]!!
    }
}