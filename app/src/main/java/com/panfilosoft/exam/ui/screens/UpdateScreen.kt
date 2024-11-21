package com.panfilosoft.exam.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.panfilosoft.exam.data.local.entities.Quote

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateScreen(
    viewModel: QuoteViewModel,
    navController: NavController,
    id: String,
    name: String,
    phone: String,
    description: String,
    day: String,
    hour: String
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Update Quote", color = Color.White, fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "back",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) {
        ContentUpdateScreen(
            it,
            viewModel,
            navController,
            id,
            name,
            phone,
            description,
            day,
            hour
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentUpdateScreen(
    it: PaddingValues,
    viewModel: QuoteViewModel,
    navController: NavController,
    id: String,
    name: String,
    phone: String,
    description: String,
    day: String,
    hour: String
) {


    var name by remember { mutableStateOf(name) }
    var phone by remember { mutableStateOf(phone) }
    var description by remember { mutableStateOf(description) }

    val days = listOf(
        "Select day",
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday"
    )
    var showDay by remember { mutableStateOf(false) }
    var selectedDay by remember { mutableStateOf(day) }

    val hours = listOf(
        "Select time",
        "9:00 a 10:00",
        "10:00 a 11:00",
        "11:00 a 12:00",
        "12:00 a 13:00",
        "13:00 a 14:00",
        "14:00 a 15:00",
        "15:00 a 16:00",
        "16:00 a 17:00",
        "17:00 a 18:00",
        "18:00 a 19:00",
        "19:00 a 20:00"
    )
    var showHours by remember { mutableStateOf(false) }
    var selectedHour by remember { mutableStateOf(hour) }

    Column(
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Person name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = phone,
            onValueChange = {
                phone = it
            },
            label = { Text(text = "Phone number..") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text(text = "Description...") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )

        ExposedDropdownMenuBox(
            expanded = showDay,
            onExpandedChange = {
                showDay = !showDay
            },
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        ) {

            TextField(
                modifier = Modifier.menuAnchor(),
                value = selectedDay,
                onValueChange = { },
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = showDay) },
                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )

            ExposedDropdownMenu(
                expanded = showDay,
                onDismissRequest = { showDay = false }
            ) {
                days.forEachIndexed { _, s ->
                    DropdownMenuItem(
                        text = {
                            Text(text = s)
                        },
                        onClick = {
                            if (s != days[0]) {
                                selectedDay = s
                            }
                            showDay = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }

        ExposedDropdownMenuBox(
            expanded = showHours,
            onExpandedChange = {
                showHours = !showHours
            },
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        ) {

            TextField(
                modifier = Modifier.menuAnchor(),
                value = selectedHour,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = showHours) },
                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )

            ExposedDropdownMenu(
                expanded = showHours,
                onDismissRequest = { showHours = false }
            ) {
                hours.forEachIndexed { _, s ->
                    DropdownMenuItem(
                        text = {
                            Text(text = s)
                        },
                        onClick = {
                            if (s != hours[0]) {
                                selectedHour = s
                            }
                            showHours = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }

        Button(
            onClick = {
                val quote = Quote(
                    id = id.toInt(),
                    name = name,
                    phone = phone,
                    description = description,
                    day = selectedDay,
                    hour = selectedHour
                )

                viewModel.updateQuote(quote)
                navController.popBackStack()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        ) {
            Text(text = "Update Quote")
        }
    }
}