package com.example.mvpexample.view

import com.example.mvpexample.model.Item

interface ItemView {
    fun showItems(itemsList: List<Item>)
    fun showItemAddedMessage()
}