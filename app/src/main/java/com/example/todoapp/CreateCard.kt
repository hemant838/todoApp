package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CreateCard : AppCompatActivity() {

    val createTitle: EditText = findViewById(R.id.create_title)
    val createPriority: EditText = findViewById(R.id.create_priority)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_card)

        val savebtn = findViewById<Button>(R.id.save_btn)
        savebtn.setOnClickListener {
            if (createTitle.text.toString().trim { it <= ' ' }.isNotEmpty()
                && createPriority.text.toString().trim { it <= ' ' }.isNotEmpty()
            ) {
                val title = createTitle.getText().toString()
                val priority = createPriority.getText().toString()
                DataObject.setData(title, priority)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }


    }
}