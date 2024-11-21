package com.panfilosoft.exam.data.repository

import com.panfilosoft.exam.data.local.dao.QuoteDao
import com.panfilosoft.exam.data.local.entities.Quote
import kotlinx.coroutines.flow.Flow

class QuoteRepository(
    private val quoteDao: QuoteDao
) {

    fun getAllQuotes(): Flow<List<Quote>> {
        return quoteDao.getAllQuotes()
    }

    suspend fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    suspend fun updateQuote(quote: Quote) {
        quoteDao.updateQuote(quote)
    }

    suspend fun deleteQuote(quote: Quote) {
        quoteDao.deleteQuote(quote)
    }
}