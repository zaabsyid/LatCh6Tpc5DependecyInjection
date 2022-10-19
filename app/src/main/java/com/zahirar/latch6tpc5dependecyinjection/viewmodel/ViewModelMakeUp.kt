package com.zahirar.latch6tpc5dependecyinjection.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zahirar.latch6tpc5dependecyinjection.model.GetMakeUpResponseItem
import com.zahirar.latch6tpc5dependecyinjection.network.RestfulApi
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ViewModelMakeUp @Inject constructor(var api : RestfulApi) : ViewModel() {

    lateinit var liveDataMakeUp : MutableLiveData<List<GetMakeUpResponseItem>>

    init {
        liveDataMakeUp = MutableLiveData()
    }

    fun getLDMakeUp() : MutableLiveData<List<GetMakeUpResponseItem>> {
        return liveDataMakeUp
    }

    fun callApiMakeUp(){
        api.getAllMakeUp()
            .enqueue(object : Callback<List<GetMakeUpResponseItem>> {
                override fun onResponse(
                    call: Call<List<GetMakeUpResponseItem>>,
                    response: Response<List<GetMakeUpResponseItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataMakeUp.postValue(response.body())
                    } else{
                        liveDataMakeUp.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<GetMakeUpResponseItem>>, t: Throwable) {
                    liveDataMakeUp.postValue(null)
                }

            })
    }
}