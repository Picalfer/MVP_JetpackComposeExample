package com.example.mvpexample.model

class ItemRepository {
    private val items = mutableListOf<Item>()

    fun getItems(): List<Item> {
        return items
    }

    fun addItem(item: Item) {
        items.add(item)
    }
}