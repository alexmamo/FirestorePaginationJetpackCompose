package ro.alexmamo.firestorepaginationjetpackcompose.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ro.alexmamo.firestorepaginationjetpackcompose.domain.model.Product

interface ProductsRepository {
    fun getProducts(): Flow<PagingData<Product>>
}