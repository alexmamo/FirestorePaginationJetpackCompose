package ro.alexmamo.firestorepaginationjetpackcompose.presentation.product

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import kotlinx.coroutines.InternalCoroutinesApi
import ro.alexmamo.firestorepaginationjetpackcompose.domain.model.Product
import ro.alexmamo.firestorepaginationjetpackcompose.presentation.product.components.ProductContent
import ro.alexmamo.firestorepaginationjetpackcompose.presentation.product.components.ProductTopBar

@Composable
fun ProductScreen(
    product: Product,
    navigateBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            ProductTopBar(
                navigateBack = navigateBack
            )
        }
    ) { padding ->
        ProductContent(
            padding = padding,
            product = product
        )
    }
}