package com.example.belltest.ui.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.belltest.ui.ui.pojo.ScreenAndError
import com.example.belltest.ui.ui.pojo.ScreenListWithError
import com.example.fragmentcommunicate.api.FetchData

class FirstViewModel : ViewModel() {

    var screens: LiveData<ScreenListWithError>

    init {
        screens = FetchData().loadFirstEndPoint()
    }

    fun getSelectedTitleandScreenType(): ScreenAndError? {
        if (screens.value?.error != null) return ScreenAndError(screens.value?.error, null)
        val screen =
            screens.value?.scrrenList?.filter { screen -> screen.title.toLowerCase() == "kids" && screen.screenType.toLowerCase() == "home" }
                ?.firstOrNull()
        return ScreenAndError(null, screen)
    }
}