package com.example.task.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.task.model.TaskList

@Database(entities = [TaskList::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}