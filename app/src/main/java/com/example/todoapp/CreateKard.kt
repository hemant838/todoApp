package com.example.todoapp

import android.content.Intent
import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateKard : AppCompatActivity() {

    lateinit var database : MyDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_kard)

        val createTitle = findViewById<EditText>(R.id.create_title)
        val createPriority = findViewById<EditText>(R.id.create_priority)
        val savebtn = findViewById<Button>(R.id.save_btn)

        database = Room.databaseBuilder(applicationContext, MyDatabase::class.java, "to_do").allowMainThreadQueries().build()

        savebtn.setOnClickListener {
            if (createTitle.text.toString().trim { it <= ' ' }.isNotEmpty()
                && createPriority.text.toString().trim { it <= ' ' }.isNotEmpty()
            ) {
                val title = createTitle.text.toString()
                val priority = createPriority.text.toString()
                DataObject.setData(title, priority)

                GlobalScope.launch {
                    database.dao().insertTask(Entity(0,title, priority))
                }

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }


    }
}