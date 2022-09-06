package com.example.viewpagerwithdatastore.hilt

import android.content.Context
import com.example.viewpagerwithdatastore.datastore.DataStoreRepo1
import com.example.viewpagerwithdatastore.ds2.DS2_Repo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Singleton
    @Provides
    fun provideDataStoreRepository(@ApplicationContext context: Context)= DataStoreRepo1(context)

    @Singleton
    @Provides
    fun provideDataStoreRepository2(@ApplicationContext context: Context)= DS2_Repo(context)
}