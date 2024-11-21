package com.panfilosoft.exam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.room.Room
import com.panfilosoft.exam.data.local.database.QuoteDatabase
import com.panfilosoft.exam.data.repository.QuoteRepository
import com.panfilosoft.exam.ui.navigation.NavManager
import com.panfilosoft.exam.ui.screens.QuoteViewModel
import com.panfilosoft.exam.ui.theme.ExamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamTheme {
                val database = Room.databaseBuilder(
                    this,
                    QuoteDatabase::class.java,
                    "quote_database"
                ).build()
                val dao = database.quoteDao()
                val repository = QuoteRepository(dao)
                val viewModel = QuoteViewModel(repository)
                NavManager(viewModel = viewModel)
            }
        }
    }
}