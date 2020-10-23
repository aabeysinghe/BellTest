package com.example.belltest.ui.ui.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class SecondViewModelFactory(val application: Application,  private val namespace: String?,
                             private val alias: String?): ViewModelProvider.AndroidViewModelFactory(application) {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SecondViewModel(
            application, namespace, alias
        ) as T
    }

}