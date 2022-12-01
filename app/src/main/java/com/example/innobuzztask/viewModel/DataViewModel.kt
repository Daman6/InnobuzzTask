package com.example.innobuzztask.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.innobuzztask.model.ResponseDataModel
import com.example.innobuzztask.model.ResponseDataModelItem
import com.example.innobuzztask.repo.DataRepo
import com.example.innobuzztask.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class DataViewModel(val repo: DataRepo):ViewModel() {

    val getData : MutableLiveData<Resource<ResponseDataModel>> = MutableLiveData()

    init {
        getDataResponse()
    }

    fun getDataResponse() =viewModelScope.launch {
        getData.postValue(Resource.Loading())
        val response = repo.getAllData()
        getData.postValue(handleGetNetworkResponse(response))
    }

    private fun handleGetNetworkResponse(response: Response<ResponseDataModel>) : Resource<ResponseDataModel>{
        if (response.isSuccessful){
            response.body()?.let {networkResponse ->
                return Resource.Success(networkResponse)
            }
        }
        return Resource.Error(response.message())
    }
    fun saveData(response: ResponseDataModelItem){
        viewModelScope.launch {
            repo.upsert(response)
        }
    }
    fun getAllDataLocally()= repo.getAllDataLocally()

}