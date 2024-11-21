package com.panfilosoft.exam.ui.uistate

import com.panfilosoft.exam.data.local.entities.Quote

data class QuoteUiState (
    var quotes: List<Quote> = emptyList()
)