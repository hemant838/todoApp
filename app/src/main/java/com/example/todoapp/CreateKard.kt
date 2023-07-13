package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateKard : AppCompatActivity() {

    private lateinit var database: MyDatabase
    private val createTitle = findViewById<EditText>(R.id.create_title)
    private val createPriority = findViewById<EditText>(R.id.create_priority)
    private val savebtn = findViewById<Button>(R.id.save_btn)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_kard)



        database = Room.databaseBuilder(applicationContext, MyDatabase::class.java, "to_do")
            .allowMainThreadQueries().build()

        savebtn.setOnClickListener {
            if (createTitle.text.toString().trim { it <= ' ' }.isNotEmpty()
                && createPriority.text.toString().trim { it <= ' ' }.isNotEmpty()
            ) {
                val title = createTitle.text.toString()
                val priority = createPriority.text.toString()
                DataObject.setData(title, priority)

                GlobalScope.launch {
                    database.dao().insertTask(Entity(0, title, priority))
                }

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

//hello
    }
}