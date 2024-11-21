package com.panfilosoft.exam.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote")
data class Quote(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo("name") var name: String,
    @ColumnInfo("phone") val phone: String,
    @ColumnInfo("description") val description: String,
    @ColumnInfo("day") val day: String,
    @ColumnInfo("hour") val hour: String
)