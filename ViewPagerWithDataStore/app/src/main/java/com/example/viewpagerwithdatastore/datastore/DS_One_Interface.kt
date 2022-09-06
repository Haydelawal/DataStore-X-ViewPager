package com.example.viewpagerwithdatastore.datastore

import kotlinx.coroutines.flow.Flow

interface DS_One_Interface {

        suspend fun saveDataStore1(dataDSOne: Data_DS_One)

        suspend fun getDataStore1(): Flow<Data_DS_One>

}