package com.example.wordseeker.backend.store

import com.example.wordseeker.R
import com.example.wordseeker.backend.store.PecsCategoryStore.addCategory
import com.example.wordseeker.backend.store.PecsCategoryStore.addItemToCategory
import com.example.wordseeker.backend.store.PecsItemStore.addItem

object PecsStoreInitializer {

    fun init() {
        initCategories()
        initItems()
    }

    private fun initCategories() {
        addCategory("fruits", R.drawable.fruit_infused)
        addCategory("professions", R.drawable.professions)
        addCategory("rooms", R.drawable.house)
        addCategory("animals", R.drawable.house)
        addCategory("numbers", R.drawable.numbers)
        addCategory("transport", R.drawable.house)
        addCategory("People", R.drawable.house)
        addCategory("Food", R.drawable.house)
        addCategory("Snacks", R.drawable.house)
        addCategory("Places", R.drawable.house)
        addCategory("Items", R.drawable.house)
        addCategory("Hi", R.drawable.house)
    }

    private fun initItems() {
        addItem("banana", R.drawable.bananas_1000x, R.raw.banana01)
        addItemToCategory("fruits", "banana")
        addItem("apple", R.drawable.apple, R.raw.apple001)
        addItemToCategory("fruits", "apple")
//        addItem("fruits", Pecs("Strawberry", R.drawable.bananas_1000x, R.raw.banana01))
    }
}