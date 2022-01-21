package ro.alexmamo.firestorepaginationjetpackcompose.presentation.products.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import ro.alexmamo.firestorepaginationjetpackcompose.core.Constants.PRODUCTS_SCREEN

@Composable
fun ProductsTopBar() {
    TopAppBar (
        title = {
            Text(
                text = PRODUCTS_SCREEN
            )
        }
    )
}