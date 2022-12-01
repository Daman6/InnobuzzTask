package com.example.innobuzztask.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.innobuzztask.repo.DataRepo

class DataViewModelProviderFactory(val repo: DataRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DataViewModel(repo) as T
    }
}