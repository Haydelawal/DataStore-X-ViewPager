package com.example.viewpagerwithdatastore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewpagerwithdatastore.datastore.Data_DS_One
import com.example.viewpagerwithdatastore.ds2.DS2_Repo
import com.example.viewpagerwithdatastore.ds2.Data_DS_Two
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DS2_ViewModel @Inject constructor(private  val ds2Repo: DS2_Repo): ViewModel() {

    var finished: MutableLiveData<Boolean> = MutableLiveData(false)


    var data_DS_Two: MutableLiveData<Data_DS_Two> = MutableLiveData()

    ///// me

    fun showTheData(): LiveData<Data_DS_Two> {
        return data_DS_Two
    }

    /////
    fun saveData() {
        viewModelScope.launch(Dispatchers.IO) {
            ds2Repo.saveDataStore2(
                Data_DS_Two(
                    finished = finished.value!!
                )
            )
        }
    }

    fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            ds2Repo.getDataStore2().collect {
                data_DS_Two.postValue(it)
            }
        }
    }
}