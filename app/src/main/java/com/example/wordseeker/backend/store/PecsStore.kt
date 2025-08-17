package com.example.wordseeker.backend.store

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



        addItem("fruits", Pecs("Banana", R.drawable.bananas_1000x, R.raw.banana01))
        addItem("fruits", Pecs("Apple", R.drawable.apple, R.raw.apple001))
        addItem("fruits", Pecs("Strawberry", R.drawable.bananas_1000x, R.raw.banana01))

        addItem("professions", Pecs("Teacher", R.drawable.teacher, R.raw.teache01))
        addItem("professions", Pecs("Doctor", R.drawable.doctor, R.raw.doctor01))









        addItem("Snacks", Pecs("Chocolate", R.drawable.chocolate, R.raw.chocol11))
        addItem("Snacks", Pecs("French Fries", R.drawable.large_fries, R.raw.french_fries))
        addItem("Snacks", Pecs("Candy", R.drawable.candy, R.raw.candy001))
        addItem("Snacks", Pecs("Popcorn", R.drawable.popcorn, R.raw.popcor01))



        addItem("Items", Pecs("Lego", R.drawable.lego, R.raw.lego))

    }

    fun fetchPecs(categoryId: String): MutableList<Pecs> {
        return categoryToItems[categoryId]!!
    }
}