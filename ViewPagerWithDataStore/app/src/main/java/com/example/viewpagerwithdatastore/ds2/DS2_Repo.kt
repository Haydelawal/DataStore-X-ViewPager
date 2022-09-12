package com.example.viewpagerwithdatastore.ds2

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.viewpagerwithdatastore.datastore.DS_One_Interface
import com.example.viewpagerwithdatastore.datastore.Data_DS_One
import com.example.viewpagerwithdatastore.datastore.datastore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

const val DataStore_NAME = "DataStore_Two"

val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = DataStore_NAME)


class DS2_Repo(private val context: Context) : DS2_Interface {

    companion object {
        val FINISHED = booleanPreferencesKey("FINISHED")

    }

    override suspend fun saveDataStore2(dataDsTwo: Data_DS_Two) {
        context.datastore.edit { DS2s ->
            DS2s[FINISHED] = dataDsTwo.finished

        }
    }

    override suspend fun getDataStore2(): Flow<Data_DS_Two> =
        context.datastore.data.map { ds2 ->
            Data_DS_Two(
                finished = ds2[FINISHED] ?: false
            )

        }

}
