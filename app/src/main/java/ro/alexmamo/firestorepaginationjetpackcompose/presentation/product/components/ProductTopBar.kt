package ro.alexmamo.firestorepaginationjetpackcompose.presentation.product.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import kotlinx.coroutines.InternalCoroutinesApi
import ro.alexmamo.firestorepaginationjetpackcompose.core.Constants.PRODUCT_SCREEN

@Composable
@InternalCoroutinesApi
fun ProductTopBar(
    navController: NavController
) {
    TopAppBar (
        title = {
            Text(
                text = PRODUCT_SCREEN
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null,
                )
            }
        }
    )
}