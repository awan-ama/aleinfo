package com.awanama.aleinfo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.awanama.aleinfo.data.model.Beer
import com.awanama.aleinfo.ui.viewmodel.BeerViewModel

@Composable
fun DetailScreen(beerId: Int, beerViewModel: BeerViewModel = viewModel()) {
    var beer by remember { mutableStateOf<Beer?>(null) }

    LaunchedEffect(beerId) {
        beer = beerViewModel.getBeerById(beerId)
    }

    if (beer != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            val painter = rememberAsyncImagePainter(
                model = beer!!.image,
                error = painterResource(id = R.drawable.error)
            )
            Image(
                painter = painter,
                contentDescription = beer!!.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(bottom = 16.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = "Name: ${beer!!.name}", modifier = Modifier.padding(bottom = 8.dp))
            Text(text = "Price: ${beer!!.price}", modifier = Modifier.padding(bottom = 8.dp))
            Text(text = "Rating: ${beer!!.rating.average} (${beer!!.rating.reviews} reviews)", modifier = Modifier.padding(bottom = 8.dp))
        }
    }
//    else {
//        Text(text = "Beer not found", modifier = Modifier.padding(16.dp))
//    }
}
