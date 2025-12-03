package com.example.demo.presentation.carlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.demo.domain.model.Car
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun CarListScreen(
    onCarClick: (Car) -> Unit,
    viewModel: CarListViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val isRefreshing by viewModel.isRefreshing.collectAsState()

    val refreshState = rememberSwipeRefreshState(isRefreshing)
    viewModel.loadCars("renault")


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF7F7F7)
    ) {
        SwipeRefresh(
            state = refreshState,
            onRefresh = { viewModel.refresh("renault") },
            modifier = Modifier.fillMaxSize()
        ) {
            when (uiState) {
                is CarListUiState.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }

                is CarListUiState.Error -> {
                    val message = (uiState as CarListUiState.Error).message
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = message, color = Color.Red)
                            Spacer(Modifier.height(8.dp))
                            Button(onClick = { viewModel.loadCars("renault") }) {
                                Text("Réessayer")
                            }
                        }
                    }
                }

                is CarListUiState.Success -> {
                    val cars = (uiState as CarListUiState.Success).cars
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 24.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        item {
                            Spacer(Modifier.height(16.dp))
                            TopBar()
                            Spacer(Modifier.height(24.dp))
                            Text(
                                text = "List of cars",
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(Modifier.height(16.dp))
                            SearchBar()
                            Spacer(Modifier.height(16.dp))
                            CategoryRow(viewModel)
                            Spacer(Modifier.height(16.dp))
                            Text(
                                text = "Most Popular",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.SemiBold
                                )
                            )
                            Spacer(Modifier.height(12.dp))
                        }

                        items(cars) { car ->
                            CarCard(
                                car = car,
                                onClick = { onCarClick(car) }
                            )
                        }

                        item { Spacer(Modifier.height(24.dp)) }
                    }
                }
            }
        }
    }
}

@Composable
private fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier.size(40.dp),
            shape = RoundedCornerShape(12.dp),
            color = Color.White,
            shadowElevation = 2.dp
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
        }

        Surface(
            modifier = Modifier.size(40.dp),
            shape = CircleShape,
            color = Color.LightGray
        ) { }
    }
}

@Composable
private fun SearchBar() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(16.dp),
        tonalElevation = 0.dp,
        shadowElevation = 0.dp,
        color = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null,
                tint = Color.Gray
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = "Search a car",
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
private fun CategoryRow(
    viewModel: CarListViewModel
) {


    val categories = listOf("Renault", "Ford", "Toyota", "Fiat","Audi")


    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)

    ) {
        categories.forEachIndexed { index, label ->

             val selected = viewModel.selectedBrandIndex == index


            Surface(
                shape = RoundedCornerShape(20.dp),
                color = if (selected) Color.Black else Color.Transparent,
                border = if (selected) null else ButtonDefaults.outlinedButtonBorder,
                tonalElevation = 0.dp,
                modifier = Modifier.clickable {
                    viewModel.selectBrand(index)
                    viewModel.loadCars(label)
                }

            ) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 14.dp, vertical = 6.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = label,
                        fontSize = 13.sp,
                        fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
                        color = if (selected) Color.White else Color.Black
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CarCard(
    car: Car,
    onClick: () -> Unit
) {
    Surface(
        tonalElevation = 0.dp,
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(18.dp),
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)

    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = car.name,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = car.description ?: "",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    text = "${car.estimated_price} $ ",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Spacer(Modifier.width(10.dp))

            GlideImage(
                model = car.imageUrl,
                contentDescription = car.name,
                modifier = Modifier
                    .width(130.dp)
                    .aspectRatio(16f / 9f)
                    .clip(RoundedCornerShape(14.dp))
            )
        }
    }
}
