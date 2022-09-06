package com.example.viewpagerwithdatastore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewpagerwithdatastore.datastore.DataStoreRepo1
import com.example.viewpagerwithdatastore.datastore.Data_DS_One
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private  val dataStoreRepo1: DataStoreRepo1): ViewModel() {

    var age: MutableLiveData<String> = MutableLiveData("")
    var food: MutableLiveData<String> = MutableLiveData("")
    var name: MutableLiveData<String> = MutableLiveData("")

    var data_DS_One: MutableLiveData<Data_DS_One> = MutableLiveData()

    ///// me

    fun showTheData(): LiveData<Data_DS_One> {
        return data_DS_One
    }

    /////
    fun saveData() {
        viewModelScope.launch(Dispatchers.IO) {
            dataStoreRepo1.saveDataStore1(
                Data_DS_One(
                    age = age.value!!,
                    food = food.value!!,
                    name = name.value!!
                )
            )
        }
    }

    fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            dataStoreRepo1.getDataStore1().collect {
                data_DS_One.postValue(it)
            }
        }
    }
}