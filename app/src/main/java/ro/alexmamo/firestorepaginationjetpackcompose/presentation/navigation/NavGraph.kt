package ro.alexmamo.firestorepaginationjetpackcompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.paging.ExperimentalPagingApi
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import ro.alexmamo.firestorepaginationjetpackcompose.domain.model.Product
import ro.alexmamo.firestorepaginationjetpackcompose.presentation.navigation.Screen.ProductScreen
import ro.alexmamo.firestorepaginationjetpackcompose.presentation.navigation.Screen.ProductsScreen
import ro.alexmamo.firestorepaginationjetpackcompose.presentation.product.ProductScreen
import ro.alexmamo.firestorepaginationjetpackcompose.presentation.products.ProductsScreen

@Composable
@InternalCoroutinesApi
@ExperimentalPagingApi
@ExperimentalCoroutinesApi
fun NavGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ProductsScreen.route
    ) {
        composable(
            route = ProductsScreen.route
        ) {
            ProductsScreen(
                navController = navController
            )
        }
        composable(
            route = ProductScreen.route + "/{jsonProduct}",
            arguments = listOf(
                navArgument("jsonProduct") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val jsonProduct = backStackEntry.arguments?.getString("jsonProduct") ?: ""
            val product = Gson().fromJson(jsonProduct, Product::class.java)
            ProductScreen(
                navController = navController,
                product = product
            )
        }
    }
}