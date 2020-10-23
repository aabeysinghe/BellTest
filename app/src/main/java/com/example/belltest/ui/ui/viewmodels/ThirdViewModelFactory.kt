package com.example.belltest.ui.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class ThirdViewModelFactory(
    private val namespace: String?,
    private val alias: String?
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ThirdViewModel(namespace, alias) as T
    }
}