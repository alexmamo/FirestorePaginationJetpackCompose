package ro.alexmamo.firestorepaginationjetpackcompose.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import ro.alexmamo.firestorepaginationjetpackcompose.domain.repository.ProductsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductsRepositoryImpl @Inject constructor(
    private val source: FirestorePagingSource,
    private val config: PagingConfig
): ProductsRepository {
    override fun getProducts() = Pager(
        config = config
    ) {
        source
    }.flow
}