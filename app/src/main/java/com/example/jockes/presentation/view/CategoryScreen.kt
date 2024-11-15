package com.example.jockes.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jockes.presentation.viewmodel.CategoryViewModel

@Composable
fun CategoriesListScreen(modifier: Modifier, viewModel: CategoryViewModel = hiltViewModel()) {
    val listCategories by viewModel.listCategories.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else if (error.isNotEmpty()) {

            Text(
                text = "Error: $error",
                color = Color.Red,
                modifier = Modifier.align(Alignment.Center)
            )

        } else {
            Box(modifier = Modifier.padding(30.dp)) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {

                    itemsIndexed(listCategories) { index, category ->
                        CategoryItem(index, category)

                    }

                }
            }
        }
    }
}

@Composable
fun CategoryItem1(category: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = category, modifier = Modifier.weight(1f), fontSize = 16.sp
        )

    }
}

@Composable
fun CategoryItem(index: Int, category: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(
                color = Color.Gray.copy(alpha = 0.1f), shape = RoundedCornerShape(12.dp)
            )
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "${index + 1}.", modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = category, modifier = Modifier.weight(1f), fontSize = 16.sp
            )


        }
    }
}
