package com.example.belltest.ui.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.belltest.ui.ui.pojo.MovieCollectionWithError
import com.example.fragmentcommunicate.api.FetchData

class SecondViewModel(nameSpace: String?, alias: String?) : ViewModel() {

    var movieCollection: LiveData<MovieCollectionWithError>

    init {
        movieCollection = FetchData().loadSecondEndPoint(nameSpace, alias)
    }

    fun observeMovieData(): LiveData<MovieCollectionWithError> {
        return movieCollection
    }

    fun getSelectedColection(): MovieCollectionWithError? {
        if (movieCollection.value?.error != null) return MovieCollectionWithError(
            movieCollection.value?.error,
            null
        )

        return MovieCollectionWithError(
            null,
            movieCollection.value?.scrrenList?.filter { screen -> screen.style == "posters" })

    }
}