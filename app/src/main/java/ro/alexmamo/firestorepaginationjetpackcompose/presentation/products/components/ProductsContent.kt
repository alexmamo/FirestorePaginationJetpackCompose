package ro.alexmamo.firestorepaginationjetpackcompose.presentation.products.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadState.Error
import androidx.paging.LoadState.Loading
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import ro.alexmamo.firestorepaginationjetpackcompose.components.ProgressBar
import ro.alexmamo.firestorepaginationjetpackcompose.core.Utils.Companion.printError
import ro.alexmamo.firestorepaginationjetpackcompose.domain.model.Product
import ro.alexmamo.firestorepaginationjetpackcompose.presentation.products.ProductsViewModel

@Composable
@ExperimentalPagingApi
fun ProductsContent(
    viewModel: ProductsViewModel = hiltViewModel(),
    padding: PaddingValues,
    navigateToProductScreen: (product: Product) -> Unit
) {
    val products = viewModel.products.collectAsLazyPagingItems()
    Box(
        modifier = Modifier.fillMaxSize().padding(padding)
    ) {
        LazyColumn {
            items(
                items = products
            ) { product ->
                product?.let {
                    ProductCard(
                        product = product,
                        onProductClick = navigateToProductScreen
                    )
                }
            }
        }
    }
    products.loadState.apply {
        when {
            refresh is Loading -> ProgressBar()
            refresh is Error -> printError(refresh as Error)
            append is Loading -> ProgressBar()
            append is Error -> printError(append as Error)
        }
    }
}