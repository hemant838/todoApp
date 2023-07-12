package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.provider.ContactsContract.Intents
import android.widget.Button
import android.widget.EditText

class UpdateCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_card)

        val pos = intent.getIntExtra("id",-1)
        if (pos!=-1)
        {
            val title = DataObject.getData(pos).title
            val priority = DataObject.getData(pos).priority

            val create_title = findViewById<EditText>(R.id.create_title)
            val create_priority = findViewById<EditText>(R.id.create_priority)

            create_title.setText(title)
            create_priority.setText(priority)

            findViewById<Button>(R.id.delete_btn).setOnClickListener {
                DataObject.deleteData(pos)
                myIntent()
            }

            findViewById<Button>(R.id.update_btn).setOnClickListener {
                DataObject.updateData(pos,create_title.text.toString(), create_priority.text.toString())
                myIntent()
            }
        }
    }
    fun myIntent()
    {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}