package ro.alexmamo.firestorepaginationjetpackcompose.navigation

import ro.alexmamo.firestorepaginationjetpackcompose.core.Constants.PRODUCTS_SCREEN
import ro.alexmamo.firestorepaginationjetpackcompose.core.Constants.PRODUCT_SCREEN

sealed class Screen(val route: String) {
    object ProductsScreen: Screen(PRODUCTS_SCREEN)
    object ProductScreen: Screen(PRODUCT_SCREEN)
}