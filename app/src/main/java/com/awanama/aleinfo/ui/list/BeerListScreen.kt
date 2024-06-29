package com.awanama.aleinfo.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.awanama.aleinfo.R
import com.awanama.aleinfo.data.entity.Beer
import com.awanama.aleinfo.navigation.TopLevelDestination

@Composable
fun BeerListScreen(navController: NavHostController, beerViewModel: BeerViewModel = viewModel()) {
    val beers by beerViewModel.beers.observeAsState(emptyList())
    var searchQuery by remember { mutableStateOf("") }
    val filteredBeers = beers.filter { it.name.contains(searchQuery, ignoreCase = true) }

    LaunchedEffect(Unit) {
        beerViewModel.fetchBeers()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search Beers") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(filteredBeers) { beer ->
                BeerItem(beer) {
                    navController.navigate(TopLevelDestination.Detail.createRoute(beer.id))
                }
            }
        }
    }
}

@Composable
fun BeerItem(beer: Beer, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        val painter = rememberAsyncImagePainter(
            model = beer.image,
            error = painterResource(id = R.drawable.error)
        )
        Image(
            painter = painter,
            contentDescription = beer.name,
            modifier = Modifier
                .size(64.dp)
                .padding(end = 8.dp),
            contentScale = ContentScale.Crop
        )
        Column {
            Text(text = beer.name, modifier = Modifier.padding(bottom = 4.dp))
            Text(text = beer.price, modifier = Modifier.padding(bottom = 4.dp))
        }
    }
}
