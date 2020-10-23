package com.example.belltest.ui.ui.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.belltest.ui.ui.pojo.ImageWithTitleAndError
import com.example.fragmentcommunicate.api.FetchData

class ThirdViewModel(nameSpace: String?, alias: String?) : ViewModel() {

    var movieCollection: LiveData<ImageWithTitleAndError> =
        FetchData().loadThirdEndPoint(nameSpace, alias)

    fun observeMovieData(): LiveData<ImageWithTitleAndError> {
        return movieCollection
    }
}