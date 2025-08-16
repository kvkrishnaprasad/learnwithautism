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

        addItem("rooms", Pecs("Bedroom", R.drawable.bananas_1000x, R.raw.bedroo01))
        addItem("rooms", Pecs("Living room", R.drawable.bananas_1000x, R.raw.banana01))
        addItem("rooms", Pecs("Bathroom", R.drawable.bananas_1000x, R.raw.bathro02))



        addItem("People", Pecs("Viya", R.drawable.apple, R.raw.one00001))
        addItem("People", Pecs("Amma", R.drawable.apple, R.raw.one00001))
        addItem("People", Pecs("Nana", R.drawable.apple, R.raw.one00001))
        addItem("People", Pecs("Anna", R.drawable.apple, R.raw.one00001))
        addItem("People", Pecs("Navomi Maam", R.drawable.apple, R.raw.one00001))

        addItem("Food", Pecs("Vegetables", R.drawable.vegetables, R.raw.vegeta01))
        addItem("Food", Pecs("Fruits", R.drawable.fruit_infused, R.raw.fruit001))

        addItem("Snacks", Pecs("Chocolate", R.drawable.chocolate, R.raw.chocol11))
        addItem("Snacks", Pecs("French Fries", R.drawable.large_fries, R.raw.french_fries))
        addItem("Snacks", Pecs("Candy", R.drawable.candy, R.raw.candy001))
        addItem("Snacks", Pecs("Popcorn", R.drawable.popcorn, R.raw.popcor01))

        addItem("Places", Pecs("Mcdonald's", R.drawable.mcdonalds, R.raw.mcdonalds))
        addItem("Places", Pecs("Home", R.drawable.clayfarm_drive, R.raw.home0001))
        addItem("Places", Pecs("School", R.drawable.fawcett_primary_school, R.raw.school01))
        addItem("Places", Pecs("Nana Car", R.drawable.toyota_yaris_cross, R.raw.car00001))
        addItem("Places", Pecs("Amma Car", R.drawable.audi_q4_etron, R.raw.car00001))
        addItem("Places", Pecs("Office", R.drawable.arm_office, R.raw.office01))
        addItem("Places", Pecs("Waitrose", R.drawable.waitrose, R.raw.shop0001))
        addItem("Places", Pecs("Gym", R.drawable.david_lloyds, R.raw.gym00001))

        addItem("Items", Pecs("Lego", R.drawable.lego, R.raw.lego))

    }

    fun fetchPecs(categoryId: String): MutableList<Pecs> {
        return categoryToItems[categoryId]!!
    }
}