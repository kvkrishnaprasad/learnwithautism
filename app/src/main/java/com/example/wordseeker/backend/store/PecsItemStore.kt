package com.example.wordseeker.backend.store

object PecsItemStore {

    private val pecsItems: MutableMap<String, PecsItem> = mutableMapOf()

    fun addItem(name: String, image: Int, sound: Int) {
        val item = PecsItem(name, image, sound)
        pecsItems[name] = item
    }

    fun findById(id: String) : PecsItem? {
        return pecsItems[id]
    }
}