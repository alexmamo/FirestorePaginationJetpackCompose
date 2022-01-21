package ro.alexmamo.firestorepaginationjetpackcompose.core

import android.util.Log
import androidx.paging.LoadState
import ro.alexmamo.firestorepaginationjetpackcompose.core.Constants.TAG
import ro.alexmamo.firestorepaginationjetpackcompose.core.Constants.ERROR_MESSAGE

class Utils {
    companion object {
        fun printError(errorState: LoadState.Error) {
            Log.d(TAG, errorState.error.message ?: ERROR_MESSAGE)
        }
    }
}