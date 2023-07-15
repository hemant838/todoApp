package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var dataObject: DataObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataObject = DataObject(this)

        val add: Button = findViewById(R.id.add)
        add.setOnClickListener {
            val intent = Intent(this, CreateKard::class.java)
            startActivity(intent)
            finish()
        }

        val deleteAll: Button = findViewById(R.id.deleteAll)
        deleteAll.setOnClickListener {
            dataObject.deleteAll()
            setRecycler()
        }
        setRecycler()
    }

    fun setRecycler() {
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = Adapter(dataObject.getAlldata())
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}