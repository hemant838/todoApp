package com.example.todoapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DAO {

    @Insert
    fun insertTask(cardInfo: CardInfo)

    @Update
    fun updateTask(cardInfo: CardInfo)

    @Delete
    fun deleteTask(cardInfo: CardInfo)

    @Query("Delete from to_do")
    fun deleteAll()

    @Query("Select * from to_do")
    fun getTask(): List<CardInfo>

}