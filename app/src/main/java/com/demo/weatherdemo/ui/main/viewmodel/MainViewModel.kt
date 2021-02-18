package com.demo.weatherdemo.ui.main.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.demo.weatherdemo.data.model.MainData
import com.demo.weatherdemo.data.model.MyInitParams
import com.demo.weatherdemo.data.repository.MainRepository
import com.demo.weatherdemo.utils.NetworkHelper
import com.demo.weatherdemo.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel  @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {
    private val _users = MutableLiveData<Resource<MainData>>()
    val users: LiveData<Resource<MainData>>
        get() = _users

    init {

    }

    public fun fetchData(city:String) {
        viewModelScope.launch {
            _users.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {

                mainRepository.getUsers(city,"metric","65d00499677e59496ca2f318eb68c049").let {
                    if (it.isSuccessful) {
                        _users.postValue(Resource.success(it.body()))
                    } else _users.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _users.postValue(Resource.error("No internet connection", null))
        }
    }



}