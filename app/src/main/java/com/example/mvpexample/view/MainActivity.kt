package com.example.mvpexample.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mvpexample.model.Item
import com.example.mvpexample.model.ItemRepository
import com.example.mvpexample.presenter.ItemPresenter
import com.example.mvpexample.presenter.ItemPresenterImpl
import com.example.mvpexample.ui.MVPExampleApp

class MainActivity : ComponentActivity(), ItemView {

    private lateinit var presenter: ItemPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = ItemPresenterImpl(this, ItemRepository())

        enableEdgeToEdge()
        setContent {
            MVPExampleApp(presenter)
        }
    }

    override fun showItems(itemsList: List<Item>) {}

    override fun showItemAddedMessage() {}
}