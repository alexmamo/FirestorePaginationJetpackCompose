package ro.alexmamo.firestorepaginationjetpackcompose.presentation.products

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.paging.ExperimentalPagingApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import ro.alexmamo.firestorepaginationjetpackcompose.domain.model.Product
import ro.alexmamo.firestorepaginationjetpackcompose.presentation.products.components.ProductsContent
import ro.alexmamo.firestorepaginationjetpackcompose.presentation.products.components.ProductsTopBar

@Composable
@InternalCoroutinesApi
@ExperimentalPagingApi
@ExperimentalCoroutinesApi
fun ProductsScreen(
    navigateToProductScreen: (product: Product) -> Unit
) {
    Scaffold(
        topBar = {
            ProductsTopBar()
        }
    ) { padding ->
        ProductsContent(
            padding = padding,
            navigateToProductScreen = navigateToProductScreen
        )
    }
}