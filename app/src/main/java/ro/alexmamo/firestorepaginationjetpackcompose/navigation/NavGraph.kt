package ro.alexmamo.firestorepaginationjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.paging.ExperimentalPagingApi
import com.google.gson.Gson
import ro.alexmamo.firestorepaginationjetpackcompose.domain.model.Product
import ro.alexmamo.firestorepaginationjetpackcompose.navigation.Screen.ProductScreen
import ro.alexmamo.firestorepaginationjetpackcompose.navigation.Screen.ProductsScreen
import ro.alexmamo.firestorepaginationjetpackcompose.presentation.product.ProductScreen
import ro.alexmamo.firestorepaginationjetpackcompose.presentation.products.ProductsScreen

@Composable
@ExperimentalPagingApi
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
                navigateToProductScreen = { product ->
                    val jsonProduct = Gson().toJson(product)
                    navController.navigate("${ProductScreen.route}/${jsonProduct}")
                }
            )
        }
        composable(
            route = "${ProductScreen.route}/{jsonProduct}",
            arguments = listOf(
                navArgument("jsonProduct") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val jsonProduct = backStackEntry.arguments?.getString("jsonProduct") ?: ""
            val product = Gson().fromJson(jsonProduct, Product::class.java)
            ProductScreen(
                product = product,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}