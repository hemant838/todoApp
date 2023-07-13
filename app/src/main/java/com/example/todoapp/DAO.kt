package com.example.todoapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DAO {

    @Insert
    fun insertTask(entity:com.example.todoapp.Entity)

    @Update
    fun updateTask(entity:com.example.todoapp.Entity)

    @Delete
    fun deleteTask(entity:com.example.todoapp.Entity)

    @Query("Delete from to_do")
    fun deleteAll()

    @Query("Select * from to_do")
    fun getTask(): List<CardInfo>

}