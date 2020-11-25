package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var todoItemRecyclerView : RecyclerView
    private lateinit var recyclerAdapter: TodoItemsAdapter
    private lateinit var recyclerLayoutManger: RecyclerView.LayoutManager

    var todoItemsList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Implement todolist functionality
        // Create the custom layout to represent an item

        todoItemsList.add("Buy groceries")
        todoItemsList.add("Do laundry")
        todoItemsList.add("Play guitar")

        todoItemRecyclerView = findViewById(R.id.todo_item_recycler_view)

        recyclerLayoutManger = LinearLayoutManager(this)

        recyclerAdapter = TodoItemsAdapter(todoItemsList)

        todoItemRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = recyclerLayoutManger
            adapter = recyclerAdapter
        }

    }

    public fun navToAddItemAction(view: View) {

        val intent: Intent = Intent(this, AddItemActivity::class.java)
        startActivity(intent)

    }
}