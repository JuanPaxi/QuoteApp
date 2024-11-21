package com.panfilosoft.exam.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.panfilosoft.exam.data.local.entities.Quote
import com.panfilosoft.exam.data.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class QuoteViewModel(
    private val repository: QuoteRepository
) : ViewModel() {

    fun getAllQuotes(): Flow<List<Quote>> = repository.getAllQuotes()

//    init {
//        viewModelScope.launch {
//            dao.obtenerCitas().collectLatest {
//                state = state.copy(listaCitas = it)
//            }
//        }
//    }

    fun addQuote(quote: Quote) = viewModelScope.launch {
        repository.addQuote(quote)
    }

    fun updateQuote(quote: Quote) = viewModelScope.launch {
        repository.updateQuote(quote)
    }

    fun deleteQuote(quote: Quote) = viewModelScope.launch {
        repository.deleteQuote(quote)
    }

}