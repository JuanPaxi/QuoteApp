package com.panfilosoft.exam.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.panfilosoft.exam.data.local.dao.QuoteDao
import com.panfilosoft.exam.data.local.entities.Quote

@Database(
    entities = [Quote::class],
    version = 1,
    exportSchema = false
)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun quoteDao(): QuoteDao
}