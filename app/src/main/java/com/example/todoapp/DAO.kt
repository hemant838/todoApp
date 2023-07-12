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
    suspend fun insertTask(entity:com.example.todoapp.Entity)

    @Update
    suspend fun updateTask(entity:com.example.todoapp.Entity)

    @Delete
    suspend fun deleteTask(entity:com.example.todoapp.Entity)

    @Query("Delete from to_do")
    suspend fun deleteAll()

    @Query("Select * from to_do")
    suspend fun getTask(): List<CardInfo>

}