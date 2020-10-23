package com.example.fragmentcommunicate.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.belltest.ui.ui.ImagewithTitle
import com.example.belltest.ui.ui.pojo.ImageWithTitleAndError
import com.example.belltest.ui.ui.pojo.MovieCollectionWithError
import com.example.belltest.ui.ui.pojo.ScreenListWithError
import com.example.fragmentcommunicate.Pojo.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FetchData {

    val api = RetrofitInstance().api

    fun loadFirstEndPoint(): LiveData<ScreenListWithError> {
        val liveScreens = MutableLiveData<ScreenListWithError>()
        val call = api.getMovies()
        call.enqueue(object : Callback<Movies> {
            override fun onFailure(call: Call<Movies>, t: Throwable) {
                liveScreens.value = ScreenListWithError(t.message, emptyList())
            }

            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response.isSuccessful) {
                    val screens =
                        if (response.isSuccessful) response.body()?.screens else emptyList()
                    liveScreens.value = ScreenListWithError(null, screens)
                } else {
                    liveScreens.value =
                        ScreenListWithError(response.errorBody().toString(), emptyList())
                }
            }
        }
        )

        return liveScreens
    }


    fun loadSecondEndPoint(
        title: String?,
        screenType: String?
    ): MutableLiveData<MovieCollectionWithError> {
        val liveScreens = MutableLiveData<MovieCollectionWithError>()
        if (screenType == null || title == null) return MutableLiveData(
            MovieCollectionWithError(
                "$title or $screenType is empty",
                emptyList()
            )
        )
        val call = api.getScreen(title, screenType)

        call.enqueue(object : Callback<PojoTwo> {
            override fun onFailure(call: Call<PojoTwo>, t: Throwable) {
                liveScreens.value = MovieCollectionWithError(null, emptyList())
            }

            override fun onResponse(call: Call<PojoTwo>, response: Response<PojoTwo>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    liveScreens.value = MovieCollectionWithError(null, responseBody?.collections)
                } else {
                    liveScreens.value =
                        MovieCollectionWithError(response.errorBody().toString(), emptyList())
                }
            }
        }

        )

        return liveScreens
    }


    fun loadThirdEndPoint(
        nameSpace: String?,
        alias: String?
    ): MutableLiveData<ImageWithTitleAndError> {

        val imageLiveData = MutableLiveData<ImageWithTitleAndError>()
        if (nameSpace == null || alias == null) return MutableLiveData(ImageWithTitleAndError("$nameSpace or $alias is empty", emptyList()))
        val call = api.getThird(nameSpace, alias)
        call.enqueue(object : Callback<MovieSummary> {
            override fun onFailure(call: Call<MovieSummary>, t: Throwable) {
                imageLiveData.value = ImageWithTitleAndError(t.message, emptyList())
            }

            override fun onResponse(call: Call<MovieSummary>, response: Response<MovieSummary>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    val imageList = responseBody?.content?.map {
                        it.axisId to ImagewithTitle(
                            it.title,
                            it.images.poster.firstOrNull(),
                            it.summary
                        )
                    }?.toMap()?.values?.toList()
                    imageLiveData.value = ImageWithTitleAndError(null, imageList)
                } else {
                    imageLiveData.value = ImageWithTitleAndError(response.errorBody().toString(), emptyList())
                }
            }
        }

        )

        return imageLiveData

    }


}