package com.battot.mvi.di

import com.battot.mvi.common.Constant
import com.battot.mvi.data.remote.ApiService
import com.battot.mvi.data.repository.MainRepositoryImp
import com.battot.mvi.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideApi() : ApiService {

       val api =  Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
        return api
    }


    @Singleton
    @Provides
    fun provideMainRepository(
         apiService: ApiService
    ) : MainRepository {
        return MainRepositoryImp(apiService)
    }



}