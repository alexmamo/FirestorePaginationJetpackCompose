package ro.alexmamo.firestorepaginationjetpackcompose.presentation.product.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ro.alexmamo.firestorepaginationjetpackcompose.domain.model.Product

@Composable
fun ProductContent(
    padding: PaddingValues,
    product: Product
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp, start = 8.dp)
        ) {
            product.apply {
                name?.let {
                    Text(
                        text = "name: $name",
                        fontSize = 24.sp
                    )
                }
                price?.let {
                    Text(
                        text = "price: $$price",
                        fontSize = 24.sp
                    )
                }
            }
        }
    }
}