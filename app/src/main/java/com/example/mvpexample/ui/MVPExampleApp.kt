package com.example.mvpexample.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.mvpexample.model.Item
import com.example.mvpexample.presenter.ItemPresenter
import com.example.mvpexample.presenter.ItemPresenterImpl
import com.example.mvpexample.view.ItemView

@Composable
fun MVPExampleApp(presenter: ItemPresenter) {
    val context = LocalContext.current
    var itemName by remember { mutableStateOf("") }
    var items by remember { mutableStateOf(listOf<Item>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = itemName,
            onValueChange = { itemName = it },
            label = { Text("Enter item name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        Button(
            onClick = {
                if (itemName.isNotEmpty()) {
                    presenter.addItem(Item(itemName))
                    itemName = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Add Item")
        }
        Spacer(modifier = Modifier.height(16.dp))
        items.forEach { item ->
            Text(text = item.name)
        }
    }

    DisposableEffect(presenter) {
        val view = object : ItemView {
            override fun showItems(itemsList: List<Item>) {
                items = itemsList
            }

            override fun showItemAddedMessage() {
                Toast.makeText(context, "Item Added", Toast.LENGTH_SHORT).show()
            }
        }
        (presenter as ItemPresenterImpl).setView(view)
        presenter.loadItems()
        onDispose {
            (presenter as ItemPresenterImpl).setView(null)
        }
    }
}
