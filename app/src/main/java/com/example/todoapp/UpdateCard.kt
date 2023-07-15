package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class UpdateCard : AppCompatActivity() {
    private lateinit var dataObject: DataObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_card)

        dataObject = DataObject(this)

        val pos = intent.getIntExtra("id", -1)
        if (pos != -1) {
            val title = dataObject.getData(pos).title
            val priority = dataObject.getData(pos).priority

            val create_title = findViewById<EditText>(R.id.create_title)
            val create_priority = findViewById<EditText>(R.id.create_priority)

            create_title.setText(title)
            create_priority.setText(priority)

            findViewById<Button>(R.id.delete_btn).setOnClickListener {
                dataObject.deleteData(pos)
                myIntent()
            }

            findViewById<Button>(R.id.update_btn).setOnClickListener {
                dataObject.updateData(
                    pos,
                    create_title.text.toString(),
                    create_priority.text.toString()
                )
                myIntent()
            }
        }
    }

    fun myIntent() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}