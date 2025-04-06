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
        addCategory("numbers", R.drawable.numbers)
        addCategory("to be done", R.drawable.house)
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


        addItem("fruits", Pecs("Banana", R.drawable.bananas_1000x, R.raw.banana01))
        addItem("fruits", Pecs("Apple", R.drawable.apple, R.raw.apple001))
        addItem("fruits", Pecs("Strawberry", R.drawable.bananas_1000x, R.raw.banana01))

        addItem("professions", Pecs("Teacher", R.drawable.teacher, R.raw.teache01))
        addItem("professions", Pecs("Doctor", R.drawable.doctor, R.raw.doctor01))

        addItem("rooms", Pecs("Bedroom", R.drawable.bananas_1000x, R.raw.bedroo01))
        addItem("rooms", Pecs("Living room", R.drawable.bananas_1000x, R.raw.banana01))
        addItem("rooms", Pecs("Bathroom", R.drawable.bananas_1000x, R.raw.bathro02))

        addItem("numbers", Pecs("1", R.drawable.one, R.raw.one00001 ))
        addItem("numbers", Pecs("2", R.drawable.two, R.raw.two00001 ))
        addItem("numbers", Pecs("3", R.drawable.three, R.raw.three001 ))
        addItem("numbers", Pecs("4", R.drawable.four, R.raw.four0001 ))
        addItem("numbers", Pecs("5", R.drawable.five, R.raw.five0001 ))
        addItem("numbers", Pecs("6", R.drawable.six, R.raw.six00001 ))
        addItem("numbers", Pecs("7", R.drawable.seven, R.raw.seven001 ))
        addItem("numbers", Pecs("8", R.drawable.eight, R.raw.eight001 ))
        addItem("numbers", Pecs("9", R.drawable.nine, R.raw.nine0001 ))
        addItem("numbers", Pecs("10", R.drawable.ten, R.raw.ten00001 ))
        addItem("numbers", Pecs("11", R.drawable.eleven, R.raw.eleven01 ))
        addItem("numbers", Pecs("12", R.drawable.twelve, R.raw.twelve01 ))
        addItem("numbers", Pecs("13", R.drawable.thirteen, R.raw.thirte01 ))
        addItem("numbers", Pecs("14", R.drawable.fourteen, R.raw.fourte01 ))
        addItem("numbers", Pecs("15", R.drawable.fifteen, R.raw.fiftee01 ))
        addItem("numbers", Pecs("16", R.drawable.sixteen, R.raw.sixtee01 ))
        addItem("numbers", Pecs("17", R.drawable.seventeen, R.raw.sevent01 ))
        addItem("numbers", Pecs("18", R.drawable.eighteen, R.raw.eighte01 ))
        addItem("numbers", Pecs("19", R.drawable.nineteen, R.raw.ninete01 ))
        addItem("numbers", Pecs("20", R.drawable.twenty, R.raw.twenty02 ))

        addItem("to be done", Pecs("School", R.drawable.androidparty, R.raw.one00001))
        addItem("to be done", Pecs("Home", R.drawable.androidparty, R.raw.one00001))
        addItem("to be done", Pecs("Car", R.drawable.androidparty, R.raw.one00001))
        addItem("to be done", Pecs("Food", R.drawable.androidparty, R.raw.one00001))
        addItem("to be done", Pecs("Office", R.drawable.androidparty, R.raw.one00001))
        addItem("to be done", Pecs("McDonald's", R.drawable.androidparty, R.raw.one00001))
        addItem("to be done", Pecs("Shop", R.drawable.androidparty, R.raw.one00001))
        addItem("to be done", Pecs("Gym", R.drawable.androidparty, R.raw.one00001))
        addItem("to be done", Pecs("lego", R.drawable.androidparty, R.raw.one00001))
        addItem("to be done", Pecs("Chocolate", R.drawable.androidparty, R.raw.one00001))
        addItem("to be done", Pecs("Amma", R.drawable.androidparty, R.raw.one00001))
        addItem("to be done", Pecs("Nana", R.drawable.androidparty, R.raw.one00001))
        addItem("to be done", Pecs("Anna", R.drawable.androidparty, R.raw.one00001))
        addItem("to be done", Pecs("Viya", R.drawable.androidparty, R.raw.one00001))


    }

    fun fetchPecs(categoryId: String): MutableList<Pecs> {
        return categoryToItems[categoryId]!!
    }
}