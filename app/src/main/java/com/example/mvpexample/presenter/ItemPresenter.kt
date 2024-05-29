package com.example.mvpexample.presenter

import com.example.mvpexample.model.Item

interface ItemPresenter {
    fun loadItems()
    fun addItem(item: Item)
}