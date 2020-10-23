package com.example.belltest.ui.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.belltest.ui.ui.pojo.MovieCollectionWithError
import com.example.fragmentcommunicate.api.FetchData

class SecondViewModel(application: Application, nameSpace: String?, alias: String?) : AndroidViewModel(application) {

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