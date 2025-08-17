package com.example.wordseeker.backend.store

import com.example.wordseeker.R

object PecsStore {

    private val categoryToItems: MutableMap<String, MutableList<Pecs>> = mutableMapOf()


    fun addItem(key: String, item: Pecs) {
        categoryToItems.computeIfAbsent(key) {
            mutableListOf()
        }.add(item)
    }


    fun populate() {

        addItem("professions", Pecs("Teacher", R.drawable.teacher, R.raw.teache01))
        addItem("professions", Pecs("Doctor", R.drawable.doctor, R.raw.doctor01))



        addItem("Items", Pecs("Lego", R.drawable.lego, R.raw.lego))

    }

}