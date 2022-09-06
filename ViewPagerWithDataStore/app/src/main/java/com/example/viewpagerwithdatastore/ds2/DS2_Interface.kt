package com.example.viewpagerwithdatastore.ds2

import com.example.viewpagerwithdatastore.datastore.Data_DS_One
import kotlinx.coroutines.flow.Flow

interface DS2_Interface {

    suspend fun saveDataStore2(dataDsTwo: Data_DS_Two)

    suspend fun getDataStore2(): Flow<Data_DS_Two>

}