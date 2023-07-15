package com.example.todoapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "To_Do")
data class CardInfo(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var priority: String
)
