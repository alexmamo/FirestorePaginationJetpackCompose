package ro.alexmamo.firestorepaginationjetpackcompose.di

import androidx.paging.PagingConfig
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.Query.Direction.ASCENDING
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import ro.alexmamo.firestorepaginationjetpackcompose.core.Constants.NAME
import ro.alexmamo.firestorepaginationjetpackcompose.core.Constants.PAGE_SIZE
import ro.alexmamo.firestorepaginationjetpackcompose.core.Constants.PRODUCTS
import ro.alexmamo.firestorepaginationjetpackcompose.data.repository.FirestorePagingSource
import ro.alexmamo.firestorepaginationjetpackcompose.data.repository.ProductsRepositoryImpl
import ro.alexmamo.firestorepaginationjetpackcompose.domain.repository.ProductsRepository

@Module
@ExperimentalCoroutinesApi
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideQueryProductsByName() = Firebase.firestore
        .collection(PRODUCTS)
        .orderBy(NAME, ASCENDING)
        .limit(PAGE_SIZE)

    @Provides
    fun provideFirestorePagingSource(
        queryProductsByName: Query
    ) = FirestorePagingSource(
        queryProductsByName = queryProductsByName
    )

    @Provides
    fun providePagingConfig() = PagingConfig(
        pageSize = PAGE_SIZE.toInt()
    )

    @Provides
    fun provideProductsRepository(
        source: FirestorePagingSource,
        config: PagingConfig
    ): ProductsRepository = ProductsRepositoryImpl(
        source = source,
        config = config
    )
}