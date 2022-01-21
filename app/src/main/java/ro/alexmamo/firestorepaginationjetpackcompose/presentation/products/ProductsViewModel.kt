package ro.alexmamo.firestorepaginationjetpackcompose.presentation.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import ro.alexmamo.firestorepaginationjetpackcompose.domain.use_case.UseCases
import javax.inject.Inject

@HiltViewModel
@ExperimentalPagingApi
class ProductsViewModel @Inject constructor(
    useCases: UseCases
): ViewModel() {
    val products = useCases.getProducts().cachedIn(viewModelScope)
}