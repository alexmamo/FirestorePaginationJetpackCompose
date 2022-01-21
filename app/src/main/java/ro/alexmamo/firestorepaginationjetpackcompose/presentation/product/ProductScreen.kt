package ro.alexmamo.firestorepaginationjetpackcompose.presentation.product

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import ro.alexmamo.firestorepaginationjetpackcompose.domain.model.Product
import ro.alexmamo.firestorepaginationjetpackcompose.presentation.product.components.ProductDetailsTopBar

@Composable
@InternalCoroutinesApi
@ExperimentalCoroutinesApi
fun ProductScreen(
    navController: NavController,
    product: Product
) {
    Scaffold(
        topBar = {
            ProductDetailsTopBar(navController)
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp, start = 8.dp)
        ) {
            Column {
                product.apply {
                    name?.let {
                        Text(
                            text = "name: $name",
                            fontSize = 24.sp
                        )
                    }
                    price?.let {
                        Text(
                            text = "price: $$price",
                            fontSize = 24.sp
                        )
                    }
                }
            }
        }
    }
}