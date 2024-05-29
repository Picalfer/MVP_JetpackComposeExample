package com.example.mvpexample.presenter

import com.example.mvpexample.model.Item
import com.example.mvpexample.model.ItemRepository
import com.example.mvpexample.view.ItemView

class ItemPresenterImpl(
    private var view: ItemView?,
    private val repository: ItemRepository
) : ItemPresenter {

    override fun loadItems() {
        val items = repository.getItems()
        view?.showItems(items)
    }

    override fun addItem(item: Item) {
        repository.addItem(item)
        view?.showItemAddedMessage()
        loadItems()
    }

    fun setView(view: ItemView?) {
        this.view = view
    }
}
