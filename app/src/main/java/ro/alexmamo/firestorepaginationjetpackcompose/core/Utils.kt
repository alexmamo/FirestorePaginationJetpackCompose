package ro.alexmamo.firestorepaginationjetpackcompose.core

import android.util.Log
import androidx.paging.LoadState
import ro.alexmamo.firestorepaginationjetpackcompose.core.Constants.TAG

class Utils {
    companion object {
        fun print(errorState: LoadState.Error) {
            val error = errorState.error
            Log.d(TAG, error.message ?: error.toString())
        }
    }
}