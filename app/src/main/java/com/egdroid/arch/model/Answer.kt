package com.egdroid.arch.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class Answer(
    val imageYes: String,
    val imageNo: String
)