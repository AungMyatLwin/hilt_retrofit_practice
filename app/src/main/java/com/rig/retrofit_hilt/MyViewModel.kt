package com.rig.retrofit_hilt

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.rig.retrofit_hilt.data.Element
import com.rig.retrofit_hilt.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
     val element = MutableLiveData<Response<Element>>()
    fun getElement(){
        viewModelScope.launch(Dispatchers.IO) {
            var elements = async {
                repository.getElement()
            }
            element.postValue(elements.await())
        }
    }
}