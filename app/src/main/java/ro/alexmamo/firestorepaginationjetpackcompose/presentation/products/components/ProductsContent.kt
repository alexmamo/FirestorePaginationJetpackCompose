package ro.alexmamo.firestorepaginationjetpackcompose.presentation.products.components

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
import ro.alexmamo.firestorepaginationjetpackcompose.core.Utils.Companion.print
import ro.alexmamo.firestorepaginationjetpackcompose.domain.model.Product
import ro.alexmamo.firestorepaginationjetpackcompose.presentation.products.ProductsViewModel

@Composable
@ExperimentalPagingApi
fun ProductsContent(
    viewModel: ProductsViewModel = hiltViewModel(),
    padding: PaddingValues,
    navigateToProductScreen: (product: Product) -> Unit
) {
    val pagingProducts = viewModel.products.collectAsLazyPagingItems()
    val append = pagingProducts.loadState.append

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding)
    ) {
        items(
            items = pagingProducts
        ) { product ->
            product?.let {
                ProductCard(
                    product = product,
                    onProductClick = navigateToProductScreen
                )
            }
        }
    }
    if (append is Loading) {
        ProgressBar()
    }
    if (append is Error) {
        print(append)
    }
}