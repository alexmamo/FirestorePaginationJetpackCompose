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
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import ro.alexmamo.firestorepaginationjetpackcompose.components.ProgressBar
import ro.alexmamo.firestorepaginationjetpackcompose.core.Utils.Companion.printError
import ro.alexmamo.firestorepaginationjetpackcompose.domain.model.Product
import ro.alexmamo.firestorepaginationjetpackcompose.presentation.products.ProductsViewModel

@Composable
@ExperimentalPagingApi
@InternalCoroutinesApi
@ExperimentalCoroutinesApi
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
        products.apply {
            when {
                loadState.refresh is LoadState.Loading -> ProgressBar()
                loadState.refresh is LoadState.Error -> printError(products.loadState.refresh as LoadState.Error)
                loadState.append is LoadState.Loading -> ProgressBar()
                loadState.append is LoadState.Error -> printError(products.loadState.append as LoadState.Error)
            }
        }
    }
}