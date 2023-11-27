package com.example.task.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class TaskList(
    @PrimaryKey(autoGenerate = true) val uid:Int?=null,
    val title:String,
    val desc:String,
):Serializable
