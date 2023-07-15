package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CreateKard : AppCompatActivity() {
    private lateinit var dataObject: DataObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_kard)

        dataObject = DataObject(this)

        val createTitle = findViewById<EditText>(R.id.create_title)
        val createPriority = findViewById<EditText>(R.id.create_priority)
        val savebtn = findViewById<Button>(R.id.save_btn)

        savebtn.setOnClickListener {
            if (createTitle.text.toString().trim { it <= ' ' }.isNotEmpty()
                && createPriority.text.toString().trim { it <= ' ' }.isNotEmpty()
            ) {
                val title = createTitle.text.toString()
                val priority = createPriority.text.toString()
                dataObject.setData(title, priority)

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

//hello
    }
}