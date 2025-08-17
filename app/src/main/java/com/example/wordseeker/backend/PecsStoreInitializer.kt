package com.example.wordseeker.backend

import com.example.wordseeker.R
import com.example.wordseeker.backend.search.WordIndex
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
        addCategory("animals", R.drawable.animals)
        addCategory("numbers", R.drawable.numbers)
        addCategory("transport", R.drawable.transport)
        addCategory("people", R.drawable.people)
        addCategory("food", R.drawable.food)
//        addCategory("Snacks", R.drawable.house)
        addCategory("places", R.drawable.places)
        addCategory("actions", R.drawable.actions)
//        addCategory("Items", R.drawable.house)
//        addCategory("Hi", R.drawable.house)
    }

    private fun initItems() {
        addItem("banana", R.drawable.bananas_1000x, R.raw.banana01)
        addItemToCategory("fruits", "banana")
        WordIndex.insert("banana", 10)

        addItem("apple", R.drawable.apple, R.raw.apple001)
        addItemToCategory("fruits", "apple")
        WordIndex.insert("apple", 10)

        addItem("strawberry", R.drawable.strawberry, R.raw.banana01)
        addItemToCategory("fruits", "strawberry")
        WordIndex.insert("strawberry", 10)

        addNumbers()
        addFood()
        addPlaces()
        addPeople()
        addRooms()
        addAnimals()
        addActions()
    }

    private fun addOne(categoryName:String, name: String, image: Int, score: Int) {
        addItem(name, image, sound = null)
        addItemToCategory(categoryName, name)
        WordIndex.insert(name, score)
    }

    private fun addOne(categoryName:String, name: String, image: Int, sound: Int
    , score: Int) {
        addItem(name, image, sound)
        addItemToCategory(categoryName, name)
        WordIndex.insert(name, score)
    }

    private fun addNumbers() {
        addOne("numbers", "1", R.drawable.one, R.raw.one00001, 10)
        addOne("numbers", "2", R.drawable.two, R.raw.two00001, 10)
        addOne("numbers", "3", R.drawable.three, R.raw.three001, 10)
        addOne("numbers", "4", R.drawable.four, R.raw.four0001, 10)
        addOne("numbers", "5", R.drawable.five, R.raw.five0001, 10)
        addOne("numbers", "6", R.drawable.six, R.raw.six00001, 10)
        addOne("numbers", "7", R.drawable.seven, R.raw.seven001, 10)
        addOne("numbers", "8", R.drawable.eight, R.raw.eight001, 10)
        addOne("numbers", "9", R.drawable.nine, R.raw.nine0001, 10)
        addOne("numbers", "10", R.drawable.ten, R.raw.ten00001, 10)
        addOne("numbers", "11", R.drawable.eleven, R.raw.eleven01, 5)
        addOne("numbers", "12", R.drawable.twelve, R.raw.twelve01, 5)
        addOne("numbers", "13", R.drawable.thirteen, R.raw.thirte01, 5)
        addOne("numbers", "14", R.drawable.fourteen, R.raw.fourte01, 5)
        addOne("numbers", "15", R.drawable.fifteen, R.raw.fiftee01, 5)
        addOne("numbers", "16", R.drawable.sixteen, R.raw.sixtee01, 5)
        addOne("numbers", "17", R.drawable.seventeen, R.raw.sevent01, 5)
        addOne("numbers", "18", R.drawable.eighteen, R.raw.eighte01, 5)
        addOne("numbers", "19", R.drawable.nineteen, R.raw.ninete01, 5)
        addOne("numbers", "20", R.drawable.twenty, R.raw.twenty02, 5)
    }

    private fun addFood() {
        val categoryName = "food"

        addOne(categoryName, "vegetables", R.drawable.vegetables, R.raw.vegeta01, 10)
        addOne(categoryName, "fruits", R.drawable.fruit_infused, R.raw.fruit001, 10)
        addOne(categoryName, "dosa", R.drawable.dosa, 10)
    }

    private fun addAnimals() {
        val categoryName = "animals"
        addOne(categoryName ,"cat", R.drawable.cat, 20)
        addOne(categoryName ,"dog", R.drawable.dog, 20)
    }

    private fun addPlaces() {
        val categoryName = "places"

        addOne(categoryName,"mcdonald's", R.drawable.mcdonalds, R.raw.mcdonalds, 10)
        addOne(categoryName,"home", R.drawable.clayfarm_drive, R.raw.home0001, 10)
        addOne(categoryName,"school", R.drawable.fawcett_primary_school, R.raw.school01, 10)
        addOne(categoryName,"nana Car", R.drawable.toyota_yaris_cross, R.raw.car00001, 10)
        addOne(categoryName,"amma Car", R.drawable.audi_q4_etron, R.raw.car00001, 10)
        addOne(categoryName,"office", R.drawable.arm_office, R.raw.office01, 10)
        addOne(categoryName,"waitrose", R.drawable.waitrose, R.raw.shop0001, 10)
        addOne(categoryName,"gym", R.drawable.david_lloyds, R.raw.gym00001, 10)
    }

    private fun addPeople() {
        addOne("people", "viya", R.drawable.apple, R.raw.one00001, 10)
        addOne("people", "amma", R.drawable.apple, R.raw.one00001, 10)
        addOne("people", "nana", R.drawable.apple, R.raw.one00001, 10)
        addOne("people", "anna", R.drawable.apple, R.raw.one00001, 10)
        addOne("people", "Navomi Maam", R.drawable.apple, R.raw.one00001, 10)
    }

    private fun addRooms() {
        addOne("rooms","bedroom", R.drawable.bedroom, R.raw.bedroo01, 10)
        addOne("rooms","Living room", R.drawable.bananas_1000x, R.raw.living_room, 10)
        addOne("rooms","bathroom", R.drawable.bathroom, R.raw.bathro02, 10)
    }

    private fun addActions() {
        val categoryName = "actions"
        addOne(categoryName, "eat", R.drawable.eat, 10)
        addOne(categoryName, "drink", R.drawable.drink, 10)

    }
}