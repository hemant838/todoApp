package com.example.todoapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Entity::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun dao(): DAO


}