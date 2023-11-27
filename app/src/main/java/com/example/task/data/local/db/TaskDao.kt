package com.example.task.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.task.model.TaskList

@Dao
interface TaskDao {
    @Insert
    fun insert(task: TaskList)
    @Delete
    fun delete(task: TaskList)
    @Update
    fun update(task: TaskList)
    @Query("SELECT * FROM taskList ORDER BY title ASC")
    fun getAll(): List<TaskList>
}