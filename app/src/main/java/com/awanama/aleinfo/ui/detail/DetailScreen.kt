package com.awanama.aleinfo.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.awanama.aleinfo.R
import com.awanama.aleinfo.data.entity.Beer

@Composable
fun DetailScreen(beerId: Int) {
    val detailViewModel: DetailViewModel = viewModel()
    var beer by remember { mutableStateOf<Beer?>(null) }

    detailViewModel.fetchBeerById(beerId) {
        beer = it
    }

    beer?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            val painter = rememberAsyncImagePainter(
                model = it.image,
                error = painterResource(id = R.drawable.error)
            )
            Image(
                painter = painter,
                contentDescription = it.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = "Name: ${it.name}", modifier = Modifier.padding(bottom = 8.dp))
            Text(text = "Price: ${it.price}", modifier = Modifier.padding(bottom = 8.dp))
        }
    }
}