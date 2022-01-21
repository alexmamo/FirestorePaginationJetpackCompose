package ro.alexmamo.firestorepaginationjetpackcompose.presentation.products

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadState.Error
import androidx.paging.LoadState.Loading
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import ro.alexmamo.firestorepaginationjetpackcompose.core.Utils.Companion.printError
import ro.alexmamo.firestorepaginationjetpackcompose.presentation.products.components.ProgressBar
import ro.alexmamo.firestorepaginationjetpackcompose.presentation.navigation.Screen.ProductScreen
import ro.alexmamo.firestorepaginationjetpackcompose.presentation.products.components.ProductCard
import ro.alexmamo.firestorepaginationjetpackcompose.presentation.products.components.ProductsTopBar

@Composable
@InternalCoroutinesApi
@ExperimentalPagingApi
@ExperimentalCoroutinesApi
fun ProductsScreen(
    navController: NavController,
    viewModel: ProductsViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            ProductsTopBar()
        }
    ) {
        val products = viewModel.products.collectAsLazyPagingItems()
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn {
                items(
                    items = products
                ) { product ->
                    product?.let {
                        ProductCard(
                            product = product,
                            onProductClick = {
                                val jsonProduct = Gson().toJson(product)
                                navController.navigate(ProductScreen.route + "/${jsonProduct}")
                            }
                        )
                    }
                }
            }

            products.apply {
                when {
                    loadState.refresh is Loading -> ProgressBar()
                    loadState.refresh is Error -> printError(products.loadState.refresh as Error)
                    loadState.append is Loading -> ProgressBar()
                    loadState.append is Error -> printError(products.loadState.append as Error)
                }
            }
        }
    }
}