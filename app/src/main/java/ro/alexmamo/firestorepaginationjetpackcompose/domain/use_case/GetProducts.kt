package ro.alexmamo.firestorepaginationjetpackcompose.domain.use_case

import ro.alexmamo.firestorepaginationjetpackcompose.domain.repository.ProductsRepository

class GetProducts(
    private val repository: ProductsRepository
) {
    operator fun invoke() = repository.getProducts()
}