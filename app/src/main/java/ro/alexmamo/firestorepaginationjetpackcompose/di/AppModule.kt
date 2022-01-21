package ro.alexmamo.firestorepaginationjetpackcompose.di

import androidx.paging.PagingConfig
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.Query.Direction.ASCENDING
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import ro.alexmamo.firestorepaginationjetpackcompose.core.Constants.NAME
import ro.alexmamo.firestorepaginationjetpackcompose.core.Constants.PAGE_SIZE
import ro.alexmamo.firestorepaginationjetpackcompose.core.Constants.PRODUCTS
import ro.alexmamo.firestorepaginationjetpackcompose.data.repository.ProductsRepositoryImpl
import ro.alexmamo.firestorepaginationjetpackcompose.domain.repository.ProductsRepository
import ro.alexmamo.firestorepaginationjetpackcompose.domain.use_case.GetProducts
import ro.alexmamo.firestorepaginationjetpackcompose.domain.use_case.UseCases
import ro.alexmamo.firestorepaginationjetpackcompose.data.repository.FirestorePagingSource

@Module
@ExperimentalCoroutinesApi
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideQueryProductsByName() = FirebaseFirestore.getInstance()
        .collection(PRODUCTS)
        .orderBy(NAME, ASCENDING)
        .limit(PAGE_SIZE)

    @Provides
    fun provideFirestorePagingSource(
        queryProductsByName: Query
    ) = FirestorePagingSource(queryProductsByName)

    @Provides
    fun providePagingConfig() = PagingConfig(
        pageSize = PAGE_SIZE.toInt()
    )

    @Provides
    fun provideProductsRepository(
        source: FirestorePagingSource,
        config: PagingConfig
    ): ProductsRepository = ProductsRepositoryImpl(source, config)

    @Provides
    fun provideUseCases(repository: ProductsRepository) = UseCases(
        getProducts = GetProducts(repository)
    )
}