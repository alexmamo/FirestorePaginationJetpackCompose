package ro.alexmamo.firestorepaginationjetpackcompose.presentation.product.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import kotlinx.coroutines.InternalCoroutinesApi
import ro.alexmamo.firestorepaginationjetpackcompose.core.Constants.PRODUCT_SCREEN

@Composable
@InternalCoroutinesApi
fun ProductTopBar(
    navigateBack: () -> Unit
) {
    TopAppBar (
        title = {
            Text(
                text = PRODUCT_SCREEN
            )
        },
        navigationIcon = {
            IconButton(
                onClick = navigateBack
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null,
                )
            }
        }
    )
}