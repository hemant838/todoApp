package com.example.todoapp

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
class DataObject(context: Context) {
    private var listdata = mutableListOf<CardInfo>()
    private var database: MyDatabase =
        Room.databaseBuilder(context, MyDatabase::class.java, "to_do")
            .allowMainThreadQueries().build()

    init {
        listdata.apply {
            clear()
            addAll(database.dao().getTask())
        }
    }

    fun setData(title: String, priority: String) {
        val cardInfo = CardInfo(0, title, priority)
        listdata.add(cardInfo)
        GlobalScope.launch {
            database.dao().insertTask(cardInfo)
        }
    }

    fun getAlldata(): List<CardInfo> {
        return listdata
    }

    fun deleteAll() {
        listdata.clear()
        GlobalScope.launch {
            database.dao().deleteAll()
        }
    }

    fun getData(pos: Int): CardInfo {
        return listdata[pos]
    }

    fun deleteData(pos: Int) {
        val itemToRemove = listdata.get(pos)
        listdata.removeAt(pos)
        GlobalScope.launch {
            database.dao().deleteTask(itemToRemove)
        }
    }

    fun updateData(pos: Int, title: String, priority: String) {
        listdata[pos].title = title
        listdata[pos].priority = priority
        val itemToUpdate = listdata.get(pos)
        GlobalScope.launch {
            database.dao().updateTask(itemToUpdate)
        }
    }
}