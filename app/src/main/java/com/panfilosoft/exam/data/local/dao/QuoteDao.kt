package com.panfilosoft.exam.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.panfilosoft.exam.data.local.entities.Quote
import kotlinx.coroutines.flow.Flow

@Dao
interface QuoteDao {
    @Query("SELECT * FROM quote")
    fun getAllQuotes(): Flow<List<Quote>>

    @Insert
    suspend fun addQuote(quote: Quote)

    @Update
    suspend fun updateQuote(quote: Quote)

    @Delete
    suspend fun deleteQuote(quote: Quote)
}