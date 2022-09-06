package com.example.viewpagerwithdatastore.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

const val DataStore_NAME = "DataStore_One"

val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = DataStore_NAME)


class DataStoreRepo1(private val context: Context) : DS_One_Interface {

    companion object {
        val NAME = stringPreferencesKey("NAME")
        val AGE = stringPreferencesKey("AGE")
        val FOOD = stringPreferencesKey("FOOD")
    }

    override suspend fun saveDataStore1(dataDSOne: Data_DS_One) {
        context.datastore.edit { dataDSOnes ->
            dataDSOnes[NAME] = dataDSOne.name
            dataDSOnes[AGE] = dataDSOne.age
            dataDSOnes[FOOD] = dataDSOne.food

        }
    }

    override suspend fun getDataStore1(): Flow<Data_DS_One> =
        context.datastore.data.map { dataDSOnes ->

            Data_DS_One(
                name = dataDSOnes[NAME]!!,
                age = dataDSOnes[AGE]!!,
                food = dataDSOnes[FOOD]!!
            )

        }

//
//    override suspend fun getPhoneBook() = context.datastore.data.map { phonebook ->
//        Phonebook(
//            name = phonebook[NAME]!!,
//            address = phonebook[FOOD]!!,
//            phone = phonebook[AGE]!!
//        )
//    }
}