package com.example.wordseeker.backend

import com.example.wordseeker.R
import com.example.wordseeker.backend.search.WordIndex
import com.example.wordseeker.backend.store.PecsCategoryStore.addCategory
import com.example.wordseeker.backend.store.PecsCategoryStore.addItemToCategory
import com.example.wordseeker.backend.store.PecsItemStore.addItem
import com.example.wordseeker.backend.store.PecsItemStore.addItemGif

object PecsStoreInitializer {

    fun init() {
        initCategories()
        initItems()
    }

    private fun initCategories() {
        addCategory("important", R.drawable.important)
        addCategory("actions", R.drawable.actions)
        addCategory("people", R.drawable.people)
        addCategory("replies", R.drawable.conversation)

        addCategory("places", R.drawable.places)
        addCategory("rooms", R.drawable.house)
        addCategory("furniture", R.drawable.furniture)

        addCategory("prepositions", R.drawable.prepositions)
        addCategory("adjectives", R.drawable.adjectives)
        addCategory("numbers", R.drawable.numbers)

        addCategory("professions", R.drawable.professions)
        addCategory("food", R.drawable.food)
        addCategory("fruits", R.drawable.fruit_infused)
        addCategory("animals", R.drawable.animals)
        addCategory("transport", R.drawable.transport)

    }

    private fun initItems() {
        addImportant()
        addActions()
        addPeople()
        addReplies()


        addPlaces()
        addRooms()
        addFurniture()


        addPrepositions()
        addAdjectives()
        addNumbers()

        addProfessions()
        addFruits()
        addTransport()
        addFood()
        addAnimals()
    }

    private fun addProfessions() {
        val categoryName = "professions"

        addOne(categoryName, "Hair Stylist", R.drawable.stylist, 6)
        addOne(categoryName, "Doctor", R.drawable.doctor, 6)

    }

    private fun addReplies() {
        val categoryName = "replies"

        addOne(categoryName, "I am good", R.drawable.iamgood, 10)
        addOne(categoryName, "Question", R.drawable.question, 10)

    }

    private fun addImportant() {
        val categoryName = "important"

        addOne(categoryName, "yes", R.drawable.yes, 10)
        addOne(categoryName, "no", R.drawable.no, 10)
        addOne(categoryName, "potty", R.drawable.potty, 10)
        addOne(categoryName, "hands_on_lap", R.drawable.hands_on_lap, 10)
        addOne(categoryName, "wait", R.drawable.wait, 10)
    }

    private fun addFruits() {
        val categoryName = "fruits"

        addOne(categoryName, "banana", R.drawable.bananas_1000x, R.raw.banana01, 10)
        addOne(categoryName, "apple", R.drawable.apple, R.raw.apple001, 10)
        addOne(categoryName, "strawberry", R.drawable.strawberry, R.raw.strawb01, 10)
    }

    private fun addFurniture() {
        val categoryName = "furniture"
        addOne(categoryName, "chair", R.drawable.chair, 10)
    }

    private fun addOne(categoryName:String, name: String, image: Int, score: Int) {
        addItem(name, image, sound = null)
        addItemToCategory(categoryName, name)
        WordIndex.insert(name, score)
    }

    private fun addOneGif(categoryName:String, name: String, image: Int, score: Int) {
        addItemGif(name, image, sound = null)
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

        addOne(categoryName, "chocolate", R.drawable.chocolate, R.raw.chocol11, 5)
        addOne(categoryName, "french_fries", R.drawable.large_fries, R.raw.french_fries,5)
        addOne(categoryName, "candy", R.drawable.candy, R.raw.candy001, 5)
        addOne(categoryName, "popcorn", R.drawable.popcorn, R.raw.popcor01, 5)

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
        addOne(categoryName,"school", R.drawable.school, R.raw.school01, 10)
        addOne(categoryName,"nana Car", R.drawable.toyota_yaris_cross, R.raw.car00001, 10)
        addOne(categoryName,"amma Car", R.drawable.audi_q4_etron, R.raw.car00001, 10)
        addOne(categoryName,"office", R.drawable.arm_office, R.raw.office01, 10)
        addOne(categoryName,"waitrose", R.drawable.waitrose, R.raw.shop0001, 10)
        addOne(categoryName, "tesco", R.drawable.tesco, 5)
        addOne(categoryName,"gym", R.drawable.david_lloyds, R.raw.gym00001, 10)
    }

    private fun addPeople() {
        addOne("people", "viya", R.drawable.viya, R.raw.one00001, 10)
        addOne("people", "amma", R.drawable.amma, R.raw.one00001, 10)
        addOne("people", "nanna", R.drawable.nanna, R.raw.one00001, 10)
        addOne("people", "anna", R.drawable.anna, R.raw.one00001, 10)
        addOne("people", "Navomi", R.drawable.navomi, R.raw.one00001, 10)
        addOne("people", "ammamma", R.drawable.ammamma, R.raw.one00001, 10)
    }

    private fun addRooms() {
        val categoryName = "rooms"

        addOne(categoryName,"bedroom", R.drawable.bedroom2, R.raw.bedroo01, 10)
        addOne(categoryName,"living room", R.drawable.living, R.raw.living_room, 10)
        addOne(categoryName,"bathroom", R.drawable.bathroom, R.raw.bathro02, 10)
        addOne(categoryName, "kitchen", R.drawable.kitchen, 10)
        addOne(categoryName, "dining room", R.drawable.dining, 10)
        addOne(categoryName, "stairs", R.drawable.stairs, 10)
        addOne(categoryName, "garden", R.drawable.garden, 10)
    }

    private fun addActions() {
        val categoryName = "actions"
        addOne(categoryName, "eat", R.drawable.eat, 10)
        addOne(categoryName, "drink", R.drawable.drink, 10)
        addOne(categoryName, "brush_teeth", R.drawable.brush_teeth, 10)
        addOne(categoryName, "walk", R.drawable.walk, 10)
        addOne(categoryName, "push", R.drawable.push, 8)
        addOne(categoryName, "pull", R.drawable.pull, 8)
    }

    private fun addTransport() {
        val categoryName = "transport"
        addOne(categoryName, "car", R.drawable.car, 9)
        addOne(categoryName, "bus", R.drawable.bus, 9)
        addOne(categoryName, "train", R.drawable.train, 9)
        addOne(categoryName, "airplane", R.drawable.airplane, 9)
    }

    private fun addAdjectives() {
        val categoryName = "adjectives"
        addOneGif(categoryName, "fast", R.raw.sonic, 9)
        addOneGif(categoryName, "slow", R.raw.slow_turtle, 9)

    }

    private fun addPrepositions() {
        val categoryName = "prepositions"
        addOne(categoryName, "in", R.drawable.`in`, 9)
        addOne(categoryName, "on", R.drawable.on, 9)
        addOne(categoryName, "above", R.drawable.above, 9)
        addOne(categoryName, "under", R.drawable.under, 9)

    }
}